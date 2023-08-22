package com.codeverse.code_verse_uni.dao;

import com.codeverse.code_verse_uni.entity.InstructorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailsRepository extends JpaRepository<InstructorDetails, Integer> {
    // that's it .... no need to write code here!
}
