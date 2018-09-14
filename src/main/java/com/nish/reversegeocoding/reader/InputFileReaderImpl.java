package com.nish.reversegeocoding.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.nish.reversegeocoding.bo.LocationBO;

@Component
public class InputFileReaderImpl implements InputFileReader {

	@Override
	public List<LocationBO> readFile(String fileLocation) {

		try (Stream<String> stream = Files.lines(Paths.get(fileLocation))) {
			return stream.map(line -> LocationBO.builder().latitude(Double.parseDouble(line.split(",")[1]))
					.longitude(Double.parseDouble(line.split(",")[2])).build()).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
