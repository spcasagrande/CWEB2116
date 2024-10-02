package operationsUnitTesting;

import org.junit.Assert;
import org.junit.Test;

public class TemperatureUnitTesting {
	
	@Test
	public void testCelsiusToFahrenheit() {
		//Arrange
		double expectedResult = 32.0;
		double ctemp = 0.0; 
		
		//Act
		double actualresult = operationsLibrary.TemperatureConverter.CelsiusToFahrenheit(ctemp);
		
		//Assert
		Assert.assertEquals(expectedResult, actualresult, 0.1);
	}
	
	@Test
	public void testFahrenheitToCelsius() {
		//Arrange
		double expectedResult = 0.0;
		double ftemp = 32.0; 
		
		//Act
		double actualresult = operationsLibrary.TemperatureConverter.FahrenheitToCelsius(ftemp);
		
		//Assert
		Assert.assertEquals(expectedResult, actualresult, 0.1);
	}
}
