package shapePack;

public class Rectangle extends Shape {
	
	public void displayRec() {
		System.out.println("This is Rectangle. Subclass of Shape");
	}

	public void calculateArea(float side1, float side2) {
		float area = side1 * side2;
		System.out.println("RESULT: Area of the Rectangle = " + area);
	}
}
