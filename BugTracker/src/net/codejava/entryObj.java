package net.codejava;

public class entryObj
{
	int itemID;
	String desc;
	String dueDate;
	String estTime;
	String tag;
	
	public entryObj(int id, String des, String due, String time, String name)
	{
		itemID = id;
		desc = des;
		dueDate = due;
		estTime = time;
		tag = name;
	}
	
	public void print()
	{
		System.out.println(itemID);
		System.out.println(desc);
		System.out.println(dueDate);
		System.out.println(estTime);
		System.out.println(tag);
	}
}
