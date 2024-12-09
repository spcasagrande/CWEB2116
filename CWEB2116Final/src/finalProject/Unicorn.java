package finalProject;

public class Unicorn extends Creature {
	
	void displayName(String name)
	{
		System.out.print("Name: " + name + ", ");
	}
	
	void displayType(String type)
	{
		System.out.print("Type: " + type + ", ");
	}
	
	void displayAge(int age)
	{
		System.out.print("Age: " + age + ", ");
	}
	
	@Override
	public void displayAbility(String ability)
	{
		System.out.print("Horn Color: " + ability);
	}
}
