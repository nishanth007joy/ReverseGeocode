package com.nish.reversegeocoding.remote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.nish.reversegeocoding.bo.LocationBO;
import com.nish.reversegeocoding.remote.dto.TimezoneResponseDTO;
@Service
public class GetTimezoneServiceImpl implements GetTimezoneService {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public LocationBO getTimezone(LocationBO locationBO) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().scheme("https").host("api.geonames.org")
				.path("/timezoneJSON").query("lat=[key1]").buildAndExpand(locationBO.getLatitude());
		ResponseEntity<TimezoneResponseDTO> timezoneResponseDTO = restTemplate.getForEntity(uriComponents.toUri(),
				TimezoneResponseDTO.class);
		locationBO.setTimZone(timezoneResponseDTO.getBody().getTimezoneId());
		return locationBO;
	}

}
