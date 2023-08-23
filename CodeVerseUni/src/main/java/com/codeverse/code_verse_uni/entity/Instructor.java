package com.codeverse.code_verse_uni.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "courses")
@EqualsAndHashCode
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_details_id")
    private InstructorDetails instructorDetails;

    @OneToMany(mappedBy ="instructor",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Course> courses;

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addCourse(Course course){
        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setInstructor(this);
    }
}
