package com.codeverse.code_verse_uni.dao;

import com.codeverse.code_verse_uni.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    // Find Course and reviews by course id
    @Query("select c from Course c left join fetch c.reviews where c.id = :id")
    Page<Course> findByIdWithReviews(@Param("id") int id, Pageable pageable);

}
