/**
 * 
 */
package main.java.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

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


public class CSVFileParser implements FileParser{

	@Override
	public List<List<String>> readFile(String fileName){
        List<List<String>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

        // This is to remove the header from the CSV file
        records.remove(0);
        return records;
    }
	


	@Override
	public void writeToFile(List<CreditCard> list, String outputFile) throws FileNotFoundException {
		File file = new File(outputFile);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = { "CardNumber", "CardType"};
            writer.writeNext(header);

            for(CreditCard cd : list) {
                String[] row = new String[2];
                row[0] = cd.getCardNumber();
                row[1] = cd.getCardType();
                writer.writeNext(row);
            }
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
    }
	
}
