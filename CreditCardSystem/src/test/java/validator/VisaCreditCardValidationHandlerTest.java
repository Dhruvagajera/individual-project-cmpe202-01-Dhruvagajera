/**
 * 
 */
package test.java.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.validator.VisaCreditCardValidationHandler;

public class VisaCreditCardValidationHandlerTest {

	@Test
	public void validate() {
		VisaCreditCardValidationHandler validator = new VisaCreditCardValidationHandler();
		String response = validator.validate("4123456789123999");
		assertSame(response, "VisaCreditCard");
		
	}

}
