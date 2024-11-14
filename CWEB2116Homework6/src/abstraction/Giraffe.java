package abstraction;

public class Giraffe extends Animal {

	Giraffe() {
		System.out.println("GIRAFFE inherits Animal");
	}
	
	Giraffe(String name) {
		super(name);
		System.out.println("GIRAFFE inherits Animal");
	}
	
	void display() {
		System.out.println("Giraffe Display");
	}
	
	@Override
	void sound() {
		System.out.println("Sound: Bleat");
	}
	
	@Override 
	void food() {
		System.out.println("Food: Plant Based");
	}
	
	void displayAll() {
		display();
		numOfEyes();
		numOfLimbs();
		sound();
		food();
	}
}
