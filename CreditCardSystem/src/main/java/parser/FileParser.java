/**
 * 
 */
package main.java.parser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import main.java.card.AmExCreditCardFactory;
import main.java.card.CreditCard;
import main.java.card.CreditCardFactory;
import main.java.card.DiscoverCreditCardFactory;
import main.java.card.VisaCreditCardFactory;
import main.java.validator.AmExCreditCardValidationHandler;
import main.java.validator.CreditCardValidationHandler;
import main.java.validator.DiscoverCreditCardValidationHandler;
import main.java.validator.MasterCreditCardValidationHandler;
import main.java.validator.VisaCreditCardValidationHandler;


public interface FileParser {
    
    public List<List<String>> readFile(String fileName);

    public void writeToFile(List<CreditCard> list, String outputFile) throws FileNotFoundException;

    public default List<CreditCard> generateCreditCards(String fileName){
    	List<CreditCard> creditCardList = new ArrayList<CreditCard>();
		List<List<String>> records = readFile(fileName);
        try {

            for(int i = 0;i<records.size();i++) {
                List<String> nextRecord1 = records.get(i);
                String cardNumber = nextRecord1.get(0);
                String expirationDate = nextRecord1.get(1);
                String nameOfHolder = nextRecord1.get(2);
                CreditCardFactory factory = new VisaCreditCardFactory();
               
                CreditCard card = null;
                
                try {
                    
                    CreditCardValidationHandler visaHandler = new VisaCreditCardValidationHandler();
                    CreditCardValidationHandler masterHandler = new MasterCreditCardValidationHandler();
                    CreditCardValidationHandler amexHandler = new AmExCreditCardValidationHandler();
                    CreditCardValidationHandler discoverHandler = new DiscoverCreditCardValidationHandler();
                    
                    visaHandler.nextHandler(masterHandler);
                    masterHandler.nextHandler(amexHandler);
                    amexHandler.nextHandler(discoverHandler);

                   
                    String type = visaHandler.validate(cardNumber);
      
                    if(type!=null) {
                    	if(type.equals("VisaCreditCard")) {
                    		factory = new VisaCreditCardFactory();
                    	}
                    	else if(type.equals("MasterCreditCard")) {
                    		factory = new VisaCreditCardFactory();
                    	}
                    	else if(type.equals("AmExCreditCard")) {
                    		factory = new AmExCreditCardFactory();
                    	}
                    	else if(type.equals("DiscoverCreditCard")) {
                    		factory = new DiscoverCreditCardFactory();
                    	}
                    	card = factory.generateCard();
                    	card.setCardNumber(cardNumber);
                        card.setExpirationDate(expirationDate);
                        card.setNameOfHolder(nameOfHolder);
                        card.setCardType(type);
//                        System.out.println(cardNumber + " " + type);
                    	
                    }else {
                    	card = factory.generateCard();
                    	card.setCardNumber(cardNumber);
                        card.setExpirationDate(expirationDate);
                        card.setNameOfHolder(nameOfHolder);
                        card.setCardType("Invalid");
//                        System.out.println(cardNumber + " " + "Invalid");
                    	
                
                    }
                    creditCardList.add(card);
                }catch(NumberFormatException e){
                	card = factory.generateCard();
                	card.setCardNumber(cardNumber);
                    card.setExpirationDate(expirationDate);
                    card.setNameOfHolder(nameOfHolder);
                    card.setCardType("Invalid");
//                    System.out.println(cardNumber + " " + "Invalid");
                }
                
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return creditCardList;

    }
}