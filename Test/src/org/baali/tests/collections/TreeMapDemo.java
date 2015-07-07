package org.baali.tests.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo
{

	
	
	public static void main(String[] args)
	{
		
		Comparator<? super String> StringLengthComparator = new StringLengthComparator();
		TreeMap<String, String> tm = new TreeMap<String, String>(StringLengthComparator);
		tm.put("one", "567");
		tm.put("a", "ABC");
		tm.put("twoe", "Three");
		tm.put("ballType", "footBall");
		tm.put("xy", "XYZ");
		
		Set tmEntrySet = tm.entrySet();
		Iterator itr = tmEntrySet.iterator();
		
		for(Map.Entry m : tm.entrySet())
		{
			System.out.println("Key: " + m.getKey() + "\t\t Val: " + m.getValue());
		}

	}

}

class StringLengthComparator implements Comparator<String>
{

	public int compare(String o1, String o2)
	{
		return o1.length() - o2.length();
	}
	
}