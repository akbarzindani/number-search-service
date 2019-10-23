package com.tmobile.billing.numbers.controller;

import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.billing.dto.NumberSearchDTO;
import com.tmobile.billing.numbers.service.NumberSearchService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class NumberSearchController {

	@Value("${twilio.accountId}")
	private String ACCOUNT_SID;

	@Value("${twilio.auth.token}")
	private String AUTH_TOKEN;

	@Autowired
	private NumberSearchService numberService;

	@ApiOperation(value = "API to List the Available Numbers based on Area Code!.")
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Available Numbers List is available!"),
			@ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Error Occurred while processing the request! ") })
	@GetMapping(value = "/billing/number/v1/search/{area-code}", produces = "application/json")
	@CrossOrigin(origins = "*")
	public ResponseEntity<?> getAccountBalance(@PathVariable(required = true, value = "area-code") Integer areaCode) {
		ResponseEntity response = null;
		List<NumberSearchDTO> availableNumbers = null;
		try {
			availableNumbers = numberService.getAvailableNumbers(areaCode);
			if (availableNumbers == null || availableNumbers.size() == 0) {
				response = new ResponseEntity("No Records Found!", HttpStatus.OK);
			} else {
				response = new ResponseEntity(availableNumbers, HttpStatus.OK);
			}
		} catch (Exception e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
