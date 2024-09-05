# Programming Fundamentals Homework 3: Climate Measurements Management Application

## Overview
In this homework, you are expected to implement a **Climate Measurements Management Application** in Java. This application will utilize concepts such as inheritance, polymorphism, and ArrayLists to model and manage climate data for various locations.

The application will process 4 types of climate measurements:
- **Temperature** (Celsius, Fahrenheit, Kelvin)
- **Wind Speed** (m/s, km/h)
- **Humidity** (Percentage)
- **Radiation Absorption** (Intensity and Unit Absorption Value)

These measurements represent the monthly averages for specific locations (cities and countries). You will calculate statistics and perform queries based on this data.

## Objectives
Your implementation should demonstrate the following:
- Use of **inheritance** and **polymorphism** to model the different climate measurement types.
- Use of **ArrayLists** to store and manage measurement data.
- Creation of **country** and **city objects** based on the provided CSV file (`countries_and_cities.csv`).
- Perform **queries** on the climate data, such as average temperatures, wind speeds, humidity, and radiation intensity.
  
## Climate Measurement Types
Each measurement object will have the following attributes:
- **ClimateMeasurement**: `year`, `month`
- **Temperature**: `celciusMeasurement`, `fahrenheitMeasurement`, `kelvinMeasurement`
- **WindSpeed**: `metersPerSecond`, `kmPerHour`
- **Humidity**: `humidityPercentage`
- **RadiationAbsorption**: `radiationIntensity`, `unitAbsorbtionValue`

Random initialization of measurements will be done within the following ranges:
- **Year**: Between 2020 and 2022
- **Month**: From January to December
- **Temperature**: Between -40.0°C and 50.0°C, with corresponding Fahrenheit and Kelvin conversions
- **Wind Speed**: Between 0.0 m/s and 113.2 m/s, with km/h conversion
- **Humidity**: Between 0% and 100%
- **Radiation Intensity**: Enum values of `low`, `medium`, and `high`
- **Unit Absorption Value**: Between 5.0 and 20.0

### Queries
The application should handle the following queries:
1. Calculate the **average temperature** for a country or city based on the selected temperature unit and year.
2. Calculate the **average wind speed** for a city based on the selected speed unit and month.
3. Calculate the **average humidity** of a city across the three-year period.
4. Count how many times a specific **radiation intensity** value (low, medium, high) appears for a city in a given year.
5. Calculate the **felt temperature** for a specific city and month using the following formula:

    ```text
    FT = CT + 0.3 * H – 0.7 * (RA / (WS + 10))
    ```
    - **FT**: Felt temperature (in Celsius)
    - **CT**: City temperature (in Celsius)
    - **H**: Humidity (in the [0, 1] interval)
    - **WS**: Wind speed (in meter/second)
    - **RA**: Radiation absorption (unitAbsorbtionValue)

### Example Menu Output
```text
[1] Calculate average temperature for a country according to temperature unit and year.
[2] Calculate average temperature for a city according to temperature unit and year.
[3] Calculate average wind speed for a city according to speed unit and month.
[4] Calculate average humidity of a city for every year.
[5] Count how many times a year a specific radiation intensity value appears for a city.
[6] Calculate the "felt temperature" value for a specific month and year.
[7] Exit the application.

Please select an option: 2

Enter the name of the city: London

[1] Celsius [2] Fahrenheit [3] Kelvin
Please select the temperature unit: 5
Incorrect option input! Please reenter another option input: 3

[1] 2020 [2] 2021 [3] 2022
Please select the year: 2

==> Average temperature of London in Kelvin in 2021: 270.95
*****************************************************************************

[1] Calculate average temperature for a country according to temperature unit and year.
[2] Calculate average temperature for a city according to temperature unit and year.
[3] Calculate average wind speed for a city according to speed unit and month.
[4] Calculate average humidity of a city for every year.
[5] Count how many times a year a specific radiation intensity value appears for a city.
[6] Calculate the "felt temperature" value for a specific month and year.
[7] Exit the application.

Please select an option: 11
Incorrect option input! Please reenter another option input: 7
