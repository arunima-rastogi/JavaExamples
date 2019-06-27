package Java_Reflection_Examples;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class ReflectionExecutor {

	public static void main(String[] args) {
		Class<?> cls;
		try {
			// invoke default constructor
			cls = Class.forName("Java_Reflection_Examples.BaseClass");
			Object obj = cls.newInstance(); // invoke default constructor

			// invoke Parameterized constructor
			Constructor<?> cons = cls.getConstructor(int.class);
			obj = cons.newInstance(99);

			// invoke function with no parameters
			Method method = obj.getClass().getMethod("getField1", null);
			method.invoke(obj); // no argument invocation

			// invoke a function with Parameters
			method = obj.getClass().getMethod("getField1", int.class, String.class);
			method.invoke(obj, 99, "Jackychan");

			// get a list of fields declared in class
			Field[] fields = cls.getDeclaredFields();
			for (Field f : fields) {
				System.out.println(f.getName());
			}

			// get list of Annotations at Class level
			Annotation[] annotations = cls.getAnnotations();
			System.out.println(Arrays.toString(annotations));

			// get list of Annotations for a given Method
			annotations = method.getAnnotations();
			System.out.println(Arrays.toString(annotations));

			// Get All public constructors with one or more arguments
			Constructor<?>[] cons1 = cls.getConstructors();
			for (Constructor c : cons1) {
				if (c.getParameterTypes().length >= 1)
					System.out.println(c.toString());
			}

			// Get Package name
			System.out.println(cls.getPackage().getName());

		} catch (IllegalArgumentException | InvocationTargetException | ClassNotFoundException | InstantiationException
				| IllegalAccessException | SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}