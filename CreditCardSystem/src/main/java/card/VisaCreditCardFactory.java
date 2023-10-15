
package main.java.card;


public class VisaCreditCardFactory implements CreditCardFactory{

	@Override
	public CreditCard generateCard() {
		return new VisaCreditCard();
		
	}

	
}
