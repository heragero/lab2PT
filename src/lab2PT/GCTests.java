package lab2PT;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GCTests {
	public class ReferenceClass {
		public int Value;
		ReferenceClass(){
			Value = 1;
		}
	}
	public class SomeClass {
		public List<ReferenceClass> ListOfClasses;
		SomeClass(){
			ListOfClasses = new ArrayList<ReferenceClass>();
		}
		public void AddSomeClassesToList() {
			for(int i = 0; i <= 100_000_000; i++) {
				var temp = new ReferenceClass();
				this.ListOfClasses.add(temp);
			}
		}
	}

	@Test
	void TestWhenClassGetNullpointer() {
		var sc = new SomeClass();
		sc.AddSomeClassesToList();
		long heapSizeBefore = Runtime.getRuntime().totalMemory();
		System.out.println("Before: " + heapSizeBefore/1024/1024);
		sc = null;
		Runtime.getRuntime().gc();
		long heapSizeAfter = Runtime.getRuntime().totalMemory();
		System.out.println("After: " + heapSizeAfter/1024/1024);
		Assert.assertTrue((heapSizeAfter - heapSizeBefore) < -1000000);
	}
	@Test
	void TestWhenManyClassesSetToNull() 
	{
		for(int i = 0; i < 1_000_000; i++) {
			var obj = new ReferenceClass();
			obj = null;
		}
		long heapSizeBefore = Runtime.getRuntime().totalMemory();
		System.out.println("Before: " + heapSizeBefore/1024/1024);
		Runtime.getRuntime().gc();
		long heapSizeAfter = Runtime.getRuntime().totalMemory();
		System.out.println("After: " + heapSizeAfter/1024/1024);
		Assert.assertTrue((heapSizeAfter - heapSizeBefore) < -1000000);
		
	}
			
	

}
