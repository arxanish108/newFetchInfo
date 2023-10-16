package com.manyTone.mapping.Controller;

import com.manyTone.mapping.Dto.DoctorDto;
import com.manyTone.mapping.Dto.SignUpRequest;
import com.manyTone.mapping.Model.Doctor;
import com.manyTone.mapping.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/home")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;


    @PostMapping("/register")
    public ResponseEntity<?> signupUser(@RequestBody SignUpRequest signupRequest) {
        System.out.println("hello");
        DoctorDto createdUser = doctorService.createUser(signupRequest);
        if (createdUser == null){
            return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<Doctor> getUser(@RequestParam Long docId){
        System.out.println("yo yo");
        Doctor doctor = doctorService.getDoctor(docId);

        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
