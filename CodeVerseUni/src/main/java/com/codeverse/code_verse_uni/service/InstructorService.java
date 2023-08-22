package com.codeverse.code_verse_uni.service;

import com.codeverse.code_verse_uni.entity.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface InstructorService {
    public Instructor save(Instructor instructor);

    public Instructor findById(int id);

    public Page<Instructor> findAll(Pageable pageable);

    public Instructor findByIdAllDetails(int id);

    public boolean doesExist(int id);

    public void deleteById(int id);
}
