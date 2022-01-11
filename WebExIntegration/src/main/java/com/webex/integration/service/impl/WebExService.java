package com.webex.integration.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.webex.integration.model.GetAccessTokenRequest;
import com.webex.integration.model.GetAccessTokenResponse;
import com.webex.integration.model.Invitees;
import com.webex.integration.model.ScheduleMeetingRequest;
import com.webex.integration.model.WebExMeetingRequest;
import com.webex.integration.service.WebEx;

@Service
public class WebExService implements WebEx {

	@Override
	public GetAccessTokenResponse getAccessToken(GetAccessTokenRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> map= getMapValues(request);

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);


		ResponseEntity<GetAccessTokenResponse> response = restTemplate.postForEntity("https://webexapis.com/v1/access_token", entity , GetAccessTokenResponse.class );

		
		return response.getBody();
	}

	private MultiValueMap<String, String> getMapValues(GetAccessTokenRequest request) {
		
		MultiValueMap<String, String> map=new LinkedMultiValueMap<String, String>();
		map.add("client_id", request.getClientId());
		map.add("client_secret", request.getClientSecret());
		map.add("grant_type", "authorization_code");
		map.add("redirect_uri", request.getRedirectURI());
		map.add("code", request.getCode());
		
		
		return map;
	}

	@Override
	public String scheduleMeeting(ScheduleMeetingRequest request) {
		
		/**
		 * Call getAccessToken 
		 * 
		 */
	
		GetAccessTokenResponse accessToken = getAccessToken(new GetAccessTokenRequest(request.getClientId(),request.getClientSecret(),request.getGrantType(),request.getRedirectURI(),request.getCode()));
		System.out.println(accessToken);
		/**
		 * Call schedule meetings
		 */
		
		WebExMeetingRequest webExRequest=setWebExMeetingRequest(request);
		
		 RestTemplate restTemplate = new RestTemplate();
    
         HttpHeaders headers = new HttpHeaders();
         headers.set("Authorization", "Bearer " + accessToken.getAccess_token()); 
         headers.setContentType(MediaType.APPLICATION_JSON);
         HttpEntity <String> entity = new HttpEntity <> (new Gson().toJson(webExRequest), headers);
         ResponseEntity <String> response = restTemplate.postForEntity("https://webexapis.com/v1/meetings", entity, String.class);
		System.out.println(response);
		return response.getBody();
	}

	private WebExMeetingRequest setWebExMeetingRequest(ScheduleMeetingRequest request) {

		WebExMeetingRequest webexrequest=new WebExMeetingRequest();
		webexrequest.setTitle(request.getTitle());
		webexrequest.setAgenda(request.getAgenda());
		webexrequest.setStart(request.getDate()+" " +request.getStart_time());
		webexrequest.setEnd(request.getDate() +" "+ request.getEnd_time());
		webexrequest.setTimezone(request.getTimezone());
		webexrequest.setEnabledAutoRecordMeeting(false);
		webexrequest.setAllowAnyUserToBeCoHost(false);
		webexrequest.setEnabledJoinBeforeHost(false);
		webexrequest.setEnableConnectAudioBeforeHost(false);
		webexrequest.setJoinBeforeHostMinutes(0);
		webexrequest.setExcludePassword(false);
		webexrequest.setPublicMeeting(false);
		webexrequest.setReminderTime(10);
		webexrequest.setEnableAutomaticLock(true);
		webexrequest.setAutomaticLockMinutes(0);
		webexrequest.setAllowFirstUserToBeCoHost(false);
		webexrequest.setAllowAuthenticatedDevices(false);
		String[] invitees=request.getInvitees().split(",");
		List<Invitees> inviteesList=new ArrayList<>();
				
		Arrays.asList(invitees).stream().forEach(x->
		inviteesList.add(new Invitees(x,"",false))
		
		);
		;
		
		
		webexrequest.setInvitees(inviteesList);
		webexrequest.setSendEmail(true);
		webexrequest.setHostEmail(request.getHostEmail());
		return webexrequest;
	}
	
	
	

}
