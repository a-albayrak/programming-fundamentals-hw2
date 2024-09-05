package businesslayer;

import java.util.ArrayList;
import dataaccesslayer.*;
import measurementlayer.*;

public class ClimateRecord {
	ArrayList<City> cityList = FileIO.readCityFile();
	ArrayList<Country> countryList = FileIO.readCountryFile();
	
	//Query 1 //Filters the country temperature list according to user input
	public ArrayList<Temperature> getFilteredCountryTemperatureList(String selectedCountryName, int selectedYear){
		
		ArrayList<Temperature> filteredTemperatureList = new ArrayList<Temperature>(); 
			
		for (int i = 0; i<countryList.size(); i++) {
			if(countryList.get(i).getCountryName().equals(selectedCountryName)) {
				for (Temperature Temperature : countryList.get(i).getCountryTemperatureList()) {
					if(Temperature.getYear().equals(City.yearArray[selectedYear])) 
						filteredTemperatureList.add(Temperature);
				}
			}
		}
		return filteredTemperatureList;	
	}
	
	//Query 2 //Filters the city temperature list according to user input - same with the remaining queries
	public ArrayList<Temperature> getFilteredCityTemperatureList(String selectedCityName, int selectedYear){
		
		ArrayList<Temperature> filteredTemperatureList = new ArrayList<Temperature>(); 
			
		for (int i = 0; i<cityList.size(); i++) {
			if(cityList.get(i).getCityName().equals(selectedCityName)) {
				for (Temperature Temperature : cityList.get(i).getCityTemperatureList()) {
					if(Temperature.getYear().equals(City.yearArray[selectedYear])) 
						filteredTemperatureList.add(Temperature);
				}
			}
		}
		return filteredTemperatureList;	
	}
	
	//Query 3
	public ArrayList<WindSpeed> getFilteredCityWindSpeedList(String selectedCityName, int selectedMonth){
		
		ArrayList<WindSpeed> filteredWindSpeedList = new ArrayList<WindSpeed>();
		
		for (int i = 0; i<cityList.size(); i++) {
			if(cityList.get(i).getCityName().equals(selectedCityName)) {
				for (WindSpeed WindSpeed : cityList.get(i).getCityWindSpeedList()) {
					if(WindSpeed.getMonth().equals(City.monthArray[selectedMonth]))
						filteredWindSpeedList.add(WindSpeed);
				}
			}
		}
		return filteredWindSpeedList;
	}
	
	//Query 4
	public ArrayList<Humidity> getFilteredCityHumidityList(String selectedCityName){
		
		ArrayList<Humidity> filteredHumidityList = new ArrayList<Humidity>();
		
		for (int i = 0; i<cityList.size(); i++) {
			if(cityList.get(i).getCityName().equals(selectedCityName)) {
				for (Humidity Humidity : cityList.get(i).getCityHumidityList()) {
					filteredHumidityList.add(Humidity);
				}
			}		
		}
		return filteredHumidityList;
	}
	
	//Query 5
	public ArrayList<RadiationAbsorbtion> getFilteredCityRadiationAbsorbtionList(String selectedCityName, int selectedYear, int selectedIntensity){
		
		ArrayList<RadiationAbsorbtion> filteredRadiationAbsorbtionList = new ArrayList<RadiationAbsorbtion>();
		
		for (int i = 0; i<cityList.size(); i++) {
			if(cityList.get(i).getCityName().equals(selectedCityName)) {
				for (RadiationAbsorbtion RadiationAbsorbtion : cityList.get(i).getCityRadiationAbsorbtionList()) {
					if(RadiationAbsorbtion.getYear().equals(City.yearArray[selectedYear]) && RadiationAbsorbtion.intensityEquals(selectedIntensity)) 
						filteredRadiationAbsorbtionList.add(RadiationAbsorbtion);
				}
			}
		}
		return filteredRadiationAbsorbtionList;
	}
	
	//Query 6
		public ArrayList<City> getFilteredCityList(String selectedCityName){
			
			ArrayList<City> filteredCityList = new ArrayList<City>(); 
			
			for (City City : cityList) {
				if(City.getCityName().equals(selectedCityName))
					filteredCityList.add(City);
			
			}
			return filteredCityList;	
		}
}