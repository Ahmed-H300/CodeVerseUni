package com.codeverse.code_verse_uni.controller;


import com.codeverse.code_verse_uni.entity.InstructorDetails;
import com.codeverse.code_verse_uni.exception.EntityNotFoundException;
import com.codeverse.code_verse_uni.service.InstructorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructorDetails/")
public class InstructorDetailsController {

    private InstructorDetailsService instructorDetailsService;

    @Autowired
    public InstructorDetailsController(InstructorDetailsService instructorDetailsService) {
        this.instructorDetailsService = instructorDetailsService;
    }

    // Add test API mapping
    @GetMapping("/hello")
    public String hello(){
        return "Hello From Instructor Details!";
    }


    @GetMapping("/{instructorDetailsId}")
    public InstructorDetails getInstructorDetails(@PathVariable("instructorDetailsId") int instructorDetailsId) {

        InstructorDetails instructorDetails = instructorDetailsService.findById(instructorDetailsId);

        if (instructorDetails == null) {
            throw new EntityNotFoundException("InstructorDetails id not found - " + instructorDetailsId);
        }

        return instructorDetails;
    }

    @GetMapping("/all")
    public Page<InstructorDetails> getAllInstructorDetails(@PageableDefault(size = 10) Pageable pageable) {
        return instructorDetailsService.findAll(pageable);
    }

    @PostMapping("/")
    public InstructorDetails addInstructorDetails(@RequestBody InstructorDetails instructorDetails) {
        instructorDetails.setId(0);
        return instructorDetailsService.save(instructorDetails);
    }

    @PutMapping("/")
    public InstructorDetails updateInstructorDetails(@RequestBody InstructorDetails instructorDetails) {
        return instructorDetailsService.save(instructorDetails);
    }

    @DeleteMapping("/{instructorDetailsId}")
    public ResponseEntity<String> deleteInstructorDetails(@PathVariable("instructorDetailsId") int instructorDetailsId) {
        if (!instructorDetailsService.doesExist(instructorDetailsId)) {
            throw new EntityNotFoundException("InstructorDetails id not found - " + instructorDetailsId);
        }
        instructorDetailsService.deleteById(instructorDetailsId);
        return ResponseEntity.ok().body("Deleted instructorDetailsId id - " + instructorDetailsId);
    }

    @GetMapping("/exists/{instructorDetailsId}")
    public ResponseEntity<Boolean> doesExist(@PathVariable("instructorDetailsId") int instructorDetailsId) {
        return ResponseEntity.ok(instructorDetailsService.doesExist(instructorDetailsId));
    }

}
