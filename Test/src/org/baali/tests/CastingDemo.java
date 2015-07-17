package org.baali.tests;

public class CastingDemo
{

	public static void main(String[] args)
	{
		int i = Integer.MAX_VALUE;
		short s = Short.MAX_VALUE;
		
		short castedIntError = (short) i;
		short castedIntManual = (short) Math.max((short)i, Short.MAX_VALUE);
		
		System.out.println("Wrong way: " + castedIntError);
		System.out.println("Casted Manual: " + castedIntManual);
		

		
		
	}

}
