/**
 * 
 */
package main.java.parser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.java.card.CreditCard;
import main.java.validator.AmExCreditCardValidationHandler;
import main.java.validator.CreditCardValidationHandler;
import main.java.validator.DiscoverCreditCardValidationHandler;
import main.java.validator.MasterCreditCardValidationHandler;
import main.java.validator.VisaCreditCardValidationHandler;




public class JSONFileParser implements FileParser {
	
	
	public List<List<String>> readFile(String fileName){
		List<List<String>> records = new ArrayList<>();
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		
		try {
			obj = (JSONObject) parser.parse(new FileReader(fileName));
			JSONArray cards = (JSONArray) obj.get("cards");
			
			for (Object o : cards){
				ArrayList<String> temp = new ArrayList<String>();
			    JSONObject person = (JSONObject) o;
		
			    String nameOfHolder = (String) person.get("cardNumber");
			    temp.add(nameOfHolder);
//			    System.out.println(nameOfHolder);
		
			    String expirationDate = (String) person.get("expirationDate");
			    temp.add(expirationDate);
//			    System.out.println(expirationDate);
		
			    String cardNumber = (String) person.get("cardNumber");
			    temp.add(cardNumber);
//			    System.out.println(cardNumber);
			    
			    records.add(temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return records;
			
	}
	


	@Override
	public void writeToFile(List<CreditCard> list, String outputFile) throws FileNotFoundException {
		JSONArray ccList = new JSONArray();
        for(CreditCard cc:list) {
            JSONObject ccobject = new JSONObject();
            ccobject.put("CardNumber", cc.getCardNumber());

            ccobject.put("Type", cc.getCardType());
            ccList.add(ccobject);
        }
        try{
            FileWriter file = new FileWriter(outputFile,false);
            ccList.writeJSONString(ccList, file);
            file.close();
        }catch (IOException e) {
            e.printStackTrace();

        }

	}
	
}
