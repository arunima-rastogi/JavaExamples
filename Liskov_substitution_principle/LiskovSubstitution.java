package Liskov_substitution_principle;

public class LiskovSubstitution {
	
	public static void main(String[] args) {
		SuperClass obj = new SubClass();
		obj.function();
	}

}
