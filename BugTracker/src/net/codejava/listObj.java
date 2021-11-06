package net.codejava;
import java.util.ArrayList;
//import java.util.Objects;

public class listObj
{
	String name;
	ArrayList<entryObj> list = new ArrayList<entryObj>();
	
	listObj()
	{
		name = "New List";
	}
	
	listObj(String a)
	{
		name = a;
	}
	
	public void addList(entryObj a)
	{
		list.add(a);
	}
	
	public void subList(int b)
	{
		list.removeIf(x -> x.itemID == b);
	}
	
	public void print()
	{
		System.out.println(list.toString());
	}
}
