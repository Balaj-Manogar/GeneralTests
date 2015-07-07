package org.baali.tests.collections;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo
{
	public static void main(String[] args)
	{
		TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("One".toLowerCase());
		ts.add("ABC");
		ts.add("add");
		ts.add("Yes");
		ts.add("no");
		
		Iterator<String> itr = ts.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}
