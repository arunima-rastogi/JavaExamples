package sharingParamsAcrossTestngSuites;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ActualTest {
	@Test
	@Parameters({ "username" })
	public void f(String userName) {
		Assert.assertTrue(userName.equals("testng"));
		System.out.println(System.getProperty("user.dir")+"\\testng.xml");
	}
}
