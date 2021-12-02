package net.codejava;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;


//This class handles most of the events
public class MainHandler
{
	private static final Scanner keyboard = new Scanner(System.in); 	//This is used for user input.
	static ArrayList<profileObj> list = new ArrayList<profileObj>();	//This is the list of profiles.
	static profileObj currentProfile;									//This is the current profile.
	
	//This method lets the user create a new profile.
	//The profile is added to the list of profiles.
	public static void newProfile()
	{
		boolean check = false;
		
		System.out.println("Enter name for new profile: ");
		String input = textInput();
		
		//This for loop checks if the entered name is already in use.
		for(int i = 0; i < list.size(); i++)
		{
			if(input.equals(list.get(i).name))
			{
				check = true;
			}
		}
		
		//If the name is in use, an error message is displayed. Otherwise, the profile is added
		if(check)
		{
			System.out.println("ERROR: This profile name is already in use");
			profileMenu();
		}
		else
		{
			profileObj a = new profileObj(input);
			list.add(a);
			profileMenu();
		}
	}
	
	//This method lets the user create a new project.
	//The project is added to the current profile.
	public static void newList()
	{
		boolean check = false;
		
		System.out.println("Enter name for new project: ");
		String input = textInput();
		
		//This for loop checks if the entered name is already in use.
		for(int i = 0; i < currentProfile.list.size(); i++)
		{
			if(input.equals(currentProfile.list.get(i).name))
			{
				check = true;
			}
		}
		
		//If the name is in use, an error message is displayed. Otherwise, the project is added
		if(check)
		{
			System.out.println("ERROR: This project name is already in use");
			viewProject();
		}
		else
		{
			listObj a = new listObj(input);
			currentProfile.addList(a);
			viewProject();
		}
	}
	
	//This method lets the user set the current profile.
	//It iterates through the list of profiles to find the match for the input and set the current profile to that.
	public static void setProfile()
	{
		System.out.println("Enter name of profile to set:");
		String input = textInput();
		boolean check = false;
		String name = currentProfile.name;
		
		for(int i = 0; i < list.size(); i++)
		{
			if(Objects.equals(input, list.get(i).name))
			{
				currentProfile = list.get(i);
				check = true;
			}
		}
		
		if(input.equals(name))
		{
			System.out.println("Input matches current profile, profile not changed");
		}
		
		//If the entered name does not exist, an error message is displayed.
		if(!check)
		{
			System.out.println("ERROR: No such profile exists, profile not changed");
		}
		
		profileMenu();
	}
	
	//This method displays the menu where users can interact with profiles.
	public static void profileMenu()
	{
		//This if/else structure lets the menu display different things
		//depending on if there are any profiles to display.
		if(!list.isEmpty())
		{
			System.out.println("PROFILES [Current Profile in Braces]");
			
			//This for loop prints out all the profiles
			//The current profile is surrounded with brackets [ ]
			for(int i = 0; i < list.size(); i++)
			{
				if(Objects.equals(currentProfile.name, list.get(i).name))
					System.out.println(" - [" + list.get(i).name + "]");
				else
					System.out.println(" - " + list.get(i).name);
			}
			
			System.out.println("1. Create New Profile");
			System.out.println("2. Set current profile");
			System.out.println("3. Back");
			
			int input = inputHandler();
			
			//This switch case reads what the user inputed and calls the appropriate method or error message.
			switch(input)
			{
				case 1: newProfile();
					break;
				case 2: setProfile();
						break;
				case 3: mainMenu();
						break;
				default: System.out.println("ERROR: Not a valid input");
						profileMenu();
						break;
			}
		}
		else
		{
			System.out.println("PROFILES");
			System.out.println("No profiles");
			System.out.println("1. Create New Profile");
			System.out.println("2. Set current profile");
			System.out.println("3. Back");
			
			int input = inputHandler();
			
			//This switch case reads what the user inputed and calls the appropriate method or error message.
			switch(input)
			{
				case 1: newProfile();
						break;
				case 2: setProfile();
						break;
				case 3: mainMenu();
						break;
				default: System.out.println("ERROR: Not a valid input");
						profileMenu();
						break;
			}
		}
	}

	//This entry lets the user input the data for a new entry
	//It creates a new entryObj and adds it to the current project
	public static void newEntry(listObj k)
	{
		int id;
		String desu;
		String due;
		String est;
		String tag;
		
		//do {
		System.out.println("Enter item ID:");
		id = inputHandler();
		//}while()
		
		System.out.println("Enter item description:");
		desu = textInput();
		
		System.out.println("Enter item due date:");
		due = textInput();
		
		System.out.println("Enter estimate of time to completion:");
		est = textInput();
		
		System.out.println("Enter item tag:");
		tag = textInput();
		
		entryObj w = new entryObj(id, desu, due, est, tag);
		
		k.addList(w);
		
		listMenu(k.name);
	}
	
