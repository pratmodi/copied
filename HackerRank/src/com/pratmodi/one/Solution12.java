package com.pratmodi.one;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution12 {

	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
			map.put(name,phone);
			in.nextLine();
			
		}
//		while (in.hasNext()) {
//			String s = in.nextLine();
//			if(s.equalsIgnoreCase(map.keySet().toString())) {
//				System.out.println(map.get(s));
//			}else {
//				System.out.println("Not found");
//			}
//		}
		
		while (in.hasNext()) {
			String s = in.nextLine();
			if((map.containsKey(s))) {
				System.out.println(s+"="+map.get(s));
			}else {
				System.out.println("Not found");
			}
		}
	}

}
