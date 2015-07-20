package org.baali.tests.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapDemo
{

	public static void main(String[] args)
	{
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
		lhm.put("one", "Balaji");
		lhm.put("two", "Rajan");
		lhm.put("Five", "Monika");
		
		Set lhmEntrySet = lhm.entrySet();
		
		Iterator itr = lhmEntrySet.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		
	}

}
