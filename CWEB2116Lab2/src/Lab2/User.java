package Lab2;
import java.util.Scanner;

public class User {
	
	private String name;
	private int age;
	private String hobby;
	
	public User(String Name, int Age) {
		name = Name;
		age = Age;
	}
	
	public String DisplayInfo(String name, int age)
	{
		return ("Your name is " + name + ". Your age is " + age + ".");
	}
	public String DisplayInfo(String name, int age, String hobby)
	{
		return ("Your name is " + name + ". Your age is " + age + ". Your hobby is " + hobby + ".");
	}
	public String DisplayInfo(String name, int age, String hobby, int retirement)
	{
		int yearsleft = retirement - age;
		return ("Your name is " + name + ". Your age is " + age + ". Your hobby is " + hobby + ". You will retire in " + yearsleft + " years.");
	}
	
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = myScanner.next();
		System.out.println("Enter your age: ");
		int age = myScanner.nextInt();
		User user = new User(name, age);
		System.out.println(user.DisplayInfo(name, age));

		System.out.println("Enter your hobby: ");
		String hobby = myScanner.next();
		System.out.println(user.DisplayInfo(name, age, hobby));

		//I decided to ask for desired retirement age because it seemed like a better way to go about it than simply assuming that retirement = 65
		System.out.println("Enter your desired retirement age: ");
		int retirement = myScanner.nextInt();
		System.out.println(user.DisplayInfo(name, age, hobby, retirement));
		
		myScanner.close();
	}
}
