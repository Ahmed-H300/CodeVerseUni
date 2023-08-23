package com.codeverse.code_verse_uni.service.impl;

import com.codeverse.code_verse_uni.dao.InstructorRepository;
import com.codeverse.code_verse_uni.entity.Course;
import com.codeverse.code_verse_uni.entity.Instructor;
import com.codeverse.code_verse_uni.service.InstructorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        if (instructor.getCourses() != null){
            for (Course course : instructor.getCourses()) {
                course.setInstructor(instructor);
            }
        }
        return instructorRepository.save(instructor);
    }
    @Override
    public Instructor findById(int id) {
        Instructor instructor = instructorRepository.findById(id).orElse(null);
        if (instructor == null){
            return null;
        }
        instructor.setCourses(null);
        return instructor;
    }

    @Override
    public Page<Instructor> findAll(Pageable pageable) {
        Page<Instructor> instructorPage = instructorRepository.findAll(pageable);

        for (Instructor instructor : instructorPage.getContent()) {
            instructor.setCourses(null);
        }

        return instructorPage;
    }


    @Override
    public Instructor findByIdAllDetails(int id) {
        Instructor instructor = instructorRepository.findByIdAllDetails(id);
        if (instructor == null){
            return null;
        }
        List<Course> courses =  instructor.getCourses();
        for ( Course course : courses) {
            course.setReviews(null);
        }
        instructor.setCourses(courses);
        return instructor;
    }

    @Override
    public boolean doesExist(int id) {
        return instructorRepository.existsById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        // set courses instructors to null
        Instructor instructor = instructorRepository.findById(id).orElse(null);
        if (instructor == null){
            return;
        }
        List<Course> courses = instructor.getCourses();
        if (courses != null){
            for (Course course : courses) {
                course.setInstructor(null);
            }
        }
        instructorRepository.deleteById(id);
    }
}
