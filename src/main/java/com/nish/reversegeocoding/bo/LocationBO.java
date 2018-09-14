package com.nish.reversegeocoding.bo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationBO {
	private LocalDateTime vehicleLocationDateTime;
	private double latitude;
	private double longitude;
	private String timZone;
	private LocalDateTime localisedVehicleLocationDateTime;
}
