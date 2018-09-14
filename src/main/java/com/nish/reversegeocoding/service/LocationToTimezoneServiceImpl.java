package com.nish.reversegeocoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nish.reversegeocoding.bo.LocationBO;
import com.nish.reversegeocoding.reader.InputFileReader;
import com.nish.reversegeocoding.remote.service.GetTimezoneService;
import com.nish.reversegeocoding.writer.OutputFileWriter;

@Service
public class LocationToTimezoneServiceImpl implements LocationToTimezoneService {
	@Autowired
	private InputFileReader inputFileReader;
	@Autowired
	private OutputFileWriter outputFileWriter;
	@Autowired
	private GetTimezoneService getTimezoneService;

	@Override
	public void convertLocationToTimezone() {
		List<LocationBO> input = inputFileReader.readFile("src/test/resources/Input.csv");
		input.stream().findFirst().map(mapper)
		getTimezoneService.getTimezone(locationBO);
	}

}
