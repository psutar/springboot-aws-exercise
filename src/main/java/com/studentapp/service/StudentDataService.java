package com.studentapp.service;



import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentDataService {
	
	public JsonNode getStudentData(String endpointUrl) throws IOException {
		WebClient client3 = WebClient
				  .builder()
				    .baseUrl(endpointUrl)
				    .defaultCookie("cookieKey", "cookieValue")
				    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				  .build();
		WebClient.UriSpec<WebClient.RequestBodySpec> request1 = client3.method(HttpMethod.GET);
		@SuppressWarnings("unchecked")
		String response2 = ((RequestHeadersSpec<RequestBodySpec>) request1).exchange()
				  .block()
				  .bodyToMono(String.class)
				  .block();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = mapper.readTree(response2);
		return actualObj;
	}
}
