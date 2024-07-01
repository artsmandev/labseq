package dev.artsman.labseq.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import dev.artsman.labseq.handler.LagSeqResponseEntityExceptionHandler;
import dev.artsman.labseq.service.LabSeqService;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class LabSeqControllerIntegrationTest {
	private final String apiUrl;
	private final MockMvc mockMvc;

	@Autowired
	LabSeqControllerIntegrationTest(LabSeqService service) {
		apiUrl = "/labseq";
		mockMvc = MockMvcBuilders.standaloneSetup(new LabSeqController(service))
			.setControllerAdvice(LagSeqResponseEntityExceptionHandler.class)
			.build();
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, -10, -199})
	@DisplayName("Should return bad request for index negative")
	void shouldReturnBacRequestForIndexNegative(int index) throws Exception {
		mockMvc.perform(
			MockMvcRequestBuilders
				.get(apiUrl + "/{n}", index)
				.contentType(MediaType.APPLICATION_JSON)
		)
		.andExpect(status().isUnprocessableEntity())
		.andExpect(content().string(""));
	}

	@Test
	@DisplayName("Should correctly perform calculate less than ten seconds")
	void shouldCorrectlyPerformCalculateLessThanTenSeconds() {
		var index = 10_000;
		Assertions.assertTimeout(
			Duration.ofSeconds(10),
			() -> {
				mockMvc.perform(
					MockMvcRequestBuilders
						.get(apiUrl + "/{n}", index)
						.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(content().json("""
					{
						"data": "l(10000) = 69950566878097184013157744477635556727868849589082998911839343197880823215346221009722233023943602770307729191665655398407165768121564186987192397693071609846919453430811144389823875683774480880281479951416523467736343974525549960389427464841013320746241755697990287429747307066048835194835534301361435435171244963037487135503198565459610125773779110841477593382691667903942271834984619627946845583317271714790127086723614783681640902031022970893247841818337935296805019561967546398282596597404334400595273408222818081762762981879844447410743730739725556081175617700994424267694361314464204552899258977619983936670456553201627025301979470684612183482967552781789171894406131379502874476544298881442363169258726593616997962614541232149734611181684936265928412294383549494959124156102645749161099774806409315657803977415799277767229630141831326718534674913706653355139"
					}
					"""
				));
			}
		);
	}
}
