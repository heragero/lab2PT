package lab2PT;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class AllocateTests {
	public class ReferenceClass {
		public int Value;
		ReferenceClass(){
			Value = 1;
		}
	}
	@BeforeEach
	void Setup() {
		Runtime.getRuntime().gc();
	}

	@Test
	void CreateObjectOnStackTest() { 
		long heapSizeBefore = Runtime.getRuntime().totalMemory();
		long var1 = Long.MAX_VALUE;
		long var2 = Long.MAX_VALUE;
		long var3 = Long.MAX_VALUE;
		long var4 = Long.MAX_VALUE;
		long var5 = Long.MAX_VALUE;
		long var6 = Long.MAX_VALUE;
		long heapSizeAfter = Runtime.getRuntime().totalMemory();
		Assert.assertTrue(heapSizeBefore - heapSizeAfter == 0);
	}
	@Test
	void CreateObjectOnHeapTest() {
		long heapSizeBefore = Runtime.getRuntime().totalMemory();
		List<Long> array = new ArrayList<Long>();
		for(long i = 0; i < 100_000_000; i++) {
			array.add(i);
		}
		long heapSizeAfter = Runtime.getRuntime().totalMemory();
		Assert.assertTrue(heapSizeBefore - heapSizeAfter < 0);
	}

}
