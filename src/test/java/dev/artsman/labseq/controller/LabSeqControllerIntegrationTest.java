package dev.artsman.labseq.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import dev.artsman.labseq.handler.LagSeqResponseEntityExceptionHandler;
import dev.artsman.labseq.service.LabSeqService;
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
}
