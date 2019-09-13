package ITestContext.testng;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActualTest {
	@BeforeTest
	public void SetData(ITestContext context) {

		String Customer_id = "C11012034";
		context.setAttribute("CustID", Customer_id);
		System.out.println("Value is stored in ITestContext");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

	}



	@Test
	public void Test1a(ITestContext context) {
		String Customer_id1 = (String) context.getAttribute("CustID");
		System.out.println("In Test1, Value stored in context is: " + Customer_id1);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

	}

	@Test
	public void Test2a(ITestContext context) {
		String Customer_id1 = (String) context.getAttribute("CustID");
		System.out.println("In Test2, Value stored in context is: " + Customer_id1);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

	}
}
