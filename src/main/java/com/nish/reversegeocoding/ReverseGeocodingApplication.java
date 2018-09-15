package com.nish.reversegeocoding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nish.reversegeocoding.service.LocationToTimezoneService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ReverseGeocodingApplication implements CommandLineRunner {
	@Autowired
	private LocationToTimezoneService locationToTimezoneService;

	@Override
	public void run(String... args) throws Exception {
		log.info("Input file location is {}",args[0]);
		log.info("Output file location is {}",args[1]);
		locationToTimezoneService.convertLocationToTimezone(args[0],args[1]);
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ReverseGeocodingApplication.class);
		app.run(args);
	}
}
