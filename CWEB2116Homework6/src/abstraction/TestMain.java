package abstraction;

public class TestMain {

	public static void main(String[] args) {
		
		System.out.println("ANIMAL'S PROPERTIES");
		
		Utility utility = new Utility();
		
		String lionName = utility.checkForName("Lion");
		Lion lion = utility.getLionObject(lionName);
		lion.displayAll();
		System.out.println("------------\n");
		
		String giraffeName = utility.checkForName("Giraffe");
		Giraffe giraffe = utility.getGiraffeObject(giraffeName);
		giraffe.displayAll();
		System.out.println("------------\n");
		
		String bearName = utility.checkForName("Bear");
		Bear bear = utility.getBearObject(bearName);
		bear.displayAll();
		System.out.println("===============================");
	}

}
