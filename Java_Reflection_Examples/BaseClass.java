package Java_Reflection_Examples;

import java.util.ArrayList;
import java.util.List;

@MyAnnotation
public class BaseClass {

	private int field1;

	List<String> list = new ArrayList<String>();

	public BaseClass() {
		this.field1 = 0;
		System.out.println(field1);
	}

	public BaseClass(int number) {
		this.field1 = number;
		System.out.println(field1);
	}

	public int getField1() {
		System.out.println("Helllllllo");
		return this.field1;
	}

	@MyAnnotation
	public void getField1(int n, String s) {
		System.out.println("Hello  " + s + " the number is " + n);
	}

	public List<String> getField(List<String> list) {
		System.out.println(list.size());
		this.list = list;
		return this.list;
	}
}