package dev.artsman.labseq.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ServiceUnitTest {
	private LabSeqService service;

	@BeforeEach
	void setup() {
		service = new LabSeqService();
	}

	@Test
	@DisplayName("Should return 0 to index = 0")
	void shouldReturnZeroToIndexZero() {
		var index = 0;
		var value = service.calculate(index);
		Assertions.assertEquals(0, value);
	}

	@Test
	@DisplayName("Should return 1 to index = 1")
	void shouldReturnOneToIndexOne() {
		var index = 1;
		var value = service.calculate(index);
		Assertions.assertEquals(1, value);
	}

	@Test
	@DisplayName("Should return 0 to index = 2")
	void shouldReturnZeroToIndexTwo() {
		var index = 2;
		var value = service.calculate(index);
		Assertions.assertEquals(0, value);
	}

	@Test
	@DisplayName("Should return 1 to index = 3")
	void shouldReturnOneToIndexThree() {
		var index = 3;
		var value = service.calculate(index);
		Assertions.assertEquals(1, value);
	}

	@ParameterizedTest
	@CsvSource(
		value = {
			"4,1",
			"5,1",
			"6,1",
			"7,2",
			"8,2",
			"9,2",
			"10,3"
		}
	)
	@DisplayName("Should successfully calculate index greater than 3")
	void shouldSuccessfullyCalculateIndexGraterThanThree(int index, int expectedValue) {
		var value = service.calculate(index);
		Assertions.assertEquals(expectedValue, value);
	}
}
