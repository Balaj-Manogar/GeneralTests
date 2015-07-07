package org.baali.tests;

public class BaseDemo
{
	public static void main(String[] args)
	{
		IBase base = new BaseImpl();
		base.print();
	}
}
