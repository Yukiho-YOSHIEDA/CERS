package dev.yukiho.cers.repository;

import dev.yukiho.cers.db.mapper.StudentMapper;
import dev.yukiho.cers.db.model.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StudentRepository {

    StudentMapper studentMapper;

    public StudentRepository(@Autowired StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Student insertStudent(Student record) {
        studentMapper.insertSelective(record);
        return record;
    }

    public Optional<Student> selectById(String id) {
        return Optional.ofNullable(studentMapper.selectByPrimaryKey(id));
    }

}
