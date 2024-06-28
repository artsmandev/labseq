package dev.artsman.labseq.response;

import dev.artsman.labseq.model.LabSeqModel;
import lombok.Getter;

@Getter
public class LabSeqResponse {
	private final String data;

	public LabSeqResponse(LabSeqModel model) {
		data = "l(%d) = %d".formatted(model.index(), model.value());
	}
}
