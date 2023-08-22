package com.codeverse.code_verse_uni.dao;

import com.codeverse.code_verse_uni.entity.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface InstructorRepository extends PagingAndSortingRepository<Instructor, Integer> {


    // Find instructor by id with courses
    @Query("select i from Instructor i join fetch i.courses join FETCH i.instructorDetails where i.id = :id")
    public Instructor findByIdAllDetails(@Param("id") int id);
}
