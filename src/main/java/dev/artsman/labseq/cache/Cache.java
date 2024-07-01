package dev.artsman.labseq.cache;

import dev.artsman.labseq.enumeration.LabSeqBase;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class Cache {
	private static final Map<Integer, BigInteger> CACHE;
	static {
		CACHE = new HashMap<>();
		CACHE.put(LabSeqBase.ZERO.index(), LabSeqBase.ZERO.value());
		CACHE.put(LabSeqBase.ONE.index(), LabSeqBase.ONE.value());
		CACHE.put(LabSeqBase.TWO.index(), LabSeqBase.TWO.value());
		CACHE.put(LabSeqBase.THREE.index(), LabSeqBase.THREE.value());
	}

	public void add(Integer key, BigInteger value) {
		CACHE.put(key,value);
	}

	public BigInteger get(Integer key) {
		return CACHE.get(key);
	}

	public boolean has(Integer key) {
		return CACHE.containsKey(key);
	}
}
