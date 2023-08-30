package com.codeverse.code_verse_uni.dao;

import com.codeverse.code_verse_uni.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {


    // Find instructor by id with courses
    @Query("select i from Instructor i join fetch i.instructorDetails left join fetch i.courses where i.id = :id")
    Instructor findByIdAllDetails(@Param("id") int id);

}
