package dev.artsman.labseq.service;

import dev.artsman.labseq.cache.Cache;
import dev.artsman.labseq.enumeration.LabSeqBase;
import java.math.BigInteger;
import java.time.Duration;
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
		service = new LabSeqService(new Cache());
	}

	@Test
	@DisplayName("Should return 0 to index = 0")
	void shouldReturnZeroToIndexZero() {
		var zero = LabSeqBase.ZERO;
		var value = service.calculate(zero.index());
		Assertions.assertEquals(zero.value(), value);
	}

	@Test
	@DisplayName("Should return 1 to index = 1")
	void shouldReturnOneToIndexOne() {
		var one = LabSeqBase.ONE;
		var value = service.calculate(one.index());
		Assertions.assertEquals(one.value(), value);
	}

	@Test
	@DisplayName("Should return 0 to index = 2")
	void shouldReturnZeroToIndexTwo() {
		var two = LabSeqBase.TWO;
		var value = service.calculate(two.index());
		Assertions.assertEquals(two.value(), value);
	}

	@Test
	@DisplayName("Should return 1 to index = 3")
	void shouldReturnOneToIndexThree() {
		var three = LabSeqBase.THREE;
		var value = service.calculate(three.index());
		Assertions.assertEquals(three.value(), value);
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
	void shouldSuccessfullyCalculateIndexGraterThanThree(int index, BigInteger expectedValue) {
		var value = service.calculate(index);
		Assertions.assertEquals(expectedValue, value);
	}
}
