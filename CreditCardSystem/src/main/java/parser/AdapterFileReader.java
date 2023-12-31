package main.java.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface AdapterFileReader {
    public ArrayList<String> readCSV(String fileName) throws IOException;
    public ArrayList<String> readJSON(String fileName);
    public ArrayList<String> readXML(String fileName);

    public void writeCSV(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName);
    public void writeJSON(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName);
    public void writeXML(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType, String fileName);
}