package com.tmobile.billing.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
@JsonInclude(value=Include.NON_NULL)
public class NumberSearchDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phoneNumber;
	private String locality;
	private String postalCode;
	
	
	public NumberSearchDTO()
	{
		
	}
	
	/**
	 * @param phoneNumber
	 * @param locality
	 * @param postalCode
	 */
	public NumberSearchDTO(String phoneNumber, String locality, String postalCode) {
		super();
		this.phoneNumber = phoneNumber;
		this.locality = locality;
		this.postalCode = postalCode;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getLocality() {
		return locality;
	}


	public void setLocality(String locality) {
		this.locality = locality;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	@Override
	public String toString() {
		return "NumberSearchDTO [phoneNumber=" + phoneNumber + ", locality=" + locality + ", postalCode=" + postalCode
				+ "]";
	}
	
}
