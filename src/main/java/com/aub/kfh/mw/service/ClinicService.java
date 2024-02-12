package com.aub.kfh.mw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aub.kfh.mw.bean.Clinic;

@Service
public interface ClinicService {

	public List<Clinic> getAllClinic();

	public Clinic saveClinic(Clinic clinic);

}
