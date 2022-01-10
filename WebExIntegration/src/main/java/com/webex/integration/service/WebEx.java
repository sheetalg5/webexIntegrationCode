package com.webex.integration.service;

import com.webex.integration.model.GetAccessTokenRequest;
import com.webex.integration.model.GetAccessTokenResponse;
import com.webex.integration.model.ScheduleMeetingRequest;


public interface WebEx {

	public GetAccessTokenResponse getAccessToken(GetAccessTokenRequest request);
	
	
	public String scheduleMeeting(ScheduleMeetingRequest request);
}
