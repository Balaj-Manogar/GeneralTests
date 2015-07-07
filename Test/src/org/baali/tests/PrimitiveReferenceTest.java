package org.baali.tests;

import java.util.ArrayList;
import java.util.ListIterator;

public class PrimitiveReferenceTest
{
	static void changeNumber(int i)
	{
		i = 100;
		System.out.println(i);
	}

	public static void main(String[] args)
	{
		int i = 10;
		System.out.println("i: " + i);
		changeNumber(i);
		System.out.println("i: " + i);
		ArrayList<String> al = new ArrayList<String>();
		al.add(null);
		ListIterator<String> li = al.listIterator();
		System.out.println(li.next());
	}

}
