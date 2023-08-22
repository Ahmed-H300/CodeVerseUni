package com.codeverse.code_verse_uni.dao;

import com.codeverse.code_verse_uni.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {

    // Find student and Courses with student id
    @Query("select s from Student s join fetch s.courses where s.id = :id")
    public Student findByIdWithCourses(@Param("id") int id);
}
