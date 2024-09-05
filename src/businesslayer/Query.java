package businesslayer;

import java.text.NumberFormat;
import java.util.ArrayList;

import measurementlayer.*;

public class Query {
	ClimateRecord climateRecord = new ClimateRecord();
	
	//Query 1 //Uses the relevant method from climate record to get the filtered list and finds the avg. temperature - similar with the remaining queries
	public String countryAvgTemp(String countryName, int temperatureUnit, int year) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		ArrayList<Temperature> filteredCountryTemperatureList = climateRecord.getFilteredCountryTemperatureList(countryName, year-1);
		double temperatureSum = 0.0;
		
		for(Temperature Temperature : filteredCountryTemperatureList) {
			if (temperatureUnit == 1)
				temperatureSum += Temperature.getCelcsiusMeasurement();
			else if (temperatureUnit == 2)
				temperatureSum += Temperature.getFahrenheitMeasurement();
			else if (temperatureUnit == 3)
				temperatureSum += Temperature.getKelvinMeasurement();
			}
		return nf.format((temperatureSum / filteredCountryTemperatureList.size()));
	}
	
	//Query 2
	public String cityAvgTemp(String cityName, int temperatureUnit, int year) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		ArrayList<Temperature> filteredCityTemperatureList = climateRecord.getFilteredCityTemperatureList(cityName, year-1);
		double temperatureSum = 0.0;
		
		for(Temperature Temperature : filteredCityTemperatureList) {
			if (temperatureUnit == 1)
				temperatureSum += Temperature.getCelcsiusMeasurement();
			else if (temperatureUnit == 2)
				temperatureSum += Temperature.getFahrenheitMeasurement();
			else if (temperatureUnit == 3)
				temperatureSum += Temperature.getKelvinMeasurement();
			}
		return nf.format(temperatureSum / filteredCityTemperatureList.size());
	}
	
	//Query 3
	public String cityAvgWindSpeed(String cityName, int speedUnit, int month) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		ArrayList<WindSpeed> filteredCityWindSpeedList = climateRecord.getFilteredCityWindSpeedList(cityName, month-1);
		double windSpeedSum = 0.0;
		
		for(WindSpeed WindSpeed : filteredCityWindSpeedList) {
			if (speedUnit == 1)
				windSpeedSum += WindSpeed.getMetersPerSecond();
			else if (speedUnit == 2)
				windSpeedSum += WindSpeed.getkmPerHour();
		}
		return nf.format(windSpeedSum / filteredCityWindSpeedList.size());
	}
	
	//Query 4
	public String cityAvgHumidity(String cityName) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		ArrayList<Humidity> filteredCityHumidityList = climateRecord.getFilteredCityHumidityList(cityName);
		double humiditySum = 0.0;
		
		for(Humidity Humidity : filteredCityHumidityList) {
			humiditySum += Humidity.getHumidityPercentage();
		}
		return nf.format(humiditySum / filteredCityHumidityList.size());
	}
	
	//Query 5
	public String cityRadOccurrence(String cityName, int intensity, int year) {
		ArrayList<RadiationAbsorbtion> filteredCityRadiationAbsorbtionList = climateRecord.getFilteredCityRadiationAbsorbtionList(cityName, year-1, intensity);
		
		return String.valueOf(filteredCityRadiationAbsorbtionList.size());
	}
	
	//Query 6
	public String cityFeltTemp(String cityName, int year, int month) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		ArrayList<City> filteredCityList = climateRecord.getFilteredCityList(cityName);
		
		double cityTemperature = 0.0;
		double windSpeed = 0.0;
		double humidity = 0.0;
		double radiation = 0.0;
		
		for (Temperature Temperature : filteredCityList.get(0).getCityTemperatureList()) {
			if(Temperature.getYear().equals(City.yearArray[year]) && Temperature.getMonth().equals(City.monthArray[month]))
				cityTemperature = Temperature.getCelcsiusMeasurement();		
		}	
		
		for (WindSpeed WindSpeed : filteredCityList.get(0).getCityWindSpeedList()) {
			if(WindSpeed.getYear().equals(City.yearArray[year]) && WindSpeed.getMonth().equals(City.monthArray[month]))
				windSpeed = WindSpeed.getMetersPerSecond();		
		}
		
		for (Humidity Humidity : filteredCityList.get(0).getCityHumidityList()) {
			if(Humidity.getYear().equals(City.yearArray[year]) && Humidity.getMonth().equals(City.monthArray[month]))
				humidity = Humidity.getHumidityInterval();		
		}
		
		for (RadiationAbsorbtion RadiationAbsorbtion : filteredCityList.get(0).getCityRadiationAbsorbtionList()) {
			if(RadiationAbsorbtion.getYear().equals(City.yearArray[year]) && RadiationAbsorbtion.getMonth().equals(City.monthArray[month]))
				radiation = RadiationAbsorbtion.getUnitAbsorbtionValue();		
		}
		
		double feltTemperature = cityTemperature + 0.3 * humidity - 0.7 * (radiation/(windSpeed + 10)); 
		
		return nf.format(feltTemperature);
	}
}