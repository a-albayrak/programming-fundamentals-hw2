package measurementlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WindSpeed extends Measurement{
	public static ArrayList<String> stringSpeedUnitList = new ArrayList<String>(Arrays.asList("m/s", "km/h"));  //String list to use at menu
	
	private double metersPerSecond;
	private double kmPerHour;
	
	public WindSpeed(String month, String year) {
		super(month, year);
		initializeMeasurements();
	}
	
	private void initializeMeasurements() {
		Random rnd = new Random();
		
		double temp = rnd.nextDouble(0.0, 113.2);
		metersPerSecond = Math.round(temp * 100.0) / 100.0;
		
		double temp1 = metersPerSecond * 3.6;
		kmPerHour = Math.round(temp1 * 100.0) / 100.0;
	}
	
	public double getMetersPerSecond() {
		return metersPerSecond;
	}
	
	public double getkmPerHour() {
		return kmPerHour;
	}
	
	@Override
	public String toString() {
	    return "WindSpeed{" +
	            "month='" + getMonth() + '\'' +
	            ", year='" + getYear() + '\'' +
	            ", metersPerSecond=" + metersPerSecond +
	            ", kmPerHour=" + kmPerHour +
	            '}';
	}
}