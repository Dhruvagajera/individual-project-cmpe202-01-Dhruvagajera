package main.java.card;

public class DiscoverCreditCardFactory implements CreditCardFactory {

	@Override
	public CreditCard generateCard() {
		return new DiscoverCreditCard();
	}
	
	

}
