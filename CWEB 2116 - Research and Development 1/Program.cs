using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CWEB_2116___Research_and_Development_1
{
	class User
	{
		private String name;
		private int age;
		private String hobby;

		public User(String Name, int Age)
		{
			name = Name;
			age = Age;
		}
		public string DisplayInfo(String name, int age)
		{
			return ("Your name is " + name + ". Your age is " + age + ".");
		}
		public string DisplayInfo(String name, int age, String hobby)
		{
			return ("Your name is " + name + ". Your age is " + age + ". Your hobby is " + hobby + ".");
		}
		public string DisplayInfo(String name, int age, String hobby, int retirement)
		{
			int yearsleft = retirement - age;
			return ("Your name is " + name + ". Your age is " + age + ". Your hobby is " + hobby + ". You will retire in " + yearsleft + " years.");
		}
		static void Main(string[] args)
		{
			Console.WriteLine("Enter your name: ");
			String name = Console.ReadLine();
			Console.WriteLine("Enter your age: ");
			int age = Convert.ToInt32(Console.ReadLine());
			User user = new User(name, age);
			Console.WriteLine(user.DisplayInfo(name, age));

			Console.WriteLine("Enter your hobby: ");
			String hobby = Console.ReadLine();
			Console.WriteLine(user.DisplayInfo(name, age, hobby));

			//I decided to ask for desired retirement age because it seemed like a better way to go about it than simply assuming that retirement = 65
			Console.WriteLine("Enter your desired retirement age: ");
			int retirement = Convert.ToInt32(Console.ReadLine());
			Console.WriteLine(user.DisplayInfo(name, age, hobby, retirement));
			Console.ReadKey();

		}
	}
}