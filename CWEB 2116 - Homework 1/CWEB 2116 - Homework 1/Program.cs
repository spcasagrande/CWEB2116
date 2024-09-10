using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWEB_2116___Homework_1
{
	class Program
	{
		static void Main(string[] args)
		{
			Console.WriteLine("My name is Sam Casagrande");
			Console.WriteLine("My favorite color is purple");
			Console.WriteLine("The current year is 2024");
			Console.ReadKey();

			// This is a single line comment
			/* This is a
			   multi line comment */

			int age = 27;
			decimal height = 1.70M;
			char letter = 'S';
			bool programing = true;

			Console.WriteLine("\nI am " + age + " years old");
			Console.WriteLine("My height is " + height + " meters");
			Console.WriteLine("My favorite letter is " + letter);
			Console.WriteLine("Do I like programing? " + programing);
			Console.ReadKey();

			decimal pi = 3.14159M;
			/* I decided to allow the circle area calculator to function with any given radius
			 * because I wanted to try it out */
			Console.WriteLine("\n----------------------");
			Console.WriteLine("Circle Area Calculator");
			Console.WriteLine("----------------------");
			Console.WriteLine("What would you like the radius of the circle to be?: ");
			int radius = Convert.ToInt32(Console.ReadLine());
			decimal area = pi * (radius * radius);
			Console.WriteLine("The area of a circle with a radius of " + radius + " is " + area);
			Console.ReadKey();

			string name = "Sophie";
			long pop = 1900000;
			double temp = 16.5;
			bool student = true;

			Console.WriteLine("\nThe person's name is " + name);
			Console.WriteLine("The population of the city is " + pop);
			Console.WriteLine("The temperature is " + temp + " degrees Celsius");
			Console.WriteLine("Is the person a student? " + student);
			Console.ReadKey();
		}
	}
}
