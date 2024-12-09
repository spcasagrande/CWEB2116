package finalProject;
import java.util.Scanner;

public class CreatureManager {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		FileHandler handler = new FileHandler();
		handler.EnsureTableExists();
		boolean keepRunning = true;
		
		while (keepRunning)
		{
			System.out.println("--- Creature Management ---");
			System.out.println("1. Add Creature");
			System.out.println("2. Remove Creature");
			System.out.println("3. Display Creatures");
			System.out.println("4. Filter by Type");
			System.out.println("5. Show Statistics");
			System.out.println("6. Exit");
			String choice = scanner.nextLine();
			
			switch (choice)
			{
			case "1":
				addCreature();
				break;
			case "2":
				removeCreature();
				break;
			case "3":
				displayCreatures();
				break;
			case "4":
				filterCreatures();
				break;
			case "5":
				showStatistics();
				break;
			case "6":
				keepRunning = false;
				break;
			default:
				System.out.println("Please enter a valid choice\n");
			}
		}
		
		scanner.close();
	}

	private static void addCreature()
	{
		FileHandler handler = new FileHandler();
		handler.addCreature();
	}
	
	private static void removeCreature()
	{
		FileHandler handler = new FileHandler();
		handler.removeCreature();
	}
	
	private static void displayCreatures()
	{
		FileHandler handler = new FileHandler();
		handler.displayCreatures();
	}
	
	private static void filterCreatures()
	{
		FileHandler handler = new FileHandler();
		handler.filterCreatures();
	}
	
	private static void showStatistics()
	{
		FileHandler handler = new FileHandler();
		handler.showStatistics();
	}
}
