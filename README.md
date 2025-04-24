# CENG211 – Programming Fundamentals

## Homework #2

In this homework you are expected to implement a “Climate Measurements Management Application” in Java.  

You should fulfill the concepts of: 

- Inheritance  
- Polymorphism  
- ArrayLists  

In this application, there are 4 types of Climate Measurements: Temperature, wind speed, humidity, and radiation absorption per unit area. Each measurement represents the average value for a certain month of a year. The main reason for this approach is that climate data should represent things for longer time frames.  

All measurements belong to specific locations. These locations can be cities and countries.  

The climate data of countries are used for calculating country-wide temperature statistics, while the data of cities are used for calculating other useful statistics with the 4 measurement types for their respective city.  

There is also another calculation called the “felt temperature” value for cities using all 4 measurement types.  

The country and city names are provided inside the attached “countries_and_cities.csv” file. Only the first element in each row are country names and the rest are city names.  

You should create country and city objects based on this file. Each country and city should have the necessary ArrayList objects that consist of the measurement objects.  

Each measurement object has its own unique measurement values. All of them should also have a year and a month.  

- ClimateMeasurement: year, month  
- Temperature: celciusMeasurement, fahrenheitMeasurement, kelvinMeasurement  
- WindSpeed: metersPerSecond, kmPerHour  
- Humidity: humidityPercentage  
- RadiationAbsorbtion: radiationIntensity, unitAbsorbtionValue  

All these measurements except year, month and radiationIntensity should be of type double.  
“radiationIntensity” is an enum class containing these three fixed values: “low”, “medium”, “high”.  

Measurements inside their objects should be randomly initialized according to the ranges given below:

- 2020 <= year <= 2022  
- January <= month <= December  
- -40.0 <= celciusMeasurement <= 50.0  
- fahrenheitMeasurement: This should be converted from celciusMeasurement.  
- kelvinMeasurement: This should be converted from celciusMeasurement.  
- 0.0 <= metersPerSecond <= 113.2  
- kmPerHour: This should be converted from metersPerSecond.  
- 0.0 <= humidityPercentage <= 100.0  
- 5.0 <= unitAbsorbtionValue <= 20.0  

Note that these ranges do not aim to replicate the real life. They have been made up for this homework.  

Also, “unitAbsorbtionValue” is actually the radiation absorption on human skin per unit area. For the simplicity of the homework, we assume that we can directly use a monthly average value for all humans in a city.  

Remember to initialize measurements of each type for every month from January 2020 to December 2022.  

After initializing all these objects, your application should be able to print out a simple menu and acquire results to some queries.  

You should create a ClimateRecord class that contains all countries and cities inside ArrayList objects. This class should also contain the necessary getter functions for the queries listed below. These getter functions should return appropriate ArrayList objects that have been filtered according to the queries.  

Finally, you should create a class called ClimateApp that performs the necessary calculations for the queries while receiving appropriate ArrayList objects from the ClimateRecord class.  

### Queries:

1. Calculate average temperature for a country depending on the selected options. These options are type of the measurement value (Celsius, Fahrenheit, Kelvin) and year (2020, 2021, 2022).  
2. Calculate average temperature for a city depending on the selected options. These options are type of the measurement value (Celsius, Fahrenheit, Kelvin) and year (2020, 2021, 2022).  
3. Calculate average wind speed for a city depending on the selected options. These options are the unit of speed and month of the year. For example, find Izmir’s average wind speed in km/h in March of the given 3 years (2020, 2021, 2022).  
4. Calculate average humidity of a city across the 3-year period. (no options other than the city name)  
5. Find out how many times throughout a certain year radiationIntensity has been one of the three possible enum values. The options are the year (2020, 2021, 2022) and a specific intensity value (low, medium, high). For example, find how many times the intensity value has become medium in 2022 for Berlin.  
6. Calculate the “felt temperature” value for a specific month of a specific year using the formula provided below. For example, calculate the felt temperature value of July 2021 for Paris.  

---

### Felt Temperature Formula:  

```
FT = CT + 0.3 * H – 0.7 * (RA / (WS + 10))
```

Where:  
- FT: Felt temperature (in Celsius)  
- CT: City temperature (in Celsius)  
- H: Humidity (in [0, 1] interval)  
- WS: Wind speed (in meter/second)  
- RA: Radiation absorption (use unitAbsorbtionValue attribute)  

> Keep in mind that this formula is a heavily simplified version of the felt temperature formula and it does not reflect real life.  

---

### Example Output with Simple Menu:

```
[1] Calculate average temperature for a country according to temperature unit and year.
[2] Calculate average temperature for a city according to temperature unit and year.
[3] Calculate average wind speed for a city according to speed unit and year.
[4] Calculate average humidity of a city for every year.
[5] Count how many times a year a specific radiation intensity value appears.
[6] Calculate the “felt temperature” value for a specific month.
[7] Exit the application.

Please select an option: 2

Enter the name of the city: London

[1] Celsius [2] Fahrenheit [3] Kelvin  
Please select the temperature unit: 5

Incorrect option input! Please reenter another option input: 3

[1] 2020 [2] 2021 [3] 2022  
Please select the year: 2

==> Average temperature of London in Kelvin in 2021: 320.5
*****************************************************************************

[1] Calculate average temperature for a country according to temperature unit and year.
[2] Calculate average temperature for a city according to temperature unit and year.
[3] Calculate average wind speed for a city according to speed unit and year.
[4] Calculate average humidity of a city for every year.
[5] Count how many times a year a specific radiation intensity value appears for a city.
[6] Calculate the “felt temperature” value of a city for a specific month and year.
[7] Exit the application.

Please select an option: 11

Incorrect option input! Please reenter another option input: 5

Enter the name of the city: Ankara

[1] Low [2] Medium [3] High  
Please select a radiation intensity value: 1

[1] 2020 [2] 2021 [3] 2022  
Please select the year: 3

==> Total count of low radiation intensity in Rome in 2022: 6
*****************************************************************************

[1] Calculate average temperature for a country according to temperature unit and year.
[2] Calculate average temperature for a city according to temperature unit and year.
[3] Calculate average wind speed for a city according to speed unit and year.
[4] Calculate average humidity of a city for every year.
[5] Count how many times a year a specific radiation intensity value appears for a city.
[6] Calculate the “felt temperature” value of a city for a specific month and year.
[7] Exit the application.

Please select an option: 7

==> Closing the application…
```

> Note that the outputs and results are provided randomly as simple examples. Also, you should handle incorrect inputs as shown above. Lastly, you can directly use the year options as shown above.

---

## Important Notes:

1. You must use List / ArrayList interfaces in this homework.  
2. You can use standard `java.io` packages to read files. Do NOT use other 3rd party libraries.  
3. You should use relative paths (e.g., `Files/sample.csv`) instead of absolute paths (e.g., `C:\\user\\eclipse-workspace\\MyProject\\Files\\sample.csv`). Please be sure of it, otherwise there will be no output of your application and you certainly will lose points.  
4. To support Turkish characters, you may need to change your project’s text file encoding to UTF8:  
   - Right click on your project (in package explorer) → Properties → Text file encoding → Other → UTF8 → Apply.  
5. You are expected to write clean, readable, and tester-friendly code. Please try to maximize reusability and prevent from redundancy in your methods.  
6. To increase the readability of the code, you are expected to comment your code as much as possible.  

---
