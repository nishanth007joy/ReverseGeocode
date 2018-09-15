package com.nish.reversegeocoding.writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nish.reversegeocoding.LocationFileProcessingException;
import com.nish.reversegeocoding.bo.LocationBO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OutputFileWriterImpl implements OutputFileWriter {
	@Value("${input.datetime.format}")
	private String dateTimePattern;
	@Override
	public void writeOutput(List<LocationBO> processedFileContent, String outputFileLocation) {
		Path path = Paths.get(outputFileLocation);
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			String outputText = processedFileContent.stream().map(locationBO -> {
				List<String> cswRowList = new ArrayList<>();
				cswRowList.add(locationBO.getVehicleLocationDateTime().format(DateTimeFormatter.ofPattern(dateTimePattern)));
				cswRowList.add(String.valueOf(locationBO.getLatitude()));
				cswRowList.add(String.valueOf(locationBO.getLongitude()));
				cswRowList.add(locationBO.getTimZone());
				cswRowList.add(
						locationBO.getZonedVehicleLocationDateTime().toLocalDateTime().format(DateTimeFormatter.ISO_DATE_TIME));
				return cswRowList;
			}).map(outputLine -> String.join(",", outputLine)).collect(Collectors.joining("\n"));
			log.info("Formatted output is {}", outputText);
			writer.write(outputText);
			writer.flush();
		} catch (IOException ioException) {
			log.error("", ioException);
			throw new LocationFileProcessingException("Error in writing output to file", ioException);
		}
	}

}
