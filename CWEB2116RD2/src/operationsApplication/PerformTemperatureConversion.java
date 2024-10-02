package operationsApplication;

import java.util.Scanner;

public class PerformTemperatureConversion {
	
	Scanner scanner = new Scanner(System.in);
	
	public void performConversion () {
		
		boolean keepGoing = true;
		
		while (keepGoing) {
			
			System.out.println("Do you wish to convert to ");
			System.out.println("1. Celsius");
			System.out.println("2. Fahrenheit");
			String answer = scanner.nextLine();
			
			switch (answer)
			{
			case "1":
				System.out.println("Enter temperature to convert to Celsius: ");
				double ftemp = scanner.nextDouble();
				double cresult = operationsLibrary.TemperatureConverter.FahrenheitToCelsius(ftemp);
				System.out.println("Fahrenheit Temperature: " + ftemp);
				System.out.println("Celsius Temperature: " + cresult);
				keepGoing = false;
				break;
			case "2":
				System.out.println("Enter temperature to convert to Fahrenheit: ");
				double ctemp = scanner.nextDouble();
				double fresult = operationsLibrary.TemperatureConverter.CelsiusToFahrenheit(ctemp);
				System.out.println("Celsius Temperature: " + ctemp);
				System.out.println("Fahrenheit Temperature: " + fresult);
				keepGoing = false;
				break;
			default:
				System.out.println("Please enter a valid answer\n");
			}
		}
	}
}
