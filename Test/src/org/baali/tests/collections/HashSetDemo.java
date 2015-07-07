package org.baali.tests.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo
{

	public static void main(String[] args)
	{
		Set<String> hs = new HashSet<String>();
		hs.add("Balaji");
		hs.add("Rajan");
		hs.add("XYZ");
		hs.add(null);
		System.out.println(hs.contains("Balaji"));
		
		Iterator<String> itr = hs.iterator();
		while(itr.hasNext())
		{
			
			System.out.println(itr.next());
		}

	}

}
