package com.nish.reversegeocoding.reader;

import org.junit.Test;

public class InputFileReaderImplTest {
	private InputFileReader inputFileReader = new InputFileReaderImpl();

	@Test
	public void testReadFile() {
		inputFileReader.readFile("src/test/resources/Input.csv");
	}

}
