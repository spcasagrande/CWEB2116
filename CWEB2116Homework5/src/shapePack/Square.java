package shapePack;

public class Square extends Rectangle {

	public void displaySqu() {
		System.out.println("This is Square. Subclass of Rectangle");
	}
	
	public void calculateArea(float side1) {
		float area = side1 * side1;
		System.out.println("RESULT: Area of the Square is = " + area);
	}
}
