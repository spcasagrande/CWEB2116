package Lab1;

public class Lab1 {
	
	public static void main(String[] args) {
		
		System.out.println("Hello, my name is Sam");
		System.out.println("My favorite color is purple");
		System.out.println("The current year is 2024");
		
		// This is a single line comment
		/* This is a multi-line
		 * comment */
		
		int age = 27;
		float height = 1.70F;
		char letter = 'S';
		boolean programing = true;
		
		System.out.println("\nI am " + age + " years old");
		System.out.println("I am " + height + " meters tall");
		System.out.println("My favorite letter is " + letter);
		System.out.println("Do I like programing? " + programing);
		
		float pi = 3.14159F;
		int radius = 5;
		float area = pi * (radius * radius);
		
		System.out.println("\nThe area of a circle with a radius of " + radius + " is " + area);
		
		String name = "Sophie";
		Long pop = 1500000L;
		double temp = 16.8D;
		boolean student = false;
		
		System.out.println("\nThe person's name is " + name);
		System.out.println("The population of the city is " + pop);
		System.out.println("The temperature is " + temp + " degrees Celsius");
		System.out.println("Is the person a student? " + student);
		
	}
}
