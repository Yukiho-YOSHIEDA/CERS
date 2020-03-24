package dev.yukiho.cers.service;

import dev.yukiho.cers.enums.ModeEnum;
import dev.yukiho.cers.model.output.RecordOutputModel;
import dev.yukiho.cers.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecordService {

    RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public String getCsvString() {
        var sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

        var csv = new StringBuilder();
        csv.append("\"学生番号\", \"氏名\", \"入室/退室\", \"時刻\"\n");
        var allRecord = getAllRecord();
        allRecord.forEach(record -> {
            csv.append(record.getId());
            csv.append(",");
            csv.append(record.getName());
            csv.append(",");
            csv.append(getModeJa(record.getMode()));
            csv.append(",");
            csv.append(sdf.format(record.getCreatedAt()));
            csv.append("\n");
        });
        return csv.toString();
    }

    public List<RecordOutputModel> getAllRecord() {
        var allRecord = recordRepository.selectAllRecord();
        return allRecord.stream()
                .map(record -> new RecordOutputModel(record.getId(), record.getName(),
                        ModeEnum.getModeById(record.getMode()).getName(), record.getAcceptedAt(), record.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public List<RecordOutputModel> getAllRecord(Optional<Integer> maxRecord) {
        var allRecord = recordRepository.selectAllRecord(maxRecord.orElse(100));
        return allRecord.stream()
                .map(record -> new RecordOutputModel(record.getId(), record.getName(),
                        ModeEnum.getModeById(record.getMode()).getName(), record.getAcceptedAt(), record.getCreatedAt()))
                .collect(Collectors.toList());
    }

    private String getModeJa(String modeStr) {
        return modeStr.equals("enter") ? "入室" : "退室";
    }
}
