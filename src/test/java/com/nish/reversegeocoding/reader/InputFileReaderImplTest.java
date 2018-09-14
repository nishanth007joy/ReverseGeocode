package com.nish.reversegeocoding.reader;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Nishanth Mathew Joy
 *
 */
class InputFileReaderImplTest {
	private InputFileReader inputFileReader = new InputFileReaderImpl();
	@Test
	void testReadFile() {
		inputFileReader.readFile("src/test/resources/Input.csv");
	}

}
