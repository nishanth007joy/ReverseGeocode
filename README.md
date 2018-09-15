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

## Input file sample

```
UTC Datetime,latitude,longitude
2013-07-10 02:52:49,-44.490947,171.220966
```
Here first row is the header and its ignored by the program and its only for human redable header to understand csv file

## Output file sample for above input

```
2013-07-10 02:52:49,-44.490947,171.220966,Pacific/Auckland,2013-07-10T14:52:49
```
Here output file has first three columns same as input and fourth is the timezone location and fifth is the UTC time converted to timezone specific to coordinates.


## Authors

* **Nishanth Mathew Joy**

## Acknowledgments

* We have used api.geonames.org for reverse geocoding