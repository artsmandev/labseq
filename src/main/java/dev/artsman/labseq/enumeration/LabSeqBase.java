package dev.artsman.labseq.enumeration;

import java.math.BigInteger;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@Accessors(fluent = true)
@Getter
public enum LabSeqBase {
	ZERO(0, BigInteger.valueOf(0)),
	ONE(1, BigInteger.valueOf(1)),
	TWO(2, BigInteger.valueOf(0)),
	THREE(3, BigInteger.valueOf(1));

	private final Integer index;
	private final BigInteger value;
}
