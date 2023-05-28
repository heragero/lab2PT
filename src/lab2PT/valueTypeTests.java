package lab2PT;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ValueTypeTests {
	public int CubeInteger(int number) {
		number = number*number*number;
		return number;
	}

	@Test
	void IsCubeFunctionWork() {
		int number = 5;
		Assert.assertEquals(CubeInteger(number), 125);
	}
	@Test
	void IsIntegerAValueType() {
		int number = 5;
		CubeInteger(number);
		Assert.assertEquals(number, 5);
		
	}
}
