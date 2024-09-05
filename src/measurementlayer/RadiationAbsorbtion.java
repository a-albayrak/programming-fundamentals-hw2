package measurementlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RadiationAbsorbtion extends Measurement{
	public static ArrayList<String> stringIntensityList = new ArrayList<String>(Arrays.asList("low", "medium", "high"));   //String list to use at menu
	
	public enum Intensity {low, medium, high}
	private double unitAbsorbtionValue;
	private Intensity radiationIntensity;

	public RadiationAbsorbtion(String month, String year) {
		super(month, year);
		initializeMeasurements();
	}
	
	private void initializeMeasurements() {
		Random rnd = new Random();
		double temp = rnd.nextDouble(5.0, 20.0);
		unitAbsorbtionValue = Math.round(temp * 100.0) / 100.0;
		
		radiationIntensity = Intensity.values()[new Random().nextInt(Intensity.values().length)];   //Randomly chooses an Intensity enum value
	}
	
	public double getUnitAbsorbtionValue() {
		return unitAbsorbtionValue;
	}
	
	public Intensity getRadiationIntensity() {
		return radiationIntensity;
	}
	
	public boolean intensityEquals(int otherRadiationIntensity) {    //Checks if given intensity is equal to the object's
		
		switch(otherRadiationIntensity) {
		  case 1:
		    return (radiationIntensity == Intensity.low);
		  case 2:
			return (radiationIntensity == Intensity.medium);
		  case 3:
			return (radiationIntensity == Intensity.high); 
		  default:
			return false;
		}
	}
	
	@Override
    public String toString() {
        return "RadiationAbsorbtion{" +
                "month='" + getMonth() + '\'' +
                ", year='" + getYear() + '\'' +
                ", unitAbsorbtionValue=" + unitAbsorbtionValue +
                ", radiationIntensity=" + radiationIntensity +
                '}';
    }
}