# Reflection API

Java Reflection provides ability to inspect and modify the runtime behavior of application. Using java reflection one can inspect a class, interface, enum, get their structure, methods and fields information at runtime even though class is not accessible at compile time. We can also use reflection to instantiate an object, invoke it’s methods, change field values.

Common methods from Java Reflection APIs

Java Reflection for Classes

	1. Get Class Object		=>      Class<?> cls = Class.forName("package.class");

	2. Get Super Class		=> 	Class<?> superClass = Class.forName("com.journaldev.reflection.ConcreteClass").getSuperclass();

	3. Get Public Member Classes	=>	Class<?>[] classes = concreteClass.getClasses();
						System.out.println(Arrays.toString(classes));
	(representing all the public classes, interfaces and enums that are members of the class)

	4. Get Declared Classes		=>	Class<?>[] explicitClasses = Class.forName("package.class").getDeclaredClasses();
						System.out.println(Arrays.toString(explicitClasses));
	(represent all the classes and interfaces declared as members of the class)

	5. Get Declaring Class		=>	Class<?> innerClass = Class.forName("package.class");
						System.out.println(innerClass.getEnclosingClass().getCanonicalName());
	(returns the Class object representing the class in which it was declared)

	6. Getting Package Name		=>	Class<?> cls = Class.forName("package.class");
						String packageName = cls.getPackage().getName();
	7. Getting Class Modifiers	=>	Class<?> cls = Class.forName("package.class");
						String classModifier = Modifier.toString(cls.getModifiers());
	(getModifiers() method returns the int representation of the class modifiers, we can use java.lang.reflect.Modifier.toString() method to get it in the string format as used in source code.)
	8. Get Type Parameters		=>	TypeVariable<?>[] typeParameters = Class.forName("package.class").getTypeParameters();
						for(TypeVariable<?> t : typeParameters)
							System.out.print(t.getName()+",");
	(getTypeParameters() returns the array of TypeVariable if there are any Type parameters associated with the class.)
	9. Get Implemented Interfaces	=>	Type[] interfaces = Class.forName("package.class").getGenericInterfaces();
						System.out.println(Arrays.toString(interfaces));
	(getGenericInterfaces() method returns the array of interfaces implemented by the class)
	10. Get All Public Methods	=>	Method[] publicMethods = Class.forName("package.class").getMethods();
						System.out.println(Arrays.toString(publicMethods));
	11.Get All Public Constructors	=>	Constructor<?>[] publicConstructors = Class.forName("package.class").getConstructors();
						System.out.println(Arrays.toString(publicConstructors));
	12. Get All Public Fields	=>	Field[] publicFields = Class.forName("package.class").getFields();
						System.out.println(Arrays.toString(publicFields));
	13. Get All Annotations		=>	java.lang.annotation.Annotation[] annotations = Class.forName("package.class").getAnnotations();
						System.out.println(Arrays.toString(annotations));

	14. Get Public Field		=>	Field field = Class.forName("package.class").getField("fieldName");

	15. Field Declaring Class	=>	try {
							Field field = Class.forName("package.class").getField("interfaceInt");
							Class<?> fieldClass = field.getDeclaringClass();
							System.out.println(fieldClass.getCanonicalName()); //prints com.journaldev.reflection.BaseInterface
						} catch (NoSuchFieldException | SecurityException e) {
							e.printStackTrace();
						}

	16. Get Field Type		=>	Field field = Class.forName("package.class").getField("publicFieldOftype_int");
						Class<?> fieldType = field.getType();
						System.out.println(fieldType.getCanonicalName()); //prints int	

	17. Get/Set Public Field Value	=>	Field field = Class.forName("com.journaldev.reflection.ConcreteClass").getField("publicInt");
						ActualClass obj = new ActualClass(5);
						System.out.println(field.get(obj)); //prints 5
						field.setInt(obj, 10); //setting field value to 10 in object
						System.out.println(field.get(obj)); //prints 10


	18. Get/Set Private Field Value	=>	Field privateField = Class.forName("com.journaldev.reflection.ConcreteClass").getDeclaredField("privateString");
						//turning off access check with below method call
						privateField.setAccessible(true);
						ActualClass obj = new ActualClass(1);
						System.out.println(privateField.get(objTest)); // prints "private string"
						privateField.set(objTest, "private string updated");
						System.out.println(privateField.get(objTest)); //prints "private string updated"


	19. Get Public Method		=>	Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
						//get method parameter types, prints "[class java.lang.Object, class java.lang.Object]"
						System.out.println(Arrays.toString(method.getParameterTypes()));
						//get method return type, return "class java.lang.Object", class reference for void
						System.out.println(method.getReturnType());
						//get method modifiers
						System.out.println(Modifier.toString(method.getModifiers())); //prints "public"

	20. Invoking Public Method	=>	Method method = Class.forName("java.util.HashMap").getMethod("put", Object.class, Object.class);
						Map<String, String> hm = new HashMap<>();
						method.invoke(hm, "key", "value");
						System.out.println(hm); // prints {key=value}


	21. Invoking Private Methods	=>	//invoking private method
						Method method = Class.forName("package.class").getDeclaredMethod("privateMethod", argument1.class, int.class);
						method.setAccessible(true);
						method.invoke(arg1, arg2); //invokes "privateMethod"

