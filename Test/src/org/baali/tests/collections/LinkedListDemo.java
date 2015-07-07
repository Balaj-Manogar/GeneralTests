package org.baali.tests.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo
{
	public static void main(String[] args)
	{
		 List<String> linkedList = new LinkedList<String>();
		 linkedList.add("Balaji");
		 linkedList.add("Rajan");
		 linkedList.add("Baskar");
		 linkedList.add("Sankar");
		 linkedList.add(null);
		 
		 List<String> linkedList2 = new LinkedList<String>();
		 linkedList2.add("Balaji");
		 linkedList2.add("Rajan");
		 
		 System.out.println(linkedList);
		 linkedList.removeAll(linkedList2);
		 System.out.println(linkedList);
		 
		 ListIterator<String> li = linkedList.listIterator();
		 
		 while (li.hasNext())
		{
			System.out.println(li.next());
			
		}
	}
}
