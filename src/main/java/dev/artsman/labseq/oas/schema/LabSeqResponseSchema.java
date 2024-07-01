package dev.artsman.labseq.oas.schema;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
	name = "LabSeqResponse",
	example = """
		{
		  "data": "l(0) = 0"
		}
		"""
)
public interface LabSeqResponseSchema {
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED)
	String getData();
}
