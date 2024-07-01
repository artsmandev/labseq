package dev.artsman.labseq.controller;

import dev.artsman.labseq.model.LabSeqModel;
import dev.artsman.labseq.service.LabSeqService;
import dev.artsman.labseq.view.LabSeqViewModel;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/labseq")
@RequiredArgsConstructor
class LabSeqController {
	private final LabSeqService service;

	@GetMapping("/{n}")
	@ResponseStatus(HttpStatus.OK)
	LabSeqViewModel calculate(@PathVariable("n") @Range int index) {
		var value = service.calculate(index);
		var model = new LabSeqModel(index, value);
		return new LabSeqViewModel(model);
	}
}
