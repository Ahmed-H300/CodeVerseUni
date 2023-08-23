package com.codeverse.code_verse_uni.service.impl;

import com.codeverse.code_verse_uni.dao.InstructorDetailsRepository;
import com.codeverse.code_verse_uni.entity.Instructor;
import com.codeverse.code_verse_uni.entity.InstructorDetails;
import com.codeverse.code_verse_uni.service.InstructorDetailsService;
import jakarta.transaction.Transactional;
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
    @Transactional
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
    @Transactional
    public void deleteById(int id) {

        InstructorDetails instructorDetails = instructorDetailsRepository.findById(id).orElse(null);
        if (instructorDetails == null){
            return;
        }
        Instructor instructor = instructorDetails.getInstructor();
        if (instructor != null){
            instructor.setInstructorDetails(null);
        }
        instructorDetailsRepository.delete(instructorDetails);
    }
}
