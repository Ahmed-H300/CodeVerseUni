package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseService {

    public Course save(Course course);

    public Course findById(int id);

    public Page<Course> findAll(Pageable pageable);

    public List<Course> findByInstructorId(int id);

    public Course findByIdWithReviews(int id);

    public Course findByIdWithStudents(int id);

    public boolean doesExist(int id);

    public void deleteById(int id);


}
