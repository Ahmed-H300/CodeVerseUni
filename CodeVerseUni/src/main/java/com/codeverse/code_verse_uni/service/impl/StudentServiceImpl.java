package com.codeverse.code_verse_uni.service.impl;

import com.codeverse.code_verse_uni.dao.CourseRepository;
import com.codeverse.code_verse_uni.dao.StudentRepository;
import com.codeverse.code_verse_uni.dto.StudentDTO;
import com.codeverse.code_verse_uni.entity.Course;
import com.codeverse.code_verse_uni.entity.Student;
import com.codeverse.code_verse_uni.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public Student save(StudentDTO studentDTO) {
        List<Integer> courseIds = studentDTO.getCourseIds();
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setCourses(null);
        if (courseIds != null){
            for (Integer courseId : courseIds) {
                Course course1 = courseRepository.findById(courseId).orElse(null);
                if (course1 == null){
                    continue;
                }
                course1.setReviews(null);
                student.addCourse(course1);
            }
        }
        return studentRepository.save(student);
    }

    @Override
    public Student findById(int id) {

        Student student = studentRepository.findById(id).orElse(null);
        if (student == null){
            return null;
        }
        student.setCourses(null);
        return student;
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {

        Page<Student> studentPage = studentRepository.findAll(pageable);
        for (Student student : studentPage.getContent()) {
            student.setCourses(null);
        }
        return studentPage;
    }

    @Override
    public Student findByIdWithCourses(int id) {

        Student student = studentRepository.findByIdWithCourses(id);
        if (student == null){
            return null;
        }
        List<Course> courses =  student.getCourses();
        for ( Course course : courses) {
            course.setReviews(null);
        }
        student.setCourses(courses);
        return student;

    }

    @Override
    public Page<Student> findAllByCourseId(int id, Pageable pageable) {
        Page<Student> studentPage = studentRepository.findAllByCourseId(id, pageable);
        for (Student student : studentPage.getContent()) {
            student.setCourses(null);
        }
        return studentPage;
    }

    @Override
    public boolean doesExist(int id) {
        return studentRepository.existsById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
