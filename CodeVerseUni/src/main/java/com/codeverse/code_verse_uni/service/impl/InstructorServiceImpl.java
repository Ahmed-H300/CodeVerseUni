package com.codeverse.code_verse_uni.service.impl;

import com.codeverse.code_verse_uni.dao.InstructorRepository;
import com.codeverse.code_verse_uni.entity.Instructor;
import com.codeverse.code_verse_uni.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Instructor> findAll(Pageable pageable) {
        return instructorRepository.findAll(pageable);
    }

    @Override
    public Instructor findByIdAllDetails(int id) {
        return instructorRepository.findByIdAllDetails(id);
    }

    @Override
    public boolean doesExist(int id) {
        return instructorRepository.existsById(id);
    }

    @Override
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }
}
