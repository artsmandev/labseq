package dev.artsman.labseq.oas;

import dev.artsman.labseq.oas.schema.LabSeqResponseSchema;
import dev.artsman.labseq.view.LabSeqViewModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.validator.constraints.Range;

@Tag(name = "LabSeq", description = "LabSed Sequence")
public interface LabSeqOpenApiSpec {
	@Operation(
		summary = "LabSeq Sequence.",
		description = """
			Returning a value from the LabSeq sequence.<br>
			The index may be any <b>non-negative</b> integer number.
			""",
		parameters = @Parameter(
			in = ParameterIn.PATH,
			name = "n",
			description = "The index to be calculated.",
			example = "0"
		),
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "Given a value, will be calculate and returned its representation value from LabSeq Sequence.",
				content = {
					@Content(
						mediaType = "application/json",
						schema = @Schema(implementation = LabSeqResponseSchema.class)
					)
				}
			),
			@ApiResponse(
				responseCode = "422",
				description = "The index can't be negative.",
				content = {@Content}
			)
		}
	)
	LabSeqViewModel calculate(@Range int index);
}
