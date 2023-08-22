package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.entity.Student;

import java.util.List;

public interface StudentService {

    public Student save(Student course);

    public Student findById(int id);

    public List<Student> findAll();

    public Student findByIdWithCourses(int id);

    public boolean doesExist(int id);

    public void deleteById(int id);
}
