package com.webex.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webex.integration.model.GetAccessTokenRequest;
import com.webex.integration.model.GetAccessTokenResponse;
import com.webex.integration.model.ScheduleMeetingRequest;
import com.webex.integration.service.WebEx;

@RestController
@RequestMapping("/webex")
public class ScheuleMeetingWebExController {
	
	
	  @Autowired 
	  WebEx webex;
	 
	@PostMapping(path="/getAccessToken")
	public String getAccessToken(@RequestBody GetAccessTokenRequest request)
	{
		GetAccessTokenResponse response=webex.getAccessToken(request);
		return response.getAccess_token();
		
		
	}
	
	@PostMapping(path="/scheduleMeeting")
	public String scheduleMeeting(@RequestBody ScheduleMeetingRequest request)
	{
		
		return webex.scheduleMeeting(request);
		
	}
	
	
	

}
