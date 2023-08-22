package com.codeverse.code_verse_uni.service.impl;

import com.codeverse.code_verse_uni.dao.StudentRepository;
import com.codeverse.code_verse_uni.entity.Student;
import com.codeverse.code_verse_uni.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student course) {
        return studentRepository.save(course);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findByIdWithCourses(int id) {
        return studentRepository.findByIdWithCourses(id);
    }

    @Override
    public boolean doesExist(int id) {
        return studentRepository.existsById(id);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
