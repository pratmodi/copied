package com.pratmodi.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student2{
	private int id;
	private String fname;
	private double cgpa;
	public Student2(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

public class PrioritiesExample {
	public static List<Student> getStudents(List<String> events){
		
		List<Student> list = new ArrayList<Student>();
		Collections.sort(events, new Comparator<String>() {
			String name1,name2;
			double cgpa1,cgpa2;
			int id1,id2;
			@Override
			public int compare(String o1, String o2) {
				
				String[] str1 = o1.split(" ");
				String[] str2 = o2.split(" ");
				name1 = str1[1];
				cgpa1= Double.valueOf(str1[2]);
				id1= Integer.valueOf(str1[3]);
				
				name2 = str2[1];
				cgpa2= Double.valueOf(str2[2]);
				id2= Integer.valueOf(str2[3]);
				
				if (cgpa1 == cgpa2) {
                    if (name1.equals(name2)) {
                        return id1 - id2;
                    } else {
                        return name1.compareTo(name2);
                    }

                } else {
                    return (int) (cgpa1 * 1000 - cgpa2 * 1000);
                }
			}
			Student2 s1 = new Student2(id1, name1, cgpa1);
			Student2 s2 = new Student2(id2, name2, cgpa2);
			
			
		});
		
		list.add((Student) getStudents(events));
		
		return list;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String enter = null;
		String served;
		List<String> list = null;
		for(int i=0;i<n;i++) {
			 enter = sc.nextLine();
			 served = sc.nextLine();
			 
			 String modEnter = enter.replaceAll("ENTER", enter);
				String[] strArrayModEnter = modEnter.split(" ");
				
				 list = new ArrayList<String>();
				for(String s:strArrayModEnter) {
					list.add(s);
				}
		}
		
		getStudents(list);
		
	}
	
}
