package dev.yukiho.cers.repository;

import dev.yukiho.cers.mapper.RecordMapper;
import dev.yukiho.cers.model.RecordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordRepository {

    private RecordMapper recordMapper;

    @Autowired
    public RecordRepository(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

    public List<RecordModel> selectAllRecord() {
        return recordMapper.selectAllRecord();
    }

    public List<RecordModel> selectAllRecord(int maxRecord) {
        return recordMapper.selectAllRecordLimited(maxRecord);
    }
}
