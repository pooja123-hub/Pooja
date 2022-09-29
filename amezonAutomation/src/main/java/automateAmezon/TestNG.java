package automateAmezon;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {

	@BeforeClass
	private void beforeClass() {
		System.out.println("psb");
	}
	
	@BeforeMethod
	private void beforemethod() {
		System.out.println("psb");
	}
	
	@Test
	private void beforTest() {
		System.out.println("psb");
	}
}
