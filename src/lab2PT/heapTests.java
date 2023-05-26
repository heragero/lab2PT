package lab2PT;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class heapTests {

	public void OutOfMemoryThrower() {
		List<Integer> Thrower = new ArrayList<Integer>();
		try{
			while(true) {
			Thrower.add(10000); 
			}
		}
		finally {
			long heapSize = Runtime.getRuntime().totalMemory(); 
			System.out.println("Allocated memory: " + heapSize/1024/1024/1024 + " GB");
		}
		
	}
	@Test
	public void test() {
		Assert.assertThrows(OutOfMemoryError.class, () -> {
			OutOfMemoryThrower();
		});
	}
	
}
