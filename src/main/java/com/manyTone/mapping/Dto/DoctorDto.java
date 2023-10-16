package com.manyTone.mapping.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private String name;
    private String specialization;
    private String degree;
    private int experience;
    private String research_journal;
    private String citations;
    private String contact;
    @Column(unique = true)
    private String email;
    private String password;
}
