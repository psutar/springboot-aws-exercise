package com.studentapp.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.studentapp.service.StudentDataService;

@RestController
@RequestMapping(path = "/rest/v1/studentdata")
public class StudentController {
	private static final Logger logger = LogManager.getLogger(StudentController.class);
	@Value("${endpoint.url}")
	private String endpointUrl;

	@RequestMapping("/data")
	public JsonNode studentData() throws IOException {
		StudentDataService studentDataService = new StudentDataService();
		logger.info("##### url >> " + endpointUrl);
		return studentDataService.getStudentData(endpointUrl);
	}
}
