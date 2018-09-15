# Reverse Geocode

This project accepts time in UTC, Latitude and Longitude of a a vehicle and it process these information with help of a reverse geocode api to get time zone based one latitude and longitude. Then the local UTC datetime is converted into time zone based datetime and its out put to a csv file inside resources folder of project.

## Getting Started

Clone project to your local machine. Then import as a maven project and this is created as a standalone spring boot project

### Prerequisites

Install maven on your machine and then you can run project from maven. Install IDE like eclipse if you need to run from IDE.


### Installing

Please build project using maven

```
mvn clean install
```

## Running application

You can run the executable spring boot jar from the target folder.

```
java -jar Reversegeocode-0.0.1-SNAPSHOT.jar C:\Users\nisha\Documents\GitHub\ReverseGeocode\src\main\resources\Input.csv C:\Users\nisha\Documents\GitHub\ReverseGeocode\src\main\resources\Output1.csv
```

Where first argument is the location of input file and second argument is location where output of processed input to be saved.


## Authors

* **Nishanth Mathew Joy**

## Acknowledgments

* We have used api.geonames.org for reverse geocoding