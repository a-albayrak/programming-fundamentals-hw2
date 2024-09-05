package businesslayer;

import measurementlayer.*;
import java.util.ArrayList;

public class City {
	public static String[] monthArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public static String[] yearArray = {"2020", "2021", "2022"};    //String arrays to initialize city and country objects and to use at the menu
	
	private String cityName;
	private ArrayList<Temperature> cityTemperatureList = new ArrayList<Temperature>();
	private ArrayList<WindSpeed> cityWindSpeedList = new ArrayList<WindSpeed>();
	private ArrayList<Humidity> cityHumidityList = new ArrayList<Humidity>();
	private ArrayList<RadiationAbsorbtion> cityRadiationAbsorbtionList = new ArrayList<RadiationAbsorbtion>();

	public City(String cityName) {
		this.cityName = cityName;
		initializeMeasurements();
	}
		
	private void initializeMeasurements() {		//Creates all measurements for all months for three years and adds them to their respective list's
		for (String year : yearArray) {
			for (String month : monthArray) {	
				cityTemperatureList.add(new Temperature(month, year));
				cityWindSpeedList.add(new WindSpeed(month, year));
				cityHumidityList.add(new Humidity(month, year));
				cityRadiationAbsorbtionList.add(new RadiationAbsorbtion(month, year));
			}
		}
	}

	public String getCityName() {
		return cityName;
	}
	
	public ArrayList<Temperature> getCityTemperatureList() {
		return cityTemperatureList;
	}
	
	public ArrayList<WindSpeed> getCityWindSpeedList() {
		return cityWindSpeedList;
	}
	
	public ArrayList<Humidity> getCityHumidityList() {
		return cityHumidityList;
	}
	
	public ArrayList<RadiationAbsorbtion> getCityRadiationAbsorbtionList() {
		return cityRadiationAbsorbtionList;
	}
	
	@Override
    public String toString() {
        return "City: " + cityName;
    }
}