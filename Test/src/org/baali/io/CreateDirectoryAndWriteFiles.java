package org.baali.io;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class CreateDirectoryAndWriteFiles
{
	
	public static void main(String[] args) throws IOException
	{
		String[] extensions = {".txt", ".abc", ".yui", ".rest"};
		String fileNamePrefix = "f-";
		final String dir = "user/";
		Path p;
		String extension;
		
		
		for(int i = 0; i < 10; i++)
		{
			extension = extensions[new Random().nextInt(3)];
			System.out.println(extension);
			p = Paths.get(dir + fileNamePrefix + i + extension);
			try(FileWriter writer = new FileWriter(p.toString()))
			{				
				writer.write("some data");
				writer.flush();
			}
		}
		
		System.out.println("Writer Finished");
		
		
		
	}
}
