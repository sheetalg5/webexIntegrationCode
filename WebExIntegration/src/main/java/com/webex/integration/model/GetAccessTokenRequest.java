package com.webex.integration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAccessTokenRequest {

	String clientId;
	String clientSecret;
	String grantType;
	String redirectURI;
	String code;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((clientSecret == null) ? 0 : clientSecret.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((grantType == null) ? 0 : grantType.hashCode());
		result = prime * result + ((redirectURI == null) ? 0 : redirectURI.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetAccessTokenRequest other = (GetAccessTokenRequest) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (clientSecret == null) {
			if (other.clientSecret != null)
				return false;
		} else if (!clientSecret.equals(other.clientSecret))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (grantType == null) {
			if (other.grantType != null)
				return false;
		} else if (!grantType.equals(other.grantType))
			return false;
		if (redirectURI == null) {
			if (other.redirectURI != null)
				return false;
		} else if (!redirectURI.equals(other.redirectURI))
			return false;
		return true;
	}
	public GetAccessTokenRequest(String code2) {
		this.code=code2;
	}
		
	
}
