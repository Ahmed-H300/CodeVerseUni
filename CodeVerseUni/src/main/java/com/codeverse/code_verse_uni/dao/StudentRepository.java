package com.codeverse.code_verse_uni.dao;

import com.codeverse.code_verse_uni.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Find student and Courses with student id
    @Query("select s from Student s join fetch s.courses where s.id = :id")
    Student findByIdWithCourses(@Param("id") int id);

    // Find All Students for specific Course id
    @Query("select s from Student s join fetch s.courses c where c.id = :id")
    Page<Student> findAllByCourseId(@Param("id") int id, Pageable pageable);
}
