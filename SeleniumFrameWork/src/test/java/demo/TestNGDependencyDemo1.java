package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo1 {
	
	//@Test(dependsOnMethods= {"test3","test2"})
		public void test1() {
			System.out.println("I am inside Test 1:");
		}
		
		@Test
		public void test2() {
			System.out.println("I am inside Test 2:");
		}
		
		@Test
		public void test3() {
			System.out.println("I am inside Test 3:");
		}

}
