package com.codeverse.code_verse_uni.service.impl;

import com.codeverse.code_verse_uni.dao.CourseRepository;
import com.codeverse.code_verse_uni.dto.CourseDTO;
import com.codeverse.code_verse_uni.entity.Course;
import com.codeverse.code_verse_uni.entity.Instructor;
import com.codeverse.code_verse_uni.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final InstructorServiceImpl instructorService;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, InstructorServiceImpl instructorService) {
        this.courseRepository = courseRepository;
        this.instructorService = instructorService;
    }

    @Override
    @Transactional
    public Course save(CourseDTO courseDTO) {
        Instructor instructor = instructorService.findById(courseDTO.getInstructorId());
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setTitle(courseDTO.getTitle());
        course.setInstructor(instructor);
        course.setReviews(null);
        course.setStudents(null);
        return courseRepository.save(course);
    }

    @Override
    public Course findById(int id) {

        Course course = courseRepository.findById(id).orElse(null);
        if (course == null){
            return null;
        }
        course.setReviews(null);
        course.setStudents(null);
        course.setInstructor(null);
        return course;
    }

    @Override
    public Page<Course> findAll(Pageable pageable) {

        Page<Course> coursePage = courseRepository.findAll(pageable);

        for (Course course : coursePage.getContent()) {
            course.setReviews(null);
            course.setStudents(null);
            course.setInstructor(null);
        }
        return coursePage;
    }

    @Override
    public Page<Course> findByIdWithReviews(int id, Pageable pageable) {
        Page<Course> coursePage = courseRepository.findByIdWithReviews(id, pageable);

        for (Course course : coursePage.getContent()) {
            course.setStudents(null);
            course.setInstructor(null);
        }
        return coursePage;
    }


    @Override
    public boolean doesExist(int id) {
        return courseRepository.existsById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Instructor findInstructorById(int id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null){
            return null;
        }
        Instructor instructor = course.getInstructor();
        instructor.setCourses(null);
        return instructor;
    }
}
