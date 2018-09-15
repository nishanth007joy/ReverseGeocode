package com.nish.reversegeocoding.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.nish.reversegeocoding.LocationFileProcessingException;
import com.nish.reversegeocoding.bo.LocationBO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InputFileReaderImpl implements InputFileReader {

	@Override
	public List<LocationBO> readFile(String fileLocation) {
		log.info("Entering readFile {}", fileLocation);
		try (Stream<String> stream = Files.lines(Paths.get(fileLocation))) {
			return stream.skip(1)
					.map(line -> LocationBO.builder()
							.vehicleLocationDateTime(
									LocalDateTime.parse(line.split(",")[0], DateTimeFormatter.ISO_LOCAL_DATE_TIME))
							.latitude(Double.parseDouble(line.split(",")[1]))
							.longitude(Double.parseDouble(line.split(",")[2])).build())
					.collect(Collectors.toList());
		} catch (IOException ioException) {
			log.error("Error in reading file", ioException);
			throw new LocationFileProcessingException("Error in reading input file", ioException);
		}
	}

}
