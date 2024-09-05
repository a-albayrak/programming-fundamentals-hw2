package measurementlayer;

public class Measurement {
	private String month;
	private String year;
	
	public Measurement(String month, String year) {
		this.month = month;
		this.year = year;
	}
	
	public String getMonth() {
		return month;
	}
	
	public String getYear() {
		return year;
	}
	
	@Override
    public String toString() {
        return "Measurement{" + "month='" + month + '\'' + ", year='" + year + '\'' + '}';
    }
}