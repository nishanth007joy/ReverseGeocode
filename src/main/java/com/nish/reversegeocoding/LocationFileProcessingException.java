package com.nish.reversegeocoding;

public class LocationFileProcessingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 */
	public LocationFileProcessingException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 * @param throwable
	 */
	public LocationFileProcessingException(String message, Throwable throwable) {
		super(message, throwable);
	}
}