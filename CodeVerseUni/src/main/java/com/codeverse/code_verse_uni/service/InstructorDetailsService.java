package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.entity.InstructorDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface InstructorDetailsService {
    public InstructorDetails save(InstructorDetails instructorDetails);

    public InstructorDetails findById(int id);

    public Page<InstructorDetails> findAll(Pageable pageable);

    public boolean doesExist(int id);

    public void deleteById(int id);
}
