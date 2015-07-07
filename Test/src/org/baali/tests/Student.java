package org.baali.tests;

public class Student
{
	public int id;
	public String name;
	public Student(int id, String name)
	{
		
		this.id = id;
		this.name = name;
	}
	
	public void studentChangeName(Student s)
	{
		s.name = s.name + " void method";
	}
	
	public Student studentChangeNameRet(Student s)
	{
		s.name = s.name + " return method";
		return s;
	}
	
}
