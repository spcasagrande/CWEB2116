using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace OperationsUnitTesting
{
	[TestClass]
	public class operationsTest
	{
		[TestMethod]
		public void testCelsiusToFahrenheit()
		{
			// Arrange
			double input = 0.0;
			double expected = 32.0;

			// Act
			double actual = OperationsLibrary.TemperatureConverter.CelsiusToFahrenheit(input);

			// Assert
			Assert.AreEqual(expected, actual);
		}

		[TestMethod]
		public void testFahrenheitToCelsius()
		{
			// Arrange
			double input = 32.0;
			double expected = 0.0;

			// Act
			double actual = OperationsLibrary.TemperatureConverter.FahrenheitToCelsius(input);

			// Assert
			Assert.AreEqual(expected, actual);
		}
	}
}
