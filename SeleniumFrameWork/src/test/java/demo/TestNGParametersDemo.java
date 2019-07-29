package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {
		
	@Test
	@Parameters({"MyName"})
	//@Optional is inputed when value is not provided at the xml side. it can carry value as well
	public void test(@Optional("Jahblez") String name) {
		System.out.println("Name is :"+ name);
	}

}
