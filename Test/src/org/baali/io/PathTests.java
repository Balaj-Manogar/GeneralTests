package org.baali.io;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class PathTests
{

	public static void main(String[] args)
	{
		Path p = Paths.get("hj/kjhl/kl.kj");
		System.out.println(p.getParent().resolve("kl"));
		for (int i = 0; i < 100; i++)
		{
			System.out.println(new Random().nextInt(3));
		}

	}

}
