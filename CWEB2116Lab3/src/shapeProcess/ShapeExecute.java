package shapeProcess;

public class ShapeExecute {

	public static void main(String[] args) {
		shapePack.Square square = new shapePack.Square();
		shapePack.SemiCircle semi = new shapePack.SemiCircle();
		square.display();
		square.displayRec();
		square.displaySqu();
		System.out.println("---------");
		semi.display();
		semi.displayCir();
		semi.displaySemi();

	}

}
