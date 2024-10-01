using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OperationsApp
{
	class TemperatureApp
	{
		static void Main(string[] args)
		{
			Console.WriteLine("Temperature Conversion");
			Console.WriteLine("----------------------");
			PerformTemperatureConversion conversion1 = new PerformTemperatureConversion();
			conversion1.performTemperatureConversion();
		}
	}
}
