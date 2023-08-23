package com.codeverse.code_verse_uni.controller;

import com.codeverse.code_verse_uni.entity.Instructor;
import com.codeverse.code_verse_uni.exception.EntityNotFoundException;
import com.codeverse.code_verse_uni.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors/")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    // Add test API mapping
    @GetMapping("/hello")
    public String hello(){
        return "Hello From Instructor!";
    }

    // Add mapping for getInstructor
    @GetMapping("/{instructorId}")
    public Instructor getInstructor(@PathVariable("instructorId") int instructorId) {

        Instructor instructor = instructorService.findById(instructorId);

        if (instructor == null) {
            throw new EntityNotFoundException("Instructor id not found - " + instructorId);
        }

        return instructor;
    }

    // Add mapping for getInstructor
    @GetMapping("/details/{instructorId}")
        public Instructor findByIdAllDetails(@PathVariable("instructorId") int instructorId) {
            Instructor instructor =  instructorService.findByIdAllDetails(instructorId);
            if (instructor == null) {
                throw new EntityNotFoundException("Instructor id not found - " + instructorId);
            }

            return instructor;
        }

    @GetMapping("/all")
    public Page<Instructor> getAllInstructors(@PageableDefault(size = 10) Pageable pageable) {
        return instructorService.findAll(pageable);
    }

    @PostMapping("/")
    public Instructor addInstructor(@RequestBody Instructor instructor) {

        // Also just in case they pass an id in JSON ... set id to 0
        // This is to force a save of new item ... instead of update

        instructor.setId(0);

        instructorService.save(instructor);

        return instructor;
    }

    @PutMapping("/")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {

        instructorService.save(instructor);

        return instructor;
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity<String> deleteById(@PathVariable("instructorId") int instructorId) {

        if (!instructorService.doesExist(instructorId)) {
            throw new EntityNotFoundException("Instructor id not found - " + instructorId);
        }
        instructorService.deleteById(instructorId);
        return ResponseEntity.ok().body("Deleted instructor id - " + instructorId);
    }

    @GetMapping("/exists/{instructorId}")
    public ResponseEntity<Boolean> doesExist(@PathVariable("instructorId") int instructorId) {
        return ResponseEntity.ok().body(instructorService.doesExist(instructorId));
    }






    //////////////////////////////////////////////////////



//    public boolean doesExist(int id);

//    public void deleteById(int id);

        //////////////////////////////////////////////////////
//
//        @GetMapping("/")
//        public Page<Instructor> findAll(Pageable pageable) {
//            return instructorService.findAll(pageable);
//        }
//
//        @GetMapping("/all")
//        public List<Instructor> findAll() {
//            return instructorService.findAll();
//        }
//
//        @GetMapping("/all/details")
//        public List<Instructor> findAllDetails() {
//            return instructorService.findAllDetails();
//        }
//
//        @GetMapping("/all/details/{instructorId}")
//        public Instructor findByIdAllDetails(@PathVariable("instructorId") int instructorId) {
//            return instructorService.findByIdAllDetails(instructorId);
//        }
//
//        @GetMapping("/exists/{instructorId}")
//        public boolean doesExist(@PathVariable("instructorId") int instructorId) {
//            return instructorService.doesExist(instructorId);
//        }
//
//        @DeleteMapping("/{instructorId}")
//        public String deleteById(@PathVariable("instructorId") int instructorId) {
//
//            Instructor instructor = instructorService.findById(instructorId);
//
//            // throw exception if null
//
//            if (instructor == null) {
//                throw new EntityNotFoundException("Instructor id not found - " + instructorId);
//            }
//
//            instructorService.deleteById(instructorId);
//
//            return "Deleted instructor id - " + instructorId;
//        }
}
