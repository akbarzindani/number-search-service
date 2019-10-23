package com.tmobile.billing.cucumber.features;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmobile.billing.dto.NumberSearchDTO;
import com.tmobile.billing.numbers.service.NumberSearchService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Service
public class AvailableNumberSearch {

	private Integer areaCode;
	private List<NumberSearchDTO> numbers = null;

	@Autowired
	private NumberSearchService service;

	@Given("^Area code provided for Atlanta \"([^\"]*)\"$")
	public void setAreaCode(String areaCode) throws Throwable {
		this.areaCode = Integer.parseInt(areaCode);
	}

	@When("Call Number Search Service to getAvailableNumbers")
	public void fillNumberList() throws Exception {
		System.out.println(this.areaCode);
	 this.numbers= this.service.getAvailableNumbers(this.areaCode);
	}

	@Then("List of Available Numbers")
	public void testAvailableNumbers() {
		boolean valid = false;
		if (this.numbers.size() > 0) {
			valid = true;
		}
		
	}

}
