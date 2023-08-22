package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface StudentService {

    public Student save(Student course);

    public Student findById(int id);

    public Page<Student> findAll(Pageable pageable);

    public Student findByIdWithCourses(int id);

    public boolean doesExist(int id);

    public void deleteById(int id);
}
