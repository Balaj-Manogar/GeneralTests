package org.baali.tests.collections;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo
{

	public static void main(String[] args)
	{
		Queue<String> pq = new PriorityQueue<String>();
		pq.add("one");
		pq.add("two");
		pq.add("three");
		pq.add("four");
		
		System.out.println(pq.element());
		Iterator itr = pq.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		

	}

}
