package org.baali.tests;

public class ObjectTest
{
	
	static void changeName(Student s)
	{
		s.name = s.name + " static";
	}
	
	static Student changeNameRet(Student s)
	{
		s.name = s.name + " return";
		return s;
	}
	public static void main(String[] args)
	{
		Student S = new Student(1, "ABC");
		Student s2 = new Student(2, "XYZ");
		System.out.println("Before void " + S.name);
		changeName(S);
		System.out.println("After void " + S.name);
		System.out.println("--------------------------");
		System.out.println("Before Ret " + S.name);
		changeNameRet(S);
		System.out.println("After Ret " + S.name);
		
		System.out.println("+++++++++++++++++++++++++");
		System.out.println("From Student Methods");
		System.out.println("+++++++++++++++++++++++++");
		
		System.out.println("Student Before void " + s2.name);
		s2.studentChangeName(s2);
		System.out.println("Student After void " + s2.name);
		System.out.println("-----------------------------");
		System.out.println("Student Before Return " + s2.name);
		s2.studentChangeNameRet(s2);
		System.out.println("Student After Return " + s2.name);
	}

}
