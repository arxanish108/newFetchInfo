package com.manyTone.mapping.Service;

import com.manyTone.mapping.Dto.DoctorDto;
import com.manyTone.mapping.Dto.SignUpRequest;
import com.manyTone.mapping.Model.Doctor;
import com.manyTone.mapping.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    public DoctorDto createUser(SignUpRequest signupRequest) {

        Doctor doctor = new Doctor();

        doctor.setName(signupRequest.getName());
        doctor.setSpecialization(signupRequest.getSpecialization());
        doctor.setDegree(signupRequest.getDegree());
        doctor.setExperience(signupRequest.getExperience());
        doctor.setResearch_journal(signupRequest.getResearch_journal());
        doctor.setCitations(signupRequest.getCitations());
        doctor.setContact(signupRequest.getContact());
        doctor.setEmail(signupRequest.getEmail());
        doctor.setPassword(signupRequest.getPassword());

        Doctor createdDoctor = doctorRepository.save(doctor);
        DoctorDto doctorDTO = new DoctorDto();
        doctorDTO.setName(createdDoctor.getName());
        doctorDTO.setSpecialization(createdDoctor.getSpecialization());
        doctorDTO.setDegree(createdDoctor.getDegree());
        doctorDTO.setExperience(createdDoctor.getExperience());
        doctorDTO.setResearch_journal(createdDoctor.getResearch_journal());
        doctorDTO.setCitations(createdDoctor.getCitations());
        doctorDTO.setContact(createdDoctor.getContact());
        doctorDTO.setEmail(createdDoctor.getEmail());
        doctorDTO.setPassword(createdDoctor.getPassword());

        return doctorDTO;

    }


    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

}
