package dev.yukiho.cers.repository;

import dev.yukiho.cers.db.mapper.StudentMapper;
import dev.yukiho.cers.db.model.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@MapperScan({"dev.yukiho.cers.db.mapper"})
public class StudentRepository {

    @Autowired
    StudentMapper studentMapper;

    public Student insertStudent(Student student) {
        studentMapper.insertSelective(student);
        return student;
    }

}
