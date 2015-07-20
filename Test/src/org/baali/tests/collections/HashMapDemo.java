package org.baali.tests.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo
{
	public static void main(String[] args)
	{
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("key1", "Value 1");
		hm.put("key2", "Value 2");
		hm.put("keyKJ3", "Value 3");
		hm.put("key4", "Value 4");

		Set<String> hmKeys = hm.keySet();

		Iterator<String> keyIterator = hmKeys.iterator();
		System.out.println("Printing Keys:");
		System.out.println("-----------------");
		while(keyIterator.hasNext())
		{
			System.out.println(keyIterator.next());
		}
		
		System.out.println("Printing Keys and Values:");
		System.out.println("-----------------");
		for(Map.Entry<String, String> me : hm.entrySet())
		{
			System.out.println("Key: " + me.getKey() + " Val: " + me.getValue());
		}
	}
}
