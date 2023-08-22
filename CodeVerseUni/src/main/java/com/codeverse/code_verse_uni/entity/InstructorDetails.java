package com.codeverse.code_verse_uni.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instructor_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class InstructorDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "salary")
    private int salary;

    @OneToOne(mappedBy = "instructorDetails", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetails(int salary) {
        this.salary = salary;
    }


}
