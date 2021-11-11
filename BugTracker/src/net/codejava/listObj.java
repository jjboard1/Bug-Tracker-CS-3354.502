package net.codejava;
import java.util.ArrayList;

//This is a project object that holds entries and goes into profiles.
public class listObj
{
	String name;	//Name of the project
	ArrayList<entryObj> list = new ArrayList<entryObj>(); //List of entries in the project
	
	//Default constructor
	listObj()
	{
		name = "New List";
	}
	
	//Constructor with name input
	listObj(String a)
	{
		name = a;
	}
	
	//Adds an entry to the project
	public void addList(entryObj a)
	{
		list.add(a);
	}
	
	//Removes an entry from the project
	public void subList(int b)
	{
		list.removeIf(x -> x.itemID == b);
	}
	
	//Prints out all the entries in the project
	public void print()
	{
		System.out.println(list.toString());
	}
}
