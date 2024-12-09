package finalProject;
import java.sql.*;
import java.util.Scanner;

public class FileHandler {
	
	Scanner scanner = new Scanner(System.in);
	
	private static String url = "jdbc:mysql://localhost:3306/CWEB2116Final";
	private static String user = "new_username1";
	private static String password = "new_password1";
	
	public void EnsureTableExists()
	{
		try(Connection db = DriverManager.getConnection(url, user, password);
				Statement stmt = db.createStatement())
		{
			stmt.execute("CREATE DATABASE IF NOT EXISTS CWEB2225Final");
			stmt.execute("USE CWEB2225Final");
			stmt.execute("""
					create table if not exists creatures (
						creatureID int auto_increment primary key,
						creatureType varchar(100),
						creatureName varchar(100),
						creatureAge int,
						creatureAbility varchar(255)
						);
					""");
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public String getType()
	{
		boolean keepRunning = true;
		
		while (keepRunning) {
			System.out.println("Enter type (Dragon/Phoenix/Unicorn): ");
			String type = scanner.next();
			type = type.toLowerCase();
			
			switch(type)
			{
			case "dragon":
				type = "Dragon";
				return type;
			case "phoenix":
				type = "Phoenix";
				return type;
			case "unicorn":
				type = "Unicorn";
				return type;
			default:
				System.out.println("Invalid type");
			}
		}
		
		return "";
	}
	
	public String getName()
	{
		String name;
		do
		{
			System.out.println("Enter name: ");
			name = scanner.next();
			if (name.isEmpty())
			{
				System.out.println("Name cannot be empty");

			}
		}
		while (name.isEmpty());
		
		return name;
	}
	
	public int getAge()
	{
		int age;
		while (true)
		{
			try
			{
				System.out.println("Enter age: ");
				age = Integer.parseInt(scanner.next());
						
				if (age > 0)
				{
					return age;
				}
				else
				{
					System.out.println("Please enter a valid age");
				}			
			}	
			catch(NumberFormatException e)
			{
				System.out.println("Please enter a valid age");
			}
		}
	}
	
	public String getAbility(String type)
	{
		String ability;
		
		if (type == "Dragon")
		{
			do
			{
				System.out.println("Enter firepower: ");
				ability = scanner.next();
				if (ability.isEmpty())
				{
					System.out.println("Firepower cannot be empty");

				}
			}
			while (ability.isEmpty());
		}
		else if (type == "Phoenix")
		{
			do
			{
				System.out.println("Enter flight speed: ");
				ability = scanner.next();
				if (ability.isEmpty())
				{
					System.out.println("Flight speed cannot be empty");

				}
			}
			while (ability.isEmpty());
		}
		else
		{
			do
			{
				System.out.println("Enter horn color: ");
				ability = scanner.next();
				if (ability.isEmpty())
				{
					System.out.println("Horn color cannot be empty");

				}
			}
			while (ability.isEmpty());
		}
		
		return ability;
	}
	
	public void addCreature()
	{
		String type = getType();
		String name = getName();
		int age = getAge();
		String ability = getAbility(type);
		
		try(Connection conn = DriverManager.getConnection(url, user, password))
		{
			String query = "INSERT INTO creatures (creatureType, creatureName, creatureAge, creatureAbility) VALUES (?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, type);
			stmt.setString(2, name);
			stmt.setInt(3, age);
			stmt.setString(4, ability);
			stmt.executeUpdate();
			
			System.out.println("Creature added successfully\n");
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void removeCreature()
	{
		String userid;
		int id;
		
		while (true)
		{
			System.out.println("\nEnter ID of creature to be removed: ");
			userid = scanner.nextLine();
			
			if (!userid.isEmpty())
			{
				try
				{
					id = Integer.parseInt(userid);
					break;
				}
				catch (NumberFormatException e)
				{
					System.out.println("ID must be a number");
				}
			}
			else
			{
				System.out.println("ID cannot be empty");
			}
		}
		
		try(Connection conn = DriverManager.getConnection(url, user, password))
		{
			String query = "DELETE FROM creatures WHERE creatureID = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			
			int result = stmt.executeUpdate();
			
			if (result > 0)
			{
				System.out.println("Creature removed successfully\n");
			}
			else
			{
				System.out.println("Creature not removed successfully\n");
			}
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		
	}

	public void displayCreatures()
	{
		Dragon dragonObj = getDragonObject();
		Phoenix phoenixObj = getPhoenixObject();
		Unicorn unicornObj = getUnicornObject();
		
		try(Connection conn = DriverManager.getConnection(url, user, password))
		{
			String query = "SELECT * FROM creatures";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println();
			
			while (rs.next())
			{
				String type = rs.getString("creatureType");
				if (type.equalsIgnoreCase("Dragon"))
				{
					System.out.print("ID: " + rs.getInt("creatureID") + ", ");
					dragonObj.displayName(rs.getString("creatureName"));
					dragonObj.displayType(rs.getString("creatureType"));
					dragonObj.displayAge(rs.getInt("creatureAge"));
					dragonObj.displayAbility(rs.getString("creatureAbility"));
					System.out.print("\n");
				}
				else if (type.equalsIgnoreCase("Phoenix"))
				{
					System.out.print("ID: " + rs.getInt("creatureID") + ", ");
					phoenixObj.displayName(rs.getString("creatureName"));
					phoenixObj.displayType(rs.getString("creatureType"));
					phoenixObj.displayAge(rs.getInt("creatureAge"));
					phoenixObj.displayAbility(rs.getString("creatureAbility"));
					System.out.print("\n");
				}
				else if (type.equalsIgnoreCase("Unicorn"))
				{
					System.out.print("ID: " + rs.getInt("creatureID") + ", ");
					unicornObj.displayName(rs.getString("creatureName"));
					unicornObj.displayType(rs.getString("creatureType"));
					unicornObj.displayAge(rs.getInt("creatureAge"));
					unicornObj.displayAbility(rs.getString("creatureAbility"));
					System.out.print("\n");
				}
				System.out.println();
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void filterCreatures()
	{
		Dragon dragonObj = getDragonObject();
		Phoenix phoenixObj = getPhoenixObject();
		Unicorn unicornObj = getUnicornObject();
		
		System.out.println("\nEnter type to filter by (Dragon/Phoenix/Unicorn): ");
		String userType = scanner.nextLine();
		
		try(Connection conn = DriverManager.getConnection(url, user, password))
		{
			System.out.println();
			
			if (userType.equalsIgnoreCase("dragon"))
			{
				String query = "SELECT * FROM creatures WHERE creatureType = 'Dragon'";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				if (!rs.next())
				{
					System.out.println("No records for the type " + userType + "\n");
					return;
				}
				
				System.out.print("ID: " + rs.getInt("creatureID") + ", ");
				dragonObj.displayName(rs.getString("creatureName"));
				dragonObj.displayType(rs.getString("creatureType"));
				dragonObj.displayAge(rs.getInt("creatureAge"));
				dragonObj.displayAbility(rs.getString("creatureAbility"));
				System.out.println("\n");
				
				while (rs.next())
				{
					System.out.print("ID: " + rs.getInt("creatureID") + ", ");
					dragonObj.displayName(rs.getString("creatureName"));
					dragonObj.displayType(rs.getString("creatureType"));
					dragonObj.displayAge(rs.getInt("creatureAge"));
					dragonObj.displayAbility(rs.getString("creatureAbility"));
					System.out.println("\n");
				}
			}
			
			else if (userType.equalsIgnoreCase("phoenix"))
			{
				String query = "SELECT * FROM creatures WHERE creatureType = 'Phoenix'";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				if (!rs.next())
				{
					System.out.println("No records for the type " + userType + "\n");
					return;
				}
				
				System.out.print("ID: " + rs.getInt("creatureID") + ", ");
				phoenixObj.displayName(rs.getString("creatureName"));
				phoenixObj.displayType(rs.getString("creatureType"));
				phoenixObj.displayAge(rs.getInt("creatureAge"));
				phoenixObj.displayAbility(rs.getString("creatureAbility"));
				System.out.println("\n");
				
				while (rs.next())
				{
					System.out.print("ID: " + rs.getInt("creatureID") + ", ");
					phoenixObj.displayName(rs.getString("creatureName"));
					phoenixObj.displayType(rs.getString("creatureType"));
					phoenixObj.displayAge(rs.getInt("creatureAge"));
					phoenixObj.displayAbility(rs.getString("creatureAbility"));
					System.out.println("\n");
				}
			}
			
			else if (userType.equalsIgnoreCase("unicorn"))
			{
				String query = "SELECT * FROM creatures WHERE creatureType = 'Unicorn'";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				if (!rs.next())
				{
					System.out.println("No records for the type " + userType + "\n");
					return;
				}
				
				System.out.print("ID: " + rs.getInt("creatureID") + ", ");
				unicornObj.displayName(rs.getString("creatureName"));
				unicornObj.displayType(rs.getString("creatureType"));
				unicornObj.displayAge(rs.getInt("creatureAge"));
				unicornObj.displayAbility(rs.getString("creatureAbility"));
				System.out.println("\n");
				
				while (rs.next())
				{
					System.out.print("ID: " + rs.getInt("creatureID") + ", ");
					unicornObj.displayName(rs.getString("creatureName"));
					unicornObj.displayType(rs.getString("creatureType"));
					unicornObj.displayAge(rs.getInt("creatureAge"));
					unicornObj.displayAbility(rs.getString("creatureAbility"));
					System.out.println("\n");
				}
			}
			
			else
			{
				System.out.println("Invalid type");
			}
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void showStatistics()
	{
		try(Connection conn = DriverManager.getConnection(url, user, password))
		{
			double age = 0;
			int dragonCount = 0;
			int phoenixCount = 0;
			int unicornCount = 0;
			System.out.println();
			
			try
			{
				String selectQuery = "SELECT * FROM creatures";
				Statement selectStmt = conn.createStatement();
				ResultSet selectRS = selectStmt.executeQuery(selectQuery);
				
				if (!selectRS.next())
				{
					System.out.println("No records found\n");
					return;
				}
				else
				{
					String ageQuery = "SELECT creatureAge FROM creatures";
					Statement ageStmt = conn.createStatement();
					ResultSet ageRS = ageStmt.executeQuery(ageQuery);
					int totalAge = 0;
					int count = 0;
					
					while (ageRS.next())
					{
						int thisAge = ageRS.getInt("creatureAge");
						totalAge = totalAge + thisAge;
						count += 1;
					}
					
					age = totalAge/count;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			try
			{
				String selectQuery = "SELECT * FROM creatures WHERE creatureType = 'Dragon'";
				Statement selectStmt = conn.createStatement();
				ResultSet selectRS = selectStmt.executeQuery(selectQuery);
				
				if (!selectRS.next())
				{
					dragonCount = 0;
				}
				else
				{
					int count = 1;
					
					while(selectRS.next())
					{
						count += 1;
					}
					
					dragonCount = count;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			try
			{
				String selectQuery = "SELECT * FROM creatures WHERE creatureType = 'Phoenix'";
				Statement selectStmt = conn.createStatement();
				ResultSet selectRS = selectStmt.executeQuery(selectQuery);
				
				if (!selectRS.next())
				{
					phoenixCount = 0;
				}
				else
				{
					int count = 1;
					
					while(selectRS.next())
					{
						count += 1;
					}
					
					phoenixCount = count;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			try
			{
				String selectQuery = "SELECT * FROM creatures WHERE creatureType = 'Phoenix'";
				Statement selectStmt = conn.createStatement();
				ResultSet selectRS = selectStmt.executeQuery(selectQuery);
				
				if (!selectRS.next())
				{
					unicornCount = 0;
				}
				else
				{
					int count = 1;
					
					while(selectRS.next())
					{
						count += 1;
					}
					
					unicornCount = count;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("Average Age: " + age);
			System.out.println("Type Distribution: ");
			System.out.println("Dragon Count: " + dragonCount);
			System.out.println("Phoenix Count: " + phoenixCount);
			System.out.println("Unicorn Count: " + unicornCount + "\n");
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public Dragon getDragonObject() {
		Dragon dragonObj = new Dragon();
		return dragonObj;	
	}
	
	public Phoenix getPhoenixObject() {
		Phoenix phoenixObj = new Phoenix();
		return phoenixObj;	
	}
	
	public Unicorn getUnicornObject() {
		Unicorn unicornObj = new Unicorn();
		return unicornObj;	
	}
}
