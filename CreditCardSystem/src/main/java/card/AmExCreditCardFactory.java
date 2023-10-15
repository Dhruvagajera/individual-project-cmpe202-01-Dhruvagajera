
package main.java.card;

public class AmExCreditCardFactory implements CreditCardFactory{

	@Override
	public CreditCard generateCard() {
		return new AmExCreditCard();
	}

}
