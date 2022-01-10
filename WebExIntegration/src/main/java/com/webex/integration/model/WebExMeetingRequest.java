package com.webex.integration.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebExMeetingRequest {

	String title;
	String agenda;
	String password;
	String start;
	String end;
	String timezone;
	boolean enabledAutoRecordMeeting;
	boolean allowAnyUserToBeCoHost;
	boolean enabledJoinBeforeHost;
	boolean enableConnectAudioBeforeHost;
	int joinBeforeHostMinutes;
	boolean excludePassword;
	boolean publicMeeting;
	int reminderTime;
	boolean enableAutomaticLock;
	int automaticLockMinutes;
	boolean allowFirstUserToBeCoHost;
	boolean allowAuthenticatedDevices;
	List<Invitees> invitees;
	boolean sendEmail;
	String hostEmail;
	String registration;
	String requireFirstName;
	String requireLastName;
	String requireEmail;
	String requireCompanyName;
	String requireCountryRegion;
	String requireWorkPhone;
	List<String> integrationTags;
	
	
	
	

}
