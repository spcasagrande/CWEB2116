package finalProject;

public abstract class Creature implements Ability {
	
	String creatureName;
	String creatureType;
	int creatureAge;
	
	void displayName(String creatureName)
	{
		this.creatureName = creatureName;
		System.out.print("Name: " + this.creatureName);
	}
	
	void displayType(String creatureType)
	{
		this.creatureType = creatureType;
		System.out.print("Type: " + this.creatureType);
	}
	
	void displayAge(int creatureAge)
	{
		this.creatureAge = creatureAge;
		System.out.print("Age: " + this.creatureAge);
	}
	
	@Override
	public abstract void displayAbility(String creatureAbility);
}
