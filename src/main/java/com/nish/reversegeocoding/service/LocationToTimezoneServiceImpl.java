package com.nish.reversegeocoding.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nish.reversegeocoding.bo.LocationBO;
import com.nish.reversegeocoding.reader.InputFileReader;
import com.nish.reversegeocoding.remote.service.GetTimezoneService;
import com.nish.reversegeocoding.writer.OutputFileWriter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LocationToTimezoneServiceImpl implements LocationToTimezoneService {
	@Autowired
	private InputFileReader inputFileReader;
	@Autowired
	private OutputFileWriter outputFileWriter;
	@Autowired
	private GetTimezoneService getTimezoneService;

	@Override
	public void convertLocationToTimezone() {
		List<LocationBO> input = inputFileReader.readFile("./src/main/resources/Input.csv");
		log.info("input from location file is {}", input);
		List<LocationBO> processedOut = input.stream().map(locationBO -> getTimezoneService.getTimezone(locationBO))
				.map(locationBO -> {
					ZoneId zoneID = ZoneId.of(locationBO.getTimZone());
					ZonedDateTime zonedDateTime = ZonedDateTime.of(locationBO.getVehicleLocationDateTime(), zoneID);
					log.info("Changed timezone is {}", zonedDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
					locationBO.setZonedVehicleLocationDateTime(zonedDateTime);
					return locationBO;
				}).collect(Collectors.toList());
		outputFileWriter.writeOutput(processedOut);
	}

}
