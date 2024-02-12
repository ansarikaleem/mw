package com.aub.kfh.mw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aub.kfh.mw.bean.Clinic;
import com.aub.kfh.mw.service.ClinicService;


@RestController
@RequestMapping("/api/v1/clinic")
public class ClinicController implements ClinicApi{
	
	@Autowired
	ClinicService clinicService;
	
	
	@GetMapping("/all")
    public ResponseEntity<List<Clinic>> getAll() {
        return ResponseEntity.ok(clinicService.getAllClinic());
    }
	
	
	@PostMapping("/add")
	public ResponseEntity<Clinic> saveClinic(Clinic clinic){
		return ResponseEntity.ok(clinicService.saveClinic(clinic));
		
	}

}
