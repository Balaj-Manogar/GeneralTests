package org.baali.io;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Random;

public class CreateDirectoryAndWriteFiles
{

	public static void main(String[] args) throws IOException
	{
		String[] extensions = { ".txt", ".abc", ".yui", ".rest", "DS_Store" };
		String fileNamePrefix = "f-";
		final String dir = "user/";
		Path p;
		String extension;

		for (int i = 0; i < 10; i++)
		{
			extension = extensions[new Random().nextInt(4)];
			System.out.println(extension);
			p = Paths.get(dir + fileNamePrefix + i + extension);
			try (FileWriter writer = new FileWriter(p.toString()))
			{
				writer.write("some data");
				writer.flush();
			}
		}
		MoveClassToDirectory.checkDirectory(extensions, dir);
		//Files.walkFileTree(Paths.get(dir), new MoveClassToDirectory());
		MoveClassToDirectory.traverseDirectory(Paths.get(dir));
		
		System.out.println("Writer Finished");

	}
}

class MoveClassToDirectory extends SimpleFileVisitor<Path>
{

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
	{

		String fileName = file.getFileName().toString();

		String extensionName = fileName.substring((fileName.lastIndexOf(".") + 1));
		Path p = file.getParent().resolve(extensionName + "/" + fileName);
		System.out.println("Source: " + file.toString() + " Target: " + p.toString());
		System.out.println(Files.move(file, p, StandardCopyOption.REPLACE_EXISTING));

		return FileVisitResult.CONTINUE;
	}

	public static void traverseDirectory(Path p) throws IOException
	{
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(p))
		{
			for (Path file : ds)
			{
				if (Files.isDirectory(file))
				{
					continue;
				}
				String fileName = file.getFileName().toString();
				String extensionName = fileName.substring((fileName.lastIndexOf(".") + 1));
				Path target = file.getParent().resolve(extensionName + "/" + fileName);
				Files.move(file, target, StandardCopyOption.REPLACE_EXISTING);
			}
		}
	}

	static void checkDirectory(String[] extensions, String p)
	{
		for (String s : extensions)
		{
			s = s.replace(".", "");
			Path dir = Paths.get(p + s);
			System.out.println(dir.toString());
			try
			{
				if (!Files.exists(dir))
				{

					Files.createDirectory(dir);
				}
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
