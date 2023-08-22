package com.codeverse.code_verse_uni.dao;

import com.codeverse.code_verse_uni.entity.InstructorDetails;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InstructorDetailsRepository extends PagingAndSortingRepository<InstructorDetails, Integer> {
    // that's it .... no need to write code here!
}
