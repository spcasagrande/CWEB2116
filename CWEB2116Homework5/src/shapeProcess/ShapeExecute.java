package shapeProcess;
import java.util.Scanner;

public class ShapeExecute {

	public static void main(String[] args) {
		shapePack.Square square = new shapePack.Square();
		shapePack.SemiCircle semi = new shapePack.SemiCircle();
		Scanner scanner = new Scanner(System.in);
		
		square.display();
		square.displayRec();
		square.displaySqu();
		
		// square area calculation
		System.out.println("\nArea of a Square");
		System.out.print("Enter the measure of a side: ");
		float SquareSide = scanner.nextFloat();
		square.calculateArea(SquareSide);
		
		// rectangle area calculation
		System.out.println("\nArea of a Rectangle");
		System.out.print("Enter the measure of side one: ");
		float side1 = scanner.nextFloat();
		System.out.print("Enter the measure of side two: ");
		float side2 = scanner.nextFloat();
		square.calculateArea(side1, side2);
		
		System.out.println("\n---------");
		semi.display();
		semi.displayCir();
		semi.displaySemi();
		
		scanner.close();

	}

}
