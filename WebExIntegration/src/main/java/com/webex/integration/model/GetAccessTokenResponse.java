package com.webex.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAccessTokenResponse {

	String access_token;
	int expires_in;
	String refresh_token;
	String refresh_token_expires_in;
	String token_type;

	
	
	
}
