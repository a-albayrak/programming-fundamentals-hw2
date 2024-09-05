package measurementlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Temperature extends Measurement{
	public static ArrayList<String> stringUnitList = new ArrayList<String>(Arrays.asList("Celsius", "Fahrenheit", "Kelvin"));  //String list to use at menu
	
	private double celcsiusMeasurement;
	private double fahrenheitMeasurement;
	private double kelvinMeasurement;

	public Temperature(String month, String year) {
		super(month, year);
		initializeMeasurements();
	}
	
	private void initializeMeasurements() {
		Random rnd = new Random();
		
		double temp = rnd.nextDouble(-40.0, 50.0);
		celcsiusMeasurement = Math.round(temp * 100.0) / 100.0;   //Arranges the double to have 2 digits after comma
		
		double temp1 = (celcsiusMeasurement * 9/5) + 32;
		fahrenheitMeasurement = Math.round(temp1 * 100.0) / 100.0;
		
		double temp2 = (celcsiusMeasurement + 273.15);
		kelvinMeasurement = Math.round(temp2 * 100.0) / 100.0;
	}
	
	public double getCelcsiusMeasurement() {
		return celcsiusMeasurement;
	}
	
	public double getFahrenheitMeasurement() {
		return fahrenheitMeasurement;
	}
	
	public double getKelvinMeasurement() {
		return kelvinMeasurement;
	}
	
	@Override
    public String toString() {
        return "Temperature{" +
                "month='" + getMonth() + '\'' +
                ", year='" + getYear() + '\'' +
                ", celcsiusMeasurement=" + celcsiusMeasurement +
                ", fahrenheitMeasurement=" + fahrenheitMeasurement +
                ", kelvinMeasurement=" + kelvinMeasurement +
                '}';
    }
}