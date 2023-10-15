/**
 * 
 */
package main.java.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Need to make changes here
public class VisaCreditCardValidationHandler extends CreditCardValidationHandler{

	private CreditCardValidationHandler nextValidator;
	@Override
	public String validate(String cardNumber) {
		String basicValidationError = getBasicValidationError(cardNumber);
		if(basicValidationError.length()==0) {
            String regex = "^4[0-9]{12}(?:[0-9]{3})?$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(cardNumber);
            if(m.matches()) {
                return "VisaCreditCard";
            }
            else {
                if (this.nextValidator != null) {
                    return this.nextValidator.validate(cardNumber);
                }
            }
        }
		else {
			return basicValidationError;
		}
		return "";
	}

	@Override
	public void nextHandler(CreditCardValidationHandler nextValidator) {
		this.nextValidator = nextValidator;
		
	}
	
	

}
