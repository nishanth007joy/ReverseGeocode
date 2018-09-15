package com.nish.reversegeocoding.service;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;

import com.nish.reversegeocoding.basetest.BaseTest;
import com.nish.reversegeocoding.bo.LocationBO;
import com.nish.reversegeocoding.reader.InputFileReader;
import com.nish.reversegeocoding.remote.service.GetTimezoneService;
import com.nish.reversegeocoding.writer.OutputFileWriter;

public class LocationToTimezoneServiceImplTest extends BaseTest {
	@InjectMocks
	private LocationToTimezoneService locationToTimezoneService = new LocationToTimezoneServiceImpl();
	@Mock
	private InputFileReader inputFileReader;
	@Mock
	private OutputFileWriter outputFileWriter;
	@Mock
	private GetTimezoneService getTimezoneService;

	@Test
	public void testConvertLocationToTimezone() {
		List<LocationBO> inputList = Arrays.asList(LocationBO.builder().latitude(-44.490947).longitude(171.220966)
				.vehicleLocationDateTime(LocalDateTime.parse("2013-07-10T02:52:49")).build());
		LocationBO locationBO = LocationBO.builder()
				.latitude(-44.490947).longitude(171.220966).vehicleLocationDateTime(LocalDateTime.parse("2013-07-10T02:52:49"))
		.timZone("Pacific/Auckland").build();
		when(inputFileReader.readFile(Matchers.anyString())).thenReturn(inputList);
		doNothing().when(outputFileWriter).writeOutput(Matchers.anyListOf(LocationBO.class), Matchers.anyString());
		when(getTimezoneService.getTimezone(Matchers.any(LocationBO.class))).thenReturn(locationBO);
		locationToTimezoneService.convertLocationToTimezone("./src/resources/input.csv", "./src/resources/output.csv");
		verify(outputFileWriter, times(1)).writeOutput(Arrays.asList(locationBO), "./src/resources/output.csv");
	}

}
