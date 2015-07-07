package org.baali.demos.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;


public class PrimitiveTests
{
	@Test(expected= NullPointerException.class)
	public void expectNullPointerExceptionToBeThrown()
	{
		final String s = null;
		final int sLength = s.length();
	}
	
	@Test
	public void arrayListSizeTest()
	{
		final List<String> list = new ArrayList<String>(10);
		assertEquals(0, list.size());
		list.add("added String");
		assertEquals(1, list.size());
		list.clear();
		assertEquals(0, list.size());
	}
	
	@Test
	public void testDuplicateCollection()
	{
		Set<String> set = new HashSet<String>();
		set.add("xyz");
		assertTrue("Added duplicate it should fail", set.add("xyz"));		
	}
	
	@Test
	public void intEquality()
	{
		int i = 10;
		int j = 10;
		
		assertTrue(i == j);
	}
	
	@Test
	public void integerValueOfEquality()
	{
		Integer int1 = Integer.valueOf(100);
		Integer int2 = Integer.valueOf(100);
		
		assertTrue(int1 == int2);
	}
	
	@Test
	public void intgerInstanceEquality()
	{
		Integer int1 = new Integer(100);
		Integer int2 = new Integer(100);
		
		assertTrue(int1 == int2);
	}
}
