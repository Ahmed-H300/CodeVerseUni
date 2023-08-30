package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.dto.CourseDTO;
import com.codeverse.code_verse_uni.entity.Course;
import com.codeverse.code_verse_uni.entity.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {

    public Course save(CourseDTO courseDTO);

    public Course findById(int id);

    public Page<Course> findAll(Pageable pageable);

    public Page<Course> findByIdWithReviews(int id, Pageable pageable);

    public boolean doesExist(int id);

    public void deleteById(int id);

    public Instructor findInstructorById(int id);


}
