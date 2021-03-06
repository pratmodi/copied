package com.pratmodi.one;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();
		String us="",india="",china="",france="";
		String symbol = null ;
		if(payment>=0&&payment<=Math.pow(10, 9)) {
			NumberFormat nf ;
			nf = NumberFormat.getCurrencyInstance(new Locale(Locale.US.getLanguage(),Locale.US.getCountry()));
			us = nf.format(payment);
			Locale locale = new Locale("English", "India");
			nf = java.text.NumberFormat.getCurrencyInstance(locale);
			nf.setCurrency(Currency.getInstance("INR"));
			india = nf.format(payment);
			nf = NumberFormat.getCurrencyInstance(new Locale(Locale.CHINESE.getLanguage(),Locale.CHINA.getCountry()));
			china = nf.format(payment);
			nf = NumberFormat.getCurrencyInstance(new Locale(Locale.FRANCE.getLanguage(),Locale.FRANCE.getCountry()));
			france = nf.format(payment);
		}
		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + france);
	}

}
