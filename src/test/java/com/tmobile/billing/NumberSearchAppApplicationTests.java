package com.tmobile.billing;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmobile.billing.dto.NumberSearchDTO;
import com.tmobile.billing.numbers.service.NumberSearchService;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class NumberSearchAppApplicationTests {

	@Autowired
	private NumberSearchService service;

	/**
	 * Test Method to verify the Available Numbers are coming.
	 */
	@Test
	public void testAvailableNumbers() throws Exception {
		List<NumberSearchDTO> numbers = null;
		numbers = service.getAvailableNumbers(404);
		assertNotNull(numbers);
	}

}
