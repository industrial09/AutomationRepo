package mainScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestFirst extends TestNGMethods{
	@Test
	public void anything() throws InterruptedException {
		//gotToSite2();
		handleWindows();
	}
	
	@AfterTest
	public void closeWindows() {
		tearDown();
	}
}
