package dev.yukiho.cers.controller;

import dev.yukiho.cers.enums.ModeEnum;
import dev.yukiho.cers.exception.BadRequestException;
import dev.yukiho.cers.model.input.RecordInputModel;
import dev.yukiho.cers.model.output.RecordOutputModel;
import dev.yukiho.cers.service.EventService;
import dev.yukiho.cers.service.RecordService;
import dev.yukiho.cers.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController()
@RequestMapping("/api/v1/records")
@Api(
        tags = "Record"
)
public class RecordController {

    StudentService studentService;
    EventService eventService;
    RecordService recordService;
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public RecordController(StudentService studentService,
                            EventService eventService,
                            RecordService recordService,
                            SimpMessagingTemplate simpMessagingTemplate) {
        this.studentService = studentService;
        this.eventService = eventService;
        this.recordService = recordService;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    @ApiOperation(
            value = "Record enter/leave data",
            notes = "Record enter/leave data and return result."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Recorded enter/leave data", response = RecordOutputModel.class)
    })
    public RecordOutputModel postRecord(
            @ApiParam(name = "record", required = true, value = "enter/leave data")
            @Validated @RequestBody RecordInputModel recordInputModel) {
        var student = studentService.createStudent(recordInputModel.getId(), recordInputModel.getName());
        var event = eventService.createEvent(recordInputModel.getId(), recordInputModel.getMode(),
                recordInputModel.getAcceptedAt());

        var modeName = ModeEnum.getModeById(event.getMode()).getName();
        var recordOutputModel = new RecordOutputModel(student.getId(), student.getName(), modeName,
                event.getAcceptedAt(), event.getCreatedAt());

        simpMessagingTemplate.convertAndSend("/record/updated", recordOutputModel);

        return recordOutputModel;
    }

    @GetMapping
    @ApiOperation(
            value = "Get All Records",
            notes = "Get All Records."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All records", response = RecordOutputModel.class)
    })
    public List<RecordOutputModel> getAllRecord(
            @ApiParam(name = "max", required = false, value = "max number of record")
            @RequestParam(name = "max", required = false) String maxRecordStr
    ) {
        Integer maxRecord = null;
        try {
            maxRecord = Integer.parseInt(maxRecordStr);
        } catch (NumberFormatException e) {
            if (Objects.nonNull(maxRecordStr) && !maxRecordStr.equals("")) {
                throw new BadRequestException("The parameter max is invalid.");
            }
        }
        return recordService.getAllRecord(Optional.ofNullable(maxRecord));
    }

    @GetMapping("/download/csv")
    public ResponseEntity<byte[]> csvDownload() throws UnsupportedEncodingException {
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "text/csv; charset=UTF-8");

        var date = new Date();
        var sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        var filename = "log_" + sdf.format(date) + ".csv";
        httpHeaders.setContentDispositionFormData("filename", filename);

        var csvData = recordService.getCsvString();

        return new ResponseEntity<>(csvData.getBytes("UTF-8"), httpHeaders, HttpStatus.OK);
    }
}
