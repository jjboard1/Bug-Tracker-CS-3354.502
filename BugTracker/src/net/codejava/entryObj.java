package net.codejava;

//This is an entry object to be put into a project.
public class entryObj
{
	int itemID; 		//Entry ID
	String desc; 		//Entry Description
	String dueDate;		//Due Date
	String estTime;		//Estimated time for completion
	String tag;			//Entry tag
	
	//Constructor that sets the ID, description, due date, estimated time for completion, and tag.
	public entryObj(int id, String des, String due, String time, String name)
	{
		itemID = id;
		desc = des;
		dueDate = due;
		estTime = time;
		tag = name;
	}
	
	//Prints out the content of the entry.
	public void print()
	{
		System.out.println(itemID);
		System.out.println(desc);
		System.out.println(dueDate);
		System.out.println(estTime);
		System.out.println(tag);
	}
}
