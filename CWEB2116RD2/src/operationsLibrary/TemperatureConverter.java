package operationsLibrary;

public class TemperatureConverter {
	
	public static double CelsiusToFahrenheit(double celsius)
	{
		double fahrenheit = ((celsius * 1.8) + 32);
		double result = Math.round(fahrenheit * 100d) / 100d;
		return result;
	}
	public static double FahrenheitToCelsius(double fahrenheit)
	{
		double celsius = (0.55555556 * (fahrenheit - 32));
		double result = Math.round(celsius * 100d) / 100d;
		return result;
	}
}
