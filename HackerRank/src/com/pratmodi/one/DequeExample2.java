package com.pratmodi.one;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//6 3
//5 3 5 2 3 2
//5 3 4 2 3 2 2
public class DequeExample2 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
        int counter=0;
        for(int j=0;j<n;j++) {
        	for(int z=j;j<n;j++) {
        		counter++;
        		set.add(num);
        		if(counter==m)
        			break;
        	}
        }
       }
        System.out.println(set.size());
    }

}
