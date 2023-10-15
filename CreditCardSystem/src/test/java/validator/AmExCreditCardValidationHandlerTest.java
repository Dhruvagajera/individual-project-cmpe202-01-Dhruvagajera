/**
 * 
 */
package test.java.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.validator.AmExCreditCardValidationHandler;


public class AmExCreditCardValidationHandlerTest {

	@Test
	public void validate() {
		AmExCreditCardValidationHandler validator = new AmExCreditCardValidationHandler();
		String response = validator.validate("347856341908126");
		assertSame(response, "AmExCreditCard");
		
	}

}
