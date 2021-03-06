package com.pratmodi.one;

import java.util.Scanner;

public class Solution4 {

	public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int q=in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        System.out.println(printFormula(a, b, n, q));
        in.close();
    }
	
	public static String printFormula(int a, int b, int n, int q) {
		int progression;
		String sb = "";
		for(int i=0;i<q;i++){
			for(int j=0;j<n;j++) {
				if(j==0) {
					progression=(a+(2^0)*b);
				}
            progression = (a+(2^n-1)*b);
            progression = recursiveCall(progression,j);
			sb=" "+progression+" ";
			}
			sb = "\n";
		}
		return sb;
	}
	
	public static int recursiveCall(int progression, int n) {
		for(int j=0;j<n;j++) {	
		progression += recursiveCall(progression, j);
		}
		return progression;
	}
	
}
