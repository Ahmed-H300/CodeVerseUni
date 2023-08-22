package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.entity.InstructorDetails;

import java.util.List;

public interface InstructorDetailsService {
    public InstructorDetails save(InstructorDetails instructorDetails);

    public InstructorDetails findById(int id);

    public List<InstructorDetails> findAll();

    public boolean doesExist(int id);

    public void deleteById(int id);
}
