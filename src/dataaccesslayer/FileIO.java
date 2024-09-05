package dataaccesslayer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import businesslayer.City;
import businesslayer.Country;

public abstract class FileIO {
	private static final String FILENAME = "countries_and_cities.csv";
	
	public static ArrayList<String> cityNameList = new ArrayList<String>();      //String type city and country names to use at menu
	public static ArrayList<String> countryNameList = new ArrayList<String>();
	
	public static ArrayList<City> readCityFile() {                //Returns list with city objects
		ArrayList<City> cityList = new ArrayList<City>();

		try {
            String cityName;
            
        	BufferedReader inFileStream = new BufferedReader(new FileReader(FILENAME));
            String line = inFileStream.readLine();
            
            while (line != null) {
                	StringTokenizer parser = new StringTokenizer(line, ",");
                	String trash = parser.nextToken();
                	
                	int count = parser.countTokens();
                	for (int i=0; i<count; i++) {
                		cityName = parser.nextToken().replaceAll(" ", "");
                		cityNameList.add(cityName);
                		cityList.add(new City(cityName));
                	}
                    line = inFileStream.readLine();
            	}
            
            inFileStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading from file ");
        }
    
		return cityList;
	}
	
	public static ArrayList<Country> readCountryFile() {             //Returns list with country objects
		ArrayList<Country> countryList = new ArrayList<Country>();
		
		try {
            String countryName;

        	BufferedReader inFileStream = new BufferedReader(new FileReader(FILENAME));
            String line = inFileStream.readLine();
            
            while (line != null) {
                	StringTokenizer parser = new StringTokenizer(line, ",");
                	
                	countryName = parser.nextToken();
                	countryNameList.add(countryName);
                	countryList.add(new Country(countryName));
                	
                    line = inFileStream.readLine();
            	}

            inFileStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading from file ");
        }
    
		return countryList;
	}
}