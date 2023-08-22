package com.codeverse.code_verse_uni.dao;

import com.codeverse.code_verse_uni.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    // Find all courses by instructor id
    @Query("select c from Course c where c.instructor.id = :id")
    public List<Course> findByInstructorId(@Param("id") int id);

    // Find Course and reviews by course id
    @Query("select c from Course c join fetch c.reviews where c.id = :id")
    public Course findByIdWithReviews(@Param("id") int id);

    // Find Course and students by course id
    @Query("select c from Course c join fetch c.students where c.id = :id")
    public Course findByIdWithStudents(@Param("id") int id);
}
