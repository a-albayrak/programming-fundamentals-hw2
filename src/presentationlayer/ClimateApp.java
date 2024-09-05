package presentationlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import businesslayer.*;
import dataaccesslayer.*;
import measurementlayer.*;

public class ClimateApp {
	
	public static void main(String[] args) {
		new ClimateApp().mainMenu();
	}

	Scanner keyboard = new Scanner(System.in);
	Query query = new Query();
	
	ArrayList<String> wantedInputList0 = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
	ArrayList<String> wantedInputList1 = new ArrayList<String>(Arrays.asList("1", "2", "3"));
	ArrayList<String> wantedInputList2 = new ArrayList<String>(Arrays.asList("1", "2"));
	ArrayList<String> wantedInputList3 = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")); 
	
	public  void mainMenu() { //Uses 6 menu parts to get the main menu
		
		int option = 0;
		
		while (option != 7) {
			System.out.println("[1] Calculate average temperature for a country according to temperature unit and year.\n"
				+ "[2] Calculate average temperature for a city according to temperature unit and year.\n"
				+ "[3] Calculate average wind speed for a city according to speed unit and month.\n"
				+ "[4] Calculate average humidity of a city for every year.\n"
				+ "[5] Count how many times a year a specific radiation intensity value appears for a city.\n"
				+ "[6] Calculate the \"felt temperature\" value for a specific month and year.\n"
				+ "[7] Exit the application.\n");
			System.out.print("Please select an option: ");
			
				
			String input = keyboard.nextLine();
			option = intInputChecker(input, wantedInputList0); //Checks unwanted inputs and returns a warning - more information at the method definition
			
			switch(option) {
				case 1:
					menuPart1();
					break;
				case 2:
				    menuPart2();
				    break;
				 case 3:
					menuPart3();
					break;
				 case 4:
					 menuPart4();
					 break;
				 case 5:
					 menuPart5();
				break;
				 case 6:
					 menuPart6();
					 break;
			}
		}
	}
	
	
	private void menuPart1() {  //Uses the relevant method from Query class to get the average temperature - same with other menu parts
		System.out.print("\nEnter the name of the country: ");
		String countryName = keyboard.nextLine();
		countryName = stringInputChecker(countryName, FileIO.countryNameList);
		
		System.out.print("\n[1] Celsius [2] Fahrenheit [3] Kelvin\n"
				+ "Please select the temperature unit: ");
		String input0 = keyboard.nextLine();
		int temperatureUnit = intInputChecker(input0, wantedInputList1);
		
		System.out.print("\n[1] 2020 [2] 2021 [3] 2022\n"
				+ "Please select the year: ");
		String input1 = keyboard.nextLine();
		int year = intInputChecker(input1, wantedInputList1);
		
		System.out.println("\n==> Average temperature of " + countryName + " in " + Temperature.stringUnitList.get(temperatureUnit-1)
				+ " in " + City.yearArray[year-1] + ": "  + query.countryAvgTemp(countryName, temperatureUnit, year)
				+ "\n*****************************************************************************\n");
	}
	
	
	private void menuPart2() {
		System.out.print("\nEnter the name of the city: ");
		String cityName = keyboard.nextLine();
		cityName = stringInputChecker(cityName, FileIO.cityNameList);
		
		System.out.print("\n[1] Celsius [2] Fahrenheit [3] Kelvin\n"
				+ "Please select the temperature unit: ");
		String input0 = keyboard.nextLine();
		int temperatureUnit = intInputChecker(input0, wantedInputList1);
		
		System.out.print("\n[1] 2020 [2] 2021 [3] 2022\n"
				+ "Please select the year: ");
		String input1 = keyboard.nextLine();
		int year = intInputChecker(input1, wantedInputList1);
		
		System.out.println("\n==> Average temperature of " + cityName + " in " + Temperature.stringUnitList.get(temperatureUnit-1)
				+ " in " + City.yearArray[year-1] + ": "  + query.cityAvgTemp(cityName, temperatureUnit, year)
				+ "\n*****************************************************************************\n");
	}
	
	
	private void menuPart3() {
		System.out.print("\nEnter the name of the city: ");
		String cityName = keyboard.nextLine();
		cityName = stringInputChecker(cityName, FileIO.cityNameList);
		
		System.out.print("\n[1] m/s [2] km/h\n"
				+ "Please select the speed unit: ");
		String input0 = keyboard.nextLine();
		int speedUnit = intInputChecker(input0, wantedInputList2);
		
		System.out.print("\n[1] January [2] February [3] March [4] April [5] May [6] June [7] July [8] August [9] September [10] October [11] November [12] December\n"
				+ "Please select the month: ");
		String input1 = keyboard.nextLine();
		int month = intInputChecker(input1, wantedInputList3);
		
		System.out.println("\n==> Average wind speed of " + cityName + " in " + WindSpeed.stringSpeedUnitList.get(speedUnit-1)
				+ " in " + City.monthArray[month-1] + ": "  + query.cityAvgWindSpeed(cityName, speedUnit, month)
				+ "\n*****************************************************************************\n");
	}

	
	private void menuPart4() {
		System.out.print("\nEnter the name of the city: ");
		String cityName = keyboard.nextLine();
		cityName = stringInputChecker(cityName, FileIO.cityNameList);
		
		System.out.println("\n==> Average humidity percantage of " + cityName + 
				" across 2020, 2021 and 2022 is: "  + query.cityAvgHumidity(cityName)
				+ "\n*****************************************************************************\n");
	}
	
	
	private void menuPart5() {
		System.out.print("\nEnter the name of the city: ");
		String cityName = keyboard.nextLine();
		cityName = stringInputChecker(cityName, FileIO.cityNameList);
		
		System.out.print("\n[1] Low [2] Medium [3] High\n"
				+ "Please select a radiation intensity value: ");
		String input0 = keyboard.nextLine();
		int intensity = intInputChecker(input0, wantedInputList1);
		
		System.out.print("\n[1] 2020 [2] 2021 [3] 2022\n"
				+ "Please select the year: ");
		String input1 = keyboard.nextLine();
		int year = intInputChecker(input1, wantedInputList1);
		
		System.out.println("\n==> Total count of " + RadiationAbsorbtion.stringIntensityList.get(intensity-1) 
				+ " radiation intensity in "+ cityName + " in " + City.yearArray[year-1] + ": "  + query.cityRadOccurrence(cityName, intensity, year)
				+ "\n*****************************************************************************\n");
	}
	
	
	private void menuPart6() {
		System.out.print("\nEnter the name of the city: ");
		String cityName = keyboard.nextLine();
		cityName = stringInputChecker(cityName, FileIO.cityNameList);
		
		System.out.print("\n[1] 2020 [2] 2021 [3] 2022\n"
				+ "Please select the year: ");
		String input0 = keyboard.nextLine();
		int year = intInputChecker(input0, wantedInputList1);
		
		System.out.print("\n[1] January [2] February [3] March [4] April [5] May [6] June [7] July [8] August [9] September [10] October [11] November [12] December\n"
				+ "Please select the month: ");
		String input1 = keyboard.nextLine();
		int month = intInputChecker(input1, wantedInputList3);
		
		System.out.println("\n==> Felt temperature of " + cityName + " in Celsius" 
		+ " in " + City.yearArray[year-1] + " " + City.monthArray[month-1] +
		": "  + query.cityFeltTemp(cityName, year-1, month-1)
		+ "\n*****************************************************************************\n");
	}

	
	private String stringInputChecker(String input, ArrayList<String> wantedInputList) {   //Gets a string input and a wanted input list ex. {"Ankara","Istanbul"}  
		while(!wantedInputList.contains(input)) {												//If the input is not in the list asks for another input
			System.out.print("Incorrect option input! Please reenter another option input: ");
			input = keyboard.nextLine();
		}
		return input;
	}
	
	private int intInputChecker(String input, ArrayList<String> wantedInputList) {    //Same method but used for integer inputs ex. {"1","2"}
		while(!wantedInputList.contains(input)) {
			System.out.print("Incorrect option input! Please reenter another option input: ");
			input = keyboard.nextLine();
		}
		return Integer.parseInt(input);
	}
}