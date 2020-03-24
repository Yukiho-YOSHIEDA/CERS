package dev.yukiho.cers.mapper;

import dev.yukiho.cers.model.RecordModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {

    List<RecordModel> selectAllRecord();

    List<RecordModel> selectAllRecordLimited(int maxRecord);
}
