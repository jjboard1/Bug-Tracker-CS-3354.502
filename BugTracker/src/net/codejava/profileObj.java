package net.codejava;
import java.util.ArrayList;
import java.util.Objects;

public class profileObj
{

	String name;
	ArrayList<listObj> list = new ArrayList<listObj>();
	
	public profileObj()
	{
		name = "New Profile";
	}
	
	public profileObj(String a)
	{
		name = a;
	}
	
	public void addList(listObj a)
	{
		list.add(a);
	}
	
	public void subList(listObj b)
	{
		list.removeIf(x -> Objects.equals(x.name, b.name));
	}
	
	public void print()
	{
		System.out.println(list.toString());
	}
}