	//This method shows the inside of a project, listing the entries and options.
	public static void listMenu(String z)
	{	
		int index = 0;
		boolean check = false;
		
		//This for loop gets the index of the current project in the list of projects in the current profile.
		for(int i = 0; i < currentProfile.list.size(); i++)
		{
			if(Objects.equals(currentProfile.list.get(i).name, z))
			{
				index = i;
				check = true;
			}
		}
		
		if(!check)
		{
			System.out.println("ERROR: No such project exists");
			viewProject();
		}
		
		//This if/else structure lets the menu display different things
		//depending on if there are any entries to display.
		if(!currentProfile.list.get(index).list.isEmpty())
		{
			System.out.println("Project Items: Descriptions");
			
			//This prints out the descriptions of the entries in the current project.
			for(int i = 0; i < currentProfile.list.get(index).list.size(); i++)
			{
				System.out.println(" - " + currentProfile.list.get(index).list.get(i).desc);
			}
			
			System.out.println("1. Create new entry");
			System.out.println("2. Back");
			System.out.println("Enter number to select: ");
			
			int given = inputHandler();
			
			//This switch case reads what the user inputed and calls the appropriate method or error message.
			switch(given)
			{
				case 1: newEntry(currentProfile.list.get(index));
						break;
				case 2: viewProject();
						break;
				default: System.out.println("ERROR: Not a valid input");
						listMenu(z);
						break;
			}
		}
		else
		{
			System.out.println("No entries for Current Project");
			
			System.out.println("1. Create new entry");
			System.out.println("2. Back");
			System.out.println("Enter number to select: ");
			
			int given = inputHandler();
			
			//This switch case reads what the user inputed and calls the appropriate method or error message.
			switch(given)
			{
				case 1: newEntry(currentProfile.list.get(index));
						break;
				case 2: viewProject();
						break;
				default: System.out.println("ERROR: Not a valid input");
						listMenu(z);
						break;
			}
		}
		
	}
	
	//This method displays the menu where you can see the projects associated with a profile.
	public static void viewProject()
	{
		//This if/else structure lets the menu display different things
		//depending on if there are any projects to access.
		if(!currentProfile.list.isEmpty())
		{
			System.out.println(currentProfile.name + " - PROJECTS");
			
			//This for loop prints out the profiles in a vertical list.
			for(int i = 0; i < currentProfile.list.size(); i++)
			{
				System.out.println(" - " + currentProfile.list.get(i).name);
			}
			
			System.out.println("1. Create New Project");
			System.out.println("2. Open Project");
			System.out.println("3. Back");
			System.out.println("Enter number to select: ");
			
			int input = inputHandler();
			
			//This switch case reads what the user inputed and calls the appropriate method or error message.
			switch(input)
			{
				case 1: newList();
					break;
				case 2: System.out.println("Enter name of project to open");
						String p = textInput();
						listMenu(p);
						break;
				case 3: mainMenu();
						break;
				default: System.out.println("ERROR: Not a valid input");
						viewProject();
						break;
			}
		}
		else
		{
			System.out.println(currentProfile.name + " - PROJECTS"); //This prints the current profile name.
			System.out.println("This profile has no projects");
			System.out.println("1. Create New Project");
			System.out.println("2. Back");
			System.out.println("Enter number to select: ");
			
			int input = inputHandler();
			
			//This switch case reads what the user inputed and calls the appropriate method or error message.
			switch(input)
			{
				case 1: newList();
						break;
				case 2: mainMenu();
						break;
				default: System.out.println("ERROR: Not a valid input");
						viewProject();
						break;
			}
		}
	}
	
	//This reads number inputs from the user and returns an integer, usually used for menu selection.
	public static int inputHandler()
	{	
		String input = keyboard.nextLine();
		
		int num;
		
		if(isNum(input))
		{
			num = Integer.parseInt(input);
		
			System.out.println("");
		
			return num;
		}
		else
		{
			System.out.println("ERROR: You must input an integer");
			num = inputHandler();
		}
		
		return num;
	}
	
	//Checks if a string is numeric
	public static boolean isNum(String str)
	{
		  return str.matches("-?\\d+(\\.\\d+)?");
	}
	
	//This reads text input from the user and returns a string of what the user typed in.
	public static String textInput()
	{
		String input = keyboard.nextLine();
		
		System.out.println("");

		return input;
	}
	
	//This is the menu that displays when the program starts.
	//The user has the option to look at profiles, create a new project, or open a project.
	public static void mainMenu()
	{
		System.out.println("BUG TRACKER\n");
		
		System.out.println("1. Profiles");
		System.out.println("2. New Projects");
		System.out.println("3. Current Projects");
		System.out.println("Enter number to select: ");
		
		int input = inputHandler(); 	//This gets the user input.
		
		//This switch case reads what the user inputed and calls the appropriate method or error message.
		switch(input)
		{
			case 1: profileMenu();
					break;
			case 2: newList();
					break;
			case 3: viewProject();
					break;
			default: System.out.println("ERROR: Not a valid input");
					mainMenu();
					break;
		}
	}

	//This starts the program by calling the mainMenu method.
	public static void main(String[] args)
	{
		profileObj x = new profileObj("default"); // This creates a default profile.
		
		currentProfile = x;
		list.add(x);			//The default profile is added to the list of profiles.
		
		mainMenu();
		
	}

}
