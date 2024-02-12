package com.aub.kfh.mw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aub.kfh.mw.bean.Clinic;

@Service
public class ClinicServiceImpl implements ClinicService{
	
	private List<Clinic > clinics = new ArrayList<Clinic>();

    public List<Clinic> getAllClinic() {
    	
    	Clinic clinic = new Clinic();
    	
    	clinic.setClinicId("ID 1");
    	clinic.setClinicName("Clinic 1");
    	clinic.setClinicAddress("Clininc Address 1");
    	
    	clinics.add(clinic);
    	clinics.add(clinic);
    	clinics.add(clinic);
        
        return clinics;
    }

	public Clinic saveClinic(Clinic clinic) {
		
		clinic.setClinicId("2");
		clinic.setClinicName("Clinic Name 2");
		clinic.setClinicAddress("Clinic Address 2");
		
		return clinic;
	}

}
