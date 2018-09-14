package com.nish.reversegeocoding.remote.service;

import com.nish.reversegeocoding.bo.LocationBO;

public interface GetTimezoneService {
	/**
	 * 
	 * @param locationBO
	 * @return
	 */
	public LocationBO getTimezone(LocationBO locationBO);
}
