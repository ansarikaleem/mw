package com.aub.kfh.mw.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.aub.kfh.mw.bean.Clinic;

@Controller
public class PostController {
	
	@QueryMapping
	public List<Clinic> recentClinics(@Argument int count, @Argument int offset){
		List<Clinic> clinics = new ArrayList<Clinic>();
		
		for (int i = 0; i < count; i++) {
			Clinic clinic = new Clinic();
			
			clinic.setClinicId(i+"");
			clinic.setClinicName("Name: "+i);
			clinic.setClinicAddress("Address : "+i);
			

			clinics.add(clinic);
		}
		
		
		return clinics;
		
	}

}
