package com.codeverse.code_verse_uni.controller;


import com.codeverse.code_verse_uni.dto.CourseDTO;
import com.codeverse.code_verse_uni.entity.Course;
import com.codeverse.code_verse_uni.exception.EntityNotFoundException;
import com.codeverse.code_verse_uni.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses/")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Add test API mapping
    @GetMapping("/hello")
    public String hello(){
        return "Hello From Course!";
    }

    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable("courseId") int courseId) {
        Course course = courseService.findById(courseId);
        if (course == null) {
            throw new EntityNotFoundException("Course id not found - " + courseId);
        }
        return course;
    }

    @PostMapping("/")
    public Course addCourse(@RequestBody CourseDTO courseDTO) {
        courseDTO.setId(0);
        return courseService.save(courseDTO);
    }

    @PutMapping("/")
    public Course updateCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.save(courseDTO);
    }

    @GetMapping("/all")
    public Page<Course> getAllCourses(@PageableDefault(size = 10) Pageable pageable) {
        return courseService.findAll(pageable);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable("courseId") int courseId) {
        if (!courseService.doesExist(courseId)) {
            throw new EntityNotFoundException("Course id not found - " + courseId);
        }
        courseService.deleteById(courseId);
        return ResponseEntity.ok("Deleted course id - " + courseId);
    }

    @GetMapping("/exists/{courseId}")
    public ResponseEntity<Boolean> doesExist(@PathVariable("courseId") int courseId) {
        return ResponseEntity.ok(courseService.doesExist(courseId));
    }

    @GetMapping("/reviews/{courseId}")
    public Page<Course> findByIdWithReviews(@PathVariable("courseId") int courseId,
                                                           @PageableDefault(size = 10) Pageable pageable) {
        return courseService.findByIdWithReviews(courseId, pageable);
    }
}
