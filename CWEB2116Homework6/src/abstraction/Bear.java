package abstraction;

public class Bear extends Animal {

	Bear() {
		System.out.println("BEAR inherits Animal");
	}
	
	Bear(String name) {
		super(name);
		System.out.println("BEAR inherits Animal");
	}
	
	void display() {
		System.out.println("Bear Display");
	}
	
	@Override
	void sound() {
		System.out.println("Sound: Growl");
	}
	
	@Override 
	void food() {
		System.out.println("Food: Meat and Plant Based");
	}
	
	void displayAll() {
		display();
		numOfEyes();
		numOfLimbs();
		sound();
		food();
	}
}
