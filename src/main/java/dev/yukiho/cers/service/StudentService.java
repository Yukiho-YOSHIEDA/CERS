package dev.yukiho.cers.service;

import dev.yukiho.cers.db.model.Student;
import dev.yukiho.cers.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {


    private StudentRepository studentRepository;

    public StudentService(@Autowired StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(String id, String name) {
        // check duplicate
        var student = studentRepository.selectById(id)
                .orElseGet(() -> {
                    Student record = new Student();
                    record.setId(id);
                    record.setName(name);
                    studentRepository.insertStudent(record);
                    return record;
                });

        return student;
    }
}
