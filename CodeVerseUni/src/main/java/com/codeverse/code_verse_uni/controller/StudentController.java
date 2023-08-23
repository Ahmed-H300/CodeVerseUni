package com.codeverse.code_verse_uni.controller;

import com.codeverse.code_verse_uni.dto.StudentDTO;
import com.codeverse.code_verse_uni.entity.Student;
import com.codeverse.code_verse_uni.exception.EntityNotFoundException;
import com.codeverse.code_verse_uni.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Add test API mapping
    @GetMapping("/hello")
    public String hello(){
        return "Hello From Student!";
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId) {
        Student student = studentService.findById(studentId);
        if (student == null) {
            throw new EntityNotFoundException("Student id not found - " + studentId);
        }
        return student;
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody StudentDTO studentDTO) {
        studentDTO.setId(0);
        return studentService.save(studentDTO);
    }

    @PutMapping("/")
    public Student updateStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO);
    }

    @GetMapping("/all")
    public Page<Student> getAllStudents(@PageableDefault(size = 10) Pageable pageable) {
        return studentService.findAll(pageable);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
        if (!studentService.doesExist(studentId)) {
            throw new EntityNotFoundException("Student id not found - " + studentId);
        }
        studentService.deleteById(studentId);
        return ResponseEntity.ok("Deleted student id - " + studentId);
    }

    @GetMapping("/exists/{studentId}")
    public ResponseEntity<Boolean> doesExist(@PathVariable("studentId") int studentId) {
        return ResponseEntity.ok(studentService.doesExist(studentId));
    }

    @GetMapping("/course/{courseId}")
    public Page<Student> getAllStudentsByCourseId(@PathVariable("courseId") int courseId, @PageableDefault(size = 10) Pageable pageable) {
        return studentService.findAllByCourseId(courseId, pageable);
    }

    @GetMapping("/details/{studentId}")
    public Student findByIdWithCourses(@PathVariable("studentId") int studentId) {
        Student student = studentService.findByIdWithCourses(studentId);
        if (student == null) {
            throw new EntityNotFoundException("Student id not found - " + studentId);
        }
        return student;
    }

}
