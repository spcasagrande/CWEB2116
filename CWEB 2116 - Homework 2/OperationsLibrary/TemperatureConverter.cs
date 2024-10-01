using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OperationsLibrary
{
    public class TemperatureConverter
    {
		public static double CelsiusToFahrenheit(double celsius)
		{
			double fahrenheit = ((celsius * 1.8) + 32);
			double result = Math.Round(fahrenheit, 2);
			return result;
		}
		public static double FahrenheitToCelsius(double fahrenheit)
		{
			double celsius = (0.55555556 * (fahrenheit - 32));
			double result = Math.Round(celsius, 2);
			return result;
		}
	}
}
