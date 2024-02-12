package com.aub.kfh.mw.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aub.kfh.mw.bean.Clinic;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clinic", description = "The Clinic API")
public interface ClinicApi {

	@Operation(summary = "Fetch all clinic", description = "fetches all clinic entities and their data from data source")
	ResponseEntity<List<Clinic>> getAll();
	
	@Operation(summary = "Save new clinic", description = "saves clinic entities and their data to data source")
	ResponseEntity<Clinic> saveClinic(Clinic clinic);

}
