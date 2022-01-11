package com.webex.integration.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ScheduleMeetingRequest {
	
	String title     ; 
	String agenda    ;
	String date;
	String start_time;
	String end_time;
	String timezone;
	String invitees;
	List<Invitees> inviteess;
	String hostEmail;
	String clientId;
	String clientSecret;
	String grantType;
	String redirectURI;
	String code;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agenda == null) ? 0 : agenda.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((clientSecret == null) ? 0 : clientSecret.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((end_time == null) ? 0 : end_time.hashCode());
		result = prime * result + ((grantType == null) ? 0 : grantType.hashCode());
		result = prime * result + ((hostEmail == null) ? 0 : hostEmail.hashCode());
		result = prime * result + ((invitees == null) ? 0 : invitees.hashCode());
		result = prime * result + ((inviteess == null) ? 0 : inviteess.hashCode());
		result = prime * result + ((redirectURI == null) ? 0 : redirectURI.hashCode());
		result = prime * result + ((start_time == null) ? 0 : start_time.hashCode());
		result = prime * result + ((timezone == null) ? 0 : timezone.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		ScheduleMeetingRequest other = (ScheduleMeetingRequest) obj;
		if (agenda == null) {
			if (other.agenda != null)
				return false;
		} else if (!agenda.equals(other.agenda))
			return false;
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (end_time == null) {
			if (other.end_time != null)
				return false;
		} else if (!end_time.equals(other.end_time))
			return false;
		if (grantType == null) {
			if (other.grantType != null)
				return false;
		} else if (!grantType.equals(other.grantType))
			return false;
		if (hostEmail == null) {
			if (other.hostEmail != null)
				return false;
		} else if (!hostEmail.equals(other.hostEmail))
			return false;
		if (invitees == null) {
			if (other.invitees != null)
				return false;
		} else if (!invitees.equals(other.invitees))
			return false;
		if (inviteess == null) {
			if (other.inviteess != null)
				return false;
		} else if (!inviteess.equals(other.inviteess))
			return false;
		if (redirectURI == null) {
			if (other.redirectURI != null)
				return false;
		} else if (!redirectURI.equals(other.redirectURI))
			return false;
		if (start_time == null) {
			if (other.start_time != null)
				return false;
		} else if (!start_time.equals(other.start_time))
			return false;
		if (timezone == null) {
			if (other.timezone != null)
				return false;
		} else if (!timezone.equals(other.timezone))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	

}
