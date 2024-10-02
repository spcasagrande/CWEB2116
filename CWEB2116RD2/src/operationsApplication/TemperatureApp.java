package operationsApplication;

public class TemperatureApp {

	public static void main (String[] args) {
		
		System.out.println("Temperature Conversion");
		System.out.println("----------------------");
		PerformTemperatureConversion conversion = new PerformTemperatureConversion();
		conversion.performConversion();
	}
}
