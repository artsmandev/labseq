package dev.artsman.labseq.view;

import dev.artsman.labseq.model.LabSeqModel;
import lombok.Getter;

@Getter
public class LabSeqViewModel {
	private final String data;

	public LabSeqViewModel(LabSeqModel model) {
		data = "l(%d) = %d".formatted(model.index(), model.value());
	}
}
