package dev.artsman.labseq.service;

import org.springframework.stereotype.Service;

@Service
public class LabSeqService {
	public int calculate(int index) {
		if (index < 4) {
			return index % 2 == 0 ? 0 : 1;
		}
		return calculate(index - 4) + calculate(index - 3);
	}
}
