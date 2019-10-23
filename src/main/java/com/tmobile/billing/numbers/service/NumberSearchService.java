package com.tmobile.billing.numbers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tmobile.billing.dto.NumberSearchDTO;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.availablephonenumbercountry.Local;

@Service
public class NumberSearchService {

	@Value("${twilio.accountId}")
	private String ACCOUNT_SID;

	@Value("${twilio.auth.token}")
	private String AUTH_TOKEN;

	/**
	 * Method is used for fetching the Available Numbers!.
	 * @param areaCode
	 * @return
	 * @throws Exception
	 */
	public List<NumberSearchDTO> getAvailableNumbers(Integer areaCode) throws Exception {
		if (!validateRequest(areaCode)) {
			throw new Exception("Area Code should always be with 03 digits!.");
		}
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		List<NumberSearchDTO> list = null;
		ResourceSet<Local> numbers = Local.reader("US").setAreaCode(areaCode).read();
		if (numbers != null) {
			list = new ArrayList<NumberSearchDTO>();
			while (numbers.iterator().hasNext()) {
				Local local = numbers.iterator().next();
				NumberSearchDTO obj = new NumberSearchDTO();
				obj.setPhoneNumber(local.getFriendlyName().getEndpoint());
				obj.setLocality(local.getLocality());
				obj.setPostalCode(local.getPostalCode());
				list.add(obj);
			}
		}
		return list;
	}

	/**
	 * Method is used to validate the Request.
	 * 
	 * @param areaCode
	 * @return
	 */
	private boolean validateRequest(Integer areaCode) {
		boolean isValid = false;
		if (areaCode.toString().length() <= 3) {
			isValid = true;
		}
		return isValid;
	}
	
	/**
	 * Method is used for Fallback!.
	 * @return
	 */
	private String processFallBack()
	{
		return new String("No Records Found!");
	}

}
