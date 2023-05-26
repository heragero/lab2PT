package lab2PT;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class referenceTypeTests {
	
	public void ChangeAllCharsToDot(char[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = '.';
		}
	}
	@Test
	void ArrayReferenceTypeTest() {
		char[] array = {'a','b','c'};
		char[] finalarray = {'.','.','.'};
		ChangeAllCharsToDot(array);
		Assert.assertArrayEquals(finalarray, array);
	}
	
	
	public class SomeClass{
		public int SomeValue;
		
		public SomeClass(int Value) {
			SomeValue = Value;
		}
	}
	public void DoubleValueOfSomeClass(SomeClass sc) {
		sc.SomeValue = sc.SomeValue*2;
	}
	@Test
	void ClassReferenceTypeTest() {
		var sc = new SomeClass(8);
		DoubleValueOfSomeClass(sc);
		Assert.assertEquals(sc.SomeValue, 16);
	}
}