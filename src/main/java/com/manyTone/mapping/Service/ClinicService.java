package com.manyTone.mapping.Service;

import com.manyTone.mapping.Dto.ClinicDto;
import com.manyTone.mapping.Model.Clinic;
import com.manyTone.mapping.Model.Doctor;
import com.manyTone.mapping.Repository.ClinicRepository;
import com.manyTone.mapping.Repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClinicRepository clinicRepository;
    public ClinicDto addClinic(Long doctorId, ClinicDto clinicDto) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));

        Clinic clinic = new Clinic();
        clinic.setLocation(clinicDto.getLocation());
        clinic.setIncharge(clinicDto.getIncharge());
        clinic.setFees(clinicDto.getFees());
        clinic.setStartTime(clinicDto.getStartTime());
        clinic.setEndTime(clinicDto.getEndTime());
        clinic.setDoctor(doctor);
        clinic = clinicRepository.save(clinic);

        ClinicDto clinicDto1 = new ClinicDto();
        clinicDto1.setLocation(clinic.getLocation());
        clinicDto1.setIncharge(clinic.getIncharge());
        clinicDto1.setFees(clinic.getFees());
        clinicDto1.setStartTime(clinic.getStartTime());
        clinicDto1.setEndTime(clinic.getEndTime());

        doctor.addClinic(clinic);
      //  clinic = clinicRepository.save(clinic);
        doctor = doctorRepository.save(doctor);

        return clinicDto1;
    }
}
