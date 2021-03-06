package com.nish.reversegeocoding.remote.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.nish.reversegeocoding.bo.LocationBO;
import com.nish.reversegeocoding.remote.dto.TimezoneResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetTimezoneServiceImpl implements GetTimezoneService {

	@Value("${reverse.lookup.url.base}")
	private String baseurl;

	@Value("${reverse.lookup.username}")
	private String userName;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public LocationBO getTimezone(LocationBO locationBO) {
		log.info("Entering getTimezone with locationBO {}", locationBO);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseurl);
		builder.queryParam("lat", locationBO.getLatitude());
		builder.queryParam("lng", locationBO.getLongitude());
		builder.queryParam("username", userName);
		URI uri = builder.build().toUri();
		log.info("uri to call timzone lookup is {}", uri);

		ResponseEntity<TimezoneResponseDTO> timezoneResponseDTO = restTemplate.getForEntity(uri,
				TimezoneResponseDTO.class);
		log.info("Response of calling api {}", timezoneResponseDTO);
		locationBO.setTimZone(timezoneResponseDTO.getBody().getTimezoneId());
		log.info("Returning getTimezone with locationBO {}", locationBO);
		return locationBO;
	}

}
