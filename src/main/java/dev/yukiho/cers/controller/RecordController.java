package dev.yukiho.cers.controller;

import dev.yukiho.cers.enums.ModeEnum;
import dev.yukiho.cers.model.input.RecordInputModel;
import dev.yukiho.cers.model.output.RecordOutputModel;
import dev.yukiho.cers.service.EventService;
import dev.yukiho.cers.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/record")
@Api(
        tags = "Record"
)
public class RecordController {

    StudentService studentService;
    EventService eventService;

    public RecordController(@Autowired StudentService studentService,
                            @Autowired EventService eventService) {
        this.studentService = studentService;
        this.eventService = eventService;
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

        return recordOutputModel;
    }
}
