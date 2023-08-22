package com.codeverse.code_verse_uni.service.impl;

import com.codeverse.code_verse_uni.dao.InstructorDetailsRepository;
import com.codeverse.code_verse_uni.entity.InstructorDetails;
import com.codeverse.code_verse_uni.service.InstructorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorDetailsServiceImpl implements InstructorDetailsService {

    private final InstructorDetailsRepository instructorDetailsRepository;

    @Autowired
    public InstructorDetailsServiceImpl(InstructorDetailsRepository instructorDetailsRepository) {
        this.instructorDetailsRepository = instructorDetailsRepository;
    }

    @Override
    public InstructorDetails save(InstructorDetails instructorDetails) {
        return instructorDetailsRepository.save(instructorDetails);
    }

    @Override
    public InstructorDetails findById(int id) {
        return instructorDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public Page<InstructorDetails> findAll(Pageable pageable){
        return instructorDetailsRepository.findAll(pageable);
    }

    @Override
    public boolean doesExist(int id) {
        return instructorDetailsRepository.existsById(id);
    }

    @Override
    public void deleteById(int id) {
        instructorDetailsRepository.deleteById(id);
    }
}
