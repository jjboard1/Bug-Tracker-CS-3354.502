package net.codejava;
import java.util.ArrayList;
import java.util.Objects;

//This is a profile object that holds projects.
public class profileObj
{

	String name; //Name of profile.
	ArrayList<listObj> list = new ArrayList<listObj>(); //List of projects in profile.
	
	//Default constructor
	public profileObj()
	{
		name = "New Profile";
	}
	
	//Constructor with name input
	public profileObj(String a)
	{
		name = a;
	}
	
	//Adds project to the profile
	public void addList(listObj a)
	{
		list.add(a);
	}
	
	//Removes a project from the profile
	public void subList(listObj b)
	{
		list.removeIf(x -> Objects.equals(x.name, b.name));
	}
	
	//Prints the projects in the profile
	public void print()
	{
		System.out.println(list.toString());
	}
}
