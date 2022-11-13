package com.ef.demo.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ef.demo.auth.service.ModelJSONservice;
import com.ef.demo.model.ModelJSON;
import com.ef.demo.response.ResponseMessage;


@CrossOrigin("http://localhost:3000")
@RestController
public class ModelJSONController {
	@Autowired
	ModelJSONservice service;
	
	
	@PostMapping("/api/file/uploadjson")
	public ResponseEntity<ResponseMessage> uploadJSON(@RequestBody List<ModelJSON> jsonList){
		String message="";
		try {
		   if(service.findAll()) {
			    service.deleteAll();
		   }
		   service.save(jsonList);
		   message="File uploaded successfully";
		   return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}catch(Exception e) {
		   message="Unexpected error";
		   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
}
