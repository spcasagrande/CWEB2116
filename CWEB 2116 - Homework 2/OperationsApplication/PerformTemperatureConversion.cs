using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OperationsApp
{
	class PerformTemperatureConversion
	{
		public void performTemperatureConversion()
		{
			bool tryagain = true;

			while (tryagain)
			{
				Console.WriteLine("Do you wish to convert: ");
				Console.WriteLine("1. Celsius to Fahrenheit");
				Console.WriteLine("2. Fahrenheit to Celsius");
				Console.WriteLine("3. Exit");
				string answer = Console.ReadLine();

				switch (answer)
				{
					case "1":
						Console.WriteLine("\nEnter Celsius temperature to convert: ");
						double celsius = double.Parse(Console.ReadLine());
						double fahrenheitRes = OperationsLibrary.TemperatureConverter.CelsiusToFahrenheit(celsius);
						Console.WriteLine("Temperature in Celsius = " + celsius);
						Console.WriteLine("Temperature in Fahrenheit = " + fahrenheitRes + "\n");
						break;
					case "2":
						Console.WriteLine("\nEnter Fahrenheit temperature to convert: ");
						double fahrenheit = double.Parse(Console.ReadLine());
						double celsiusRes = OperationsLibrary.TemperatureConverter.FahrenheitToCelsius(fahrenheit);
						Console.WriteLine("Temperature in Fahrenheit = " + fahrenheit);
						Console.WriteLine("Temperature in Celsius = " + celsiusRes + "\n");
						break;
					case "3":
						tryagain = false;
						break;
					default:
						Console.WriteLine("Invalid choice. Try again\n");
						break;
				}
			}
        }
	}
}
