/**
 * 
 */
package test.java.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.validator.DiscoverCreditCardValidationHandler;


public class DiscoverCreditCardValidationHandlerTest {

	@Test
	public void validate() {
		DiscoverCreditCardValidationHandler validator = new DiscoverCreditCardValidationHandler();
		String response = validator.validate("6011111100007756");
		assertSame(response, "DiscoverCreditCard");
		
	}

}
