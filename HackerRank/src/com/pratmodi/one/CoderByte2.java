package com.pratmodi.one;

import java.util.Scanner;

import java.util.regex.Pattern;

public class CoderByte2 {

	public static String QuestionsMarks(String str) {
		String s = "";
		try {
			char[] ch = str.toCharArray();
			int counter = 0;
			for (int i = 0; i < ch.length; i++) {
				if (ch[i] == '?') {
					counter++;
				}
				if (i+1<ch.length&&ch[i + 1] == '?')
					counter++;
				if (i+2<ch.length&&ch[i + 2] == '?')
					counter++;
				if (counter == 3) {
					// String regex = "\\d+";
					String regex = "[0-9]+";
					if (ch[i - 1] == Pattern.compile(regex).pattern().charAt(i - 1)
							&& ch[i + 3] == Pattern.compile(regex).pattern().charAt(i + 3)) {
						if (ch[i - 1] + ch[i + 3] == 10) {
							s = "true";
							return s;
						}
						else {
							s = "false";
							return s;
						}
					}
				}
			}
			s = "false";
		} catch (StringIndexOutOfBoundsException e) {
			s = "false";
			e.printStackTrace();
		}
		return s;
	}

	public static void main(String[] args) {

		// keep this function call here

		Scanner s = new Scanner(System.in);

		System.out.print(QuestionsMarks(s.nextLine()));

	}

}
