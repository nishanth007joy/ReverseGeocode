package com.nish.reversegeocoding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nish.reversegeocoding.reader.InputFileReader;
import com.nish.reversegeocoding.writer.OutputFileWriter;

@Service
public class LocationToTimezoneServiceImpl implements LocationToTimezoneService {
	@Autowired
	private InputFileReader inputFileReader;
	@Autowired
	private OutputFileWriter outputFileWriter;

	@Override
	public void convertLocationToTimezone() {

	}

}
