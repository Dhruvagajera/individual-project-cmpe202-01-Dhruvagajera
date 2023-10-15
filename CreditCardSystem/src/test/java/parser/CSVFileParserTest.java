/**
 * 
 */
package test.java.parser;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.java.parser.CSVFileParser;

public class CSVFileParserTest {

	@Test
	public void readFile() {
		CSVFileParser parser = new CSVFileParser();
		List<List<String>> records = parser.readFile(
				"C:/Users/Checkout/Desktop/dhruva/individual-project-cmpe202-01-Dhruvagajera/CreditCardSystem/src/test/Files/input_file-1.csv");
		assertTrue(records.get(0).get(0).equals("5567894523129089"));
	}

	@Test
	public void readFileLiength() {
		CSVFileParser parser = new CSVFileParser();
		List<List<String>> records = parser.readFile(
				"C:/Users/Checkout/Desktop/dhruva/individual-project-cmpe202-01-Dhruvagajera/CreditCardSystem/src/test/Files/input_file-1.csv");
		assertSame(records.size(), 12);
	}

}
