package com.aub.kfh.mw.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Blog", description = "The Blog API")
public interface BlogApi {
	
	@Operation(summary = "Get Message", description = "this is a sample of unrestricted API")
	public ResponseEntity<?> getMessage();
	
	@Operation(summary = "Get Restricted Message", description = "this api is restricted you need to pass JWT token")
	public ResponseEntity<?> getRestrictedMessage();
	

}
