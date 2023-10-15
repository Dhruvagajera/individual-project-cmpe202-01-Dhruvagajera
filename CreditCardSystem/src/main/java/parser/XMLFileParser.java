package main.java.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import main.java.card.CreditCard;

import org.w3c.dom.Node;

public class XMLFileParser implements FileParser {
	@Override
	public List<List<String>> readFile(String fileName){
        List<List<String>> records = new ArrayList<>();

        try {
        	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileName);
            Element cards = doc.getDocumentElement();
            NodeList nList = cards.getElementsByTagName("CARD");
            System.out.println(nList);
            for (int temp = 0; temp < nList.getLength(); temp++) {
            	List<String> innerList = new ArrayList<String>();
            	Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String cardNumber = eElement.getElementsByTagName("CARD_NUMBER").item(0).getTextContent();
                    String expirationDate = eElement.getElementsByTagName("EXPIRATION_DATE").item(0).getTextContent();
                    String nameOfHolder = eElement.getElementsByTagName("CARD_HOLDER_NAME").item(0).getTextContent();
            	
                    innerList.add(cardNumber);
                    innerList.add(expirationDate);
                    innerList.add(nameOfHolder);
                    
                    records.add(innerList);
                }
            }     
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return records;
    }
	
	@Override
	public void writeToFile(List<CreditCard> list, String outputFile) throws FileNotFoundException {

		try {
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();

			DocumentBuilder documentBuilder = df.newDocumentBuilder();

			Document document = documentBuilder.newDocument();

			Element root = document.createElement("Output");

			for (CreditCard card : list) {
				System.out.println(card);
				Element record = document.createElement("Card");

				Element cc = document.createElement("CardNumber");
				cc.appendChild(document.createTextNode(card.getCardNumber()));
				record.appendChild(cc);

				Element cctype = document.createElement("CardType");
				cctype.appendChild(document.createTextNode(card.getCardType()));
				record.appendChild(cctype);

				root.appendChild(record);
			}

			document.appendChild(root);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// document.setXmlStandalone(true);
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(outputFile));

			transformer.transform(domSource, streamResult);

		} catch (ParserConfigurationException | TransformerException pce) {
			pce.printStackTrace();

		}

	}
}
