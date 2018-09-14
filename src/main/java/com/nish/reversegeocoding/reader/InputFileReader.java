package com.nish.reversegeocoding.reader;

import java.util.List;

import com.nish.reversegeocoding.bo.LocationBO;

/**
 * 
 * @author Nishanth Mathew Joy
 *
 */
public interface InputFileReader {
	/**
	 * Reads an input file
	 * @param fileLocation
	 * @return
	 */
	public List<LocationBO> readFile(String fileLocation);
}
