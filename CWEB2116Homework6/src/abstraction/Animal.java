package abstraction;

public abstract class Animal {
	
	String animalName;
	
	Animal() {
		System.out.println("This is Animal, an abstract class.");
	}
	
	Animal(String animalName) {
		this.animalName = animalName;
		System.out.println("This is Animal, an abstract class. Current animal: " + this.animalName);
	}
	
	void numOfEyes() {
		if (animalName != null)
		{
			System.out.println(animalName + "  has 2 eyes");
		} else {
			System.out.println("Number of eyes: 2");
		}
	}
	
	void numOfLimbs() {
		if (animalName != null)
		{
			System.out.println(animalName + " has 4 limbs");
		} else {
			System.out.println("Number of limbs: 4");
		}
	}
	
	abstract void sound();
	
	abstract void food();
}
