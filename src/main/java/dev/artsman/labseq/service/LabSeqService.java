package dev.artsman.labseq.service;

import dev.artsman.labseq.cache.Cache;
import dev.artsman.labseq.enumeration.LabSeqBase;
import java.math.BigInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LabSeqService {
	private final Cache cache;

	public BigInteger calculate(int index) {
		if (cache.has(index)) {
			return cache.get(index);
		}

		if (index < 4) {
			return computeLabSeqValue(index);
		}

		var value = calculateNew(index);
		cache.add(index, value);

		return value;
	}

	private BigInteger calculateNew(int index) {
		var first = calculate(index - 4);
		var second = calculate(index - 3);
		return first.add(second);
	}

	private BigInteger computeLabSeqValue(int index) {
		return index % 2 == 0 ? LabSeqBase.ZERO.value() : LabSeqBase.ONE.value();
	}
}
