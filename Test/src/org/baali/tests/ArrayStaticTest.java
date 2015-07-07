package org.baali.tests;

public class ArrayStaticTest
{
	static void doIt(int[] x)
	{
		x[0] = x[x.length - 1];
	}

	void doItInstance(int[] x)
	{
		x[0] = x[x.length - 1];
	}

	static void makeArrayNull(int[] x)
	{
		x = null;
		System.out.println(x);
	}

	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		int[] arr3 = { 10, 2, 3, 4, 5, 6, 7 };

		doIt(arr);

		ArrayStaticTest ast = new ArrayStaticTest();

		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}

		ast.doItInstance(arr2);
		System.out.println("----------------------");

		for (int i = 0; i < arr2.length; i++)
		{
			System.out.println(arr2[i]);
		}
		System.out.println("----------------------");
		makeArrayNull(arr3);
		for (int i = 0; i < arr3.length; i++)
		{
			System.out.println(arr3[i] + ";");
		}
	}

}
