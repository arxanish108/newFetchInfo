package com.manyTone.mapping.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "clinicId")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String incharge;
    private int fees;
    private LocalTime startTime;
    private LocalTime endTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;
}
