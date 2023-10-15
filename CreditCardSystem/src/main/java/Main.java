package main.java;


import java.util.ArrayList;
import java.util.List;

import main.java.card.CreditCard;
import main.java.parser.CSVFileParser;
import main.java.parser.FileParser;
import main.java.parser.JSONFileParser;
import main.java.parser.XMLFileParser;

public class Main {
	public static void main(String[] args) {
		String inputFile = args[0];
        String outputFile = args[1];
		List<CreditCard> ans = new ArrayList<CreditCard>();
		FileParser p;
		try {
			if(inputFile.endsWith(".csv")) {
				System.out.println("Heere");
				p = new CSVFileParser();
				ans = p.generateCreditCards(inputFile);
				p.writeToFile(ans, outputFile);
	        }
			else if(inputFile.endsWith(".json")) {
				System.out.println("Going for json");
				p = new JSONFileParser();
				ans = p.generateCreditCards(inputFile);
				p.writeToFile(ans, outputFile);	
	        }
			else if(inputFile.endsWith(".xml")) {
				p = new XMLFileParser();
				ans = p.generateCreditCards(inputFile);
				p.writeToFile(ans,outputFile);	
	        }
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
