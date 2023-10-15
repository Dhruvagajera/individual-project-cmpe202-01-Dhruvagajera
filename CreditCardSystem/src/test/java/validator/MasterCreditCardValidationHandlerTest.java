/**
 * 
 */
package test.java.validator;

import static org.junit.Assert.assertSame;

import org.junit.Test;

//import static org.junit.Assert.*;

//import org.junit.Test;

import main.java.validator.MasterCreditCardValidationHandler;


public class MasterCreditCardValidationHandlerTest {

	@Test
	public void validate() {
		MasterCreditCardValidationHandler validator = new MasterCreditCardValidationHandler();
		String response = validator.validate("5367894523129089");
		assertSame(response, "MasterCreditCard");
		
	}

}
