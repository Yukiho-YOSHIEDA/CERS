package dev.yukiho.cers.repository;

import dev.yukiho.cers.db.mapper.EventMapper;
import dev.yukiho.cers.db.model.Event;
import dev.yukiho.cers.db.model.EventExample;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventRepository {

    EventMapper eventMapper;

    @Autowired
    public EventRepository(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    public Event insertEvent(Event record) {
        eventMapper.insertSelective(record);
        return record;
    }

    public Optional<Event> selectEventById(int id) {
        return Optional.ofNullable(eventMapper.selectByPrimaryKey(id));
    }

    public List<Event> selectEventByStudentId(String studentId) {
        var example = new EventExample();
        example.createCriteria()
                .andStudentIdEqualTo(studentId);
        example.setOrderByClause("created_at DESC");
        return eventMapper.selectByExample(example);
    }

    public List<Event> selectAll() {
        var example = new EventExample();
        return eventMapper.selectByExample(example);
    }

}
