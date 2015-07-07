package org.baali.tests.collections;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo
{

	public static void main(String[] args)
	{
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		
		lhs.add("Balaji");
		lhs.add("String");
		lhs.add("Steve");
		lhs.add(null);
		
		Iterator itr = lhs.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

	}

}
