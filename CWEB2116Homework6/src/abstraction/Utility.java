package abstraction;
import java.util.Scanner;

public class Utility {
	
	Scanner scanner = new Scanner(System.in);
	
	public String checkForName(String animal) {
		
		System.out.print("Do you have a name for " + animal + "? (y/n): ");
		String answer = scanner.nextLine();
		
		if (answer.equalsIgnoreCase("y"))
		{
			System.out.print("Enter the name: ");
			String name = scanner.nextLine();
			return name;
		}
		else
		{
			String name = null;
			return name;
		}
	}
	
	public Lion getLionObject(String lionName) {
		if (lionName != null)
		{
			Lion lionObj = new Lion(lionName);
			return lionObj;
		}
		else 
		{
			Lion lionObj = new Lion();
			return lionObj;
		}
	}
	
	public Giraffe getGiraffeObject(String giraffeName) {
		if (giraffeName != null)
		{
			Giraffe giraffeObj = new Giraffe(giraffeName);
			return giraffeObj;
		}
		else 
		{
			Giraffe giraffeObj = new Giraffe();
			return giraffeObj;
		}
	}
	
	public Bear getBearObject(String bearName) {
		if (bearName != null)
		{
			Bear bearObj = new Bear(bearName);
			return bearObj;
		}
		else 
		{
			Bear bearObj = new Bear();
			return bearObj;
		}
	}

}
