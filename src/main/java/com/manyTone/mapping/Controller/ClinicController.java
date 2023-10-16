package com.manyTone.mapping.Controller;

import com.manyTone.mapping.Dto.ClinicDto;
import com.manyTone.mapping.Service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clinic")
public class ClinicController {
    @Autowired
    private ClinicService clinicService;

    @PostMapping("/add")
    public ResponseEntity<?> addClinicsToDoctor(@RequestParam Long doctorId, @RequestBody ClinicDto clinicDto){
        ClinicDto clinicDto1 = clinicService.addClinic(doctorId,clinicDto);
        if (clinicDto1 == null){
            return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(clinicDto1, HttpStatus.CREATED);
    }
}
