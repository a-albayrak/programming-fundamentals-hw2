package businesslayer;

import measurementlayer.*;
import java.util.ArrayList;

public class Country {
	private String countryName;
	private ArrayList<Temperature> countryTemperatureList = new ArrayList<Temperature>();
	
	public Country(String countryName) {
		this.countryName = countryName;
		initializeMeasurements();
	}
		
	private void initializeMeasurements() {		
		for (String year : City.yearArray) {
			for (String month : City.monthArray) {	
				countryTemperatureList.add(new Temperature(month, year));
			}
		}
	}

	public String getCountryName() {
		return countryName;
	}
	
	public ArrayList<Temperature> getCountryTemperatureList() {
		return countryTemperatureList;
	}
	
	@Override
    public String toString() {
        return "Country Name: " + countryName;
    }
}