package lab2PT;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class MemoryFragmentationTest {

	private static final int NUM_ARRAYS = 1_000_000;
    private static final int ARRAY_SIZE = 1_000_000;

	@BeforeEach
	void SetUp() {
		System.out.println(Runtime.getRuntime().freeMemory());
	}
	private static void allocateLargeArray() {
        byte[][] arrays = new byte[NUM_ARRAYS][];
        
        for (int i = 0; i < NUM_ARRAYS; i++) {
            
             arrays[i] = new byte[ARRAY_SIZE];
        }
        
       
	}
	@Test
	void MemoryFragmentationCatchTest() {
		Assert.assertThrows(OutOfMemoryError.class, () -> {
			allocateLargeArray();
		});
		System.out.println(Runtime.getRuntime().freeMemory());
    	System.out.println(Runtime.getRuntime().totalMemory());
	}
	
	@Test
	void IsAFreeMemoryForArray() {
		Assert.assertTrue(Runtime.getRuntime().freeMemory() - ARRAY_SIZE > ARRAY_SIZE*10);
	}

}
