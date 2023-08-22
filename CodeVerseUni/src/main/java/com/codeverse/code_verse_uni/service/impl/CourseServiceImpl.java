package com.codeverse.code_verse_uni.service.impl;

import com.codeverse.code_verse_uni.dao.CourseRepository;
import com.codeverse.code_verse_uni.entity.Course;
import com.codeverse.code_verse_uni.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findById(int id) {
        Optional<Course> result = courseRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public List<Course> findByInstructorId(int id) {
        return courseRepository.findByInstructorId(id);
    }

    @Override
    public Course findByIdWithReviews(int id) {
        return courseRepository.findByIdWithReviews(id);
    }

    @Override
    public Course findByIdWithStudents(int id) {
        return courseRepository.findByIdWithStudents(id);
    }

    @Override
    public boolean doesExist(int id) {
        return courseRepository.existsById(id);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }
}
