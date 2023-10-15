
package main.java.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class CreditCardValidationHandler {
	public abstract String validate(String cardNumber);

	public abstract void nextHandler(CreditCardValidationHandler nextValidator);

	protected String getBasicValidationError(String cardNumber) {
		if (cardNumber == null) {
			return "Invalid card";
		}
		if (cardNumber.length() == 0) {
			return "Invalid card ";
		}

		for (int a = 0; a < cardNumber.length(); a++) {
			if (a == 0 && cardNumber.charAt(a) == '-')
				continue;
			if (!Character.isDigit(cardNumber.charAt(a)))
				return "Invalid: Non Numeric characters";
		}

		if (cardNumber.length() > 19) {
			return "Invalid: More than 19 digits";
		}
		return "";
	}

}
