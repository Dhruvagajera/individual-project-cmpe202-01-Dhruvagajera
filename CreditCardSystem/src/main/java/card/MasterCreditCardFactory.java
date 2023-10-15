
package main.java.card;


public class MasterCreditCardFactory implements CreditCardFactory{

	@Override
	public CreditCard generateCard() {
		return new MasterCreditCard();
	}

}
