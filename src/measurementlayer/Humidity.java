package measurementlayer;

import java.util.Random;

public class Humidity extends Measurement{
	private double humidityPercentage;

	public Humidity(String month, String year) {
		super(month, year);
		initializeMeasurements();
	}
	
	private void initializeMeasurements() {
		Random rnd = new Random();
		double temp = rnd.nextDouble(0.0, 100.0);
		humidityPercentage = Math.round(temp * 100.0) / 100.0;
	}
	
	public double getHumidityPercentage() {
		return humidityPercentage;
	}
	
	public double getHumidityInterval() {
		double temp = humidityPercentage / 100;
		return Math.round(temp * 100.0) / 100.0;
	}
	
	@Override
    public String toString() {
        return "Humidity{" +
                "month='" + getMonth() + '\'' +
                ", year='" + getYear() + '\'' +
                ", humidityPercentage=" + humidityPercentage +
                '}';
    }
}