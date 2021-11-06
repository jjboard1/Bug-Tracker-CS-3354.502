package net.codejava;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

public class MainHandler
{
	private static final Scanner keyboard = new Scanner(System.in);
	static ArrayList<profileObj> list = new ArrayList<profileObj>();
	static profileObj currentProfile;
	
	public static void newProfile()
	{
		System.out.println("Enter name for new profile: ");
		String input = textInput();
		profileObj a = new profileObj(input);
		list.add(a);
		profileMenu();
	}
	
	public static void newList()
	{
		System.out.println("Enter name for new project: ");
		String input = textInput();
		listObj a = new listObj(input);
		currentProfile.addList(a);
		viewProject();
	}
	
	public static void setProfile()
	{
		System.out.println("Enter name of profile to set:");
		String input = textInput();
		
		for(int i = 0; i < list.size(); i++)
		{
			if(Objects.equals(input, list.get(i).name))
			currentProfile = list.get(i);
		}
		
		profileMenu();
	}
	
	public static void profileMenu()
	{
		if(!list.isEmpty())
		{
			System.out.println("PROFILES [Current Profile in Braces]");
			
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

	public static void newEntry(listObj k)
	{
		System.out.println("Enter item ID:");
		int id = inputHandler();
		
		System.out.println("Enter item description:");
		String desu = textInput();
		
		System.out.println("Enter item due date:");
		String due = textInput();
		
		System.out.println("Enter estimate of time to completion:");
		String est = textInput();
		
		System.out.println("Enter item tag:");
		String tag = textInput();
		
		entryObj w = new entryObj(id, desu, due, est, tag);
		
		k.addList(w);
		
		listMenu(k.name);
	}
	
	public static void listMenu(String z)
	{	
		int index = 0;
		
		for(int i = 0; i < currentProfile.list.size(); i++)
		{
			if(Objects.equals(currentProfile.list.get(i).name, z))
			{
				index = i;
			}
		}
		
		if(!currentProfile.list.get(index).list.isEmpty())
		{
			System.out.println("Project Items: Descriptions");
			
			for(int i = 0; i < currentProfile.list.get(index).list.size(); i++)
			{
				System.out.println(" - " + currentProfile.list.get(index).list.get(i).desc);
			}
			
			System.out.println("1. Create new entry");
			System.out.println("2. Back");
			System.out.println("Enter number to select: ");
			
			int given = inputHandler();
			
			switch(given)
			{
				case 1: newEntry(currentProfile.list.get(index));
						break;
				case 2: viewProject();
						break;
				default: System.out.println("ERROR: Not a valid input");
						profileMenu();
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
			
			switch(given)
			{
				case 1: newEntry(currentProfile.list.get(index));
						break;
				case 2: viewProject();
						break;
				default: System.out.println("ERROR: Not a valid input");
						profileMenu();
						break;
			}
		}
		
	}
	
	public static void viewProject()
	{
		if(!currentProfile.list.isEmpty())
		{
			System.out.println(currentProfile.name + " - PROJECTS");
			
			for(int i = 0; i < currentProfile.list.size(); i++)
			{
				System.out.println(" - " + currentProfile.list.get(i).name);
			}
			
			System.out.println("1. Create New Project");
			System.out.println("2. Open Project");
			System.out.println("3. Back");
			System.out.println("Enter number to select: ");
			
			int input = inputHandler();
			
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
						profileMenu();
						break;
			}
		}
		else
		{
			System.out.println(currentProfile.name + " - PROJECTS");
			System.out.println("This profile has no projects");
			System.out.println("1. Create New Project");
			System.out.println("2. Back");
			System.out.println("Enter number to select: ");
			
			int input = inputHandler();
			
			switch(input)
			{
				case 1: newList();
						break;
				case 2: mainMenu();
						break;
				default: System.out.println("ERROR: Not a valid input");
						profileMenu();
						break;
			}
		}
	}
	
	public static int inputHandler()
	{	
		String input = keyboard.nextLine();
		
		int num = Integer.parseInt(input);
		
		System.out.println("");
		
		return num;
	}
	
	public static String textInput()
	{
		String input = keyboard.nextLine();
		
		System.out.println("");

		return input;
	}
	
	public static void mainMenu()
	{
		System.out.println("BUG TRACKER\n");
		
		System.out.println("1. Profiles");
		System.out.println("2. New Projects");
		System.out.println("3. Current Projects");
		System.out.println("Enter number to select: ");
		
		int input = inputHandler();
		
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

	public static void main(String[] args)
	{
		profileObj x = new profileObj("default");
		
		currentProfile = x;
		list.add(x);
		
		mainMenu();
		
	}

}
