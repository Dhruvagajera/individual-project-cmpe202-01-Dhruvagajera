package main.java.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiscoverCreditCardValidationHandler extends CreditCardValidationHandler{
	private CreditCardValidationHandler nextValidator;
	@Override
	public String validate(String cardNumber) {
		if(getBasicValidationError(cardNumber).length()==0) {
            String regex = "^6011[0-9]{12}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(cardNumber);
            if(m.matches()) {
                return "DiscoverCreditCard";
            }else {
                if (this.nextValidator != null) {
                    return this.nextValidator.validate(cardNumber);
                }
            }
        }
        return null;
	}

	@Override
	public void nextHandler(CreditCardValidationHandler nextValidator) {
		this.nextValidator = nextValidator;
		
	}
}
