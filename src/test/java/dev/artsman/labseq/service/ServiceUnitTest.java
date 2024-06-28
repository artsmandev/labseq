package dev.artsman.labseq.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
	@ValueSource(ints = {4, 5})
	@DisplayName("Should fail when index greater than 3")
	void shouldFailWhenIndexGreaterThanThree(int index) {
		var exception = Assertions.assertThrows(RuntimeException.class, () -> service.calculate(index));
		Assertions.assertEquals("To-do", exception.getMessage());
	}
}
