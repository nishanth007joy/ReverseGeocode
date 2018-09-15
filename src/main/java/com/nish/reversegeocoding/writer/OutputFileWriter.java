package com.nish.reversegeocoding.writer;

import java.util.List;

import com.nish.reversegeocoding.bo.LocationBO;

public interface OutputFileWriter {
	/**
	 * 
	 * @param processedFileContent
	 */
	public void writeOutput(List<LocationBO> processedFileContent, String outputFileLocation);
}
