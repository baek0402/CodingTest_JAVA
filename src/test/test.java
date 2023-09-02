package test;

import java.util.*;
import java.io.*;
import java.time.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String idStr = "960402";
		
		int year = Integer.parseInt(idStr.substring(0, 2));
		int month = Integer.parseInt(idStr.substring(2, 4));
		int day = Integer.parseInt(idStr.substring(4, 6));

		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();

		int age = currentYear - (year+1900);
		
		System.out.println(age);
		
		List<Integer> al = new ArrayList<>();
		al.add(3);
		al.add(5);
		al.add(6);
		
		for(int n : al) System.out.println(n);
		
		al.remove(al.indexOf(3)); //remove는 인덱스구나..
		for(int n : al) System.out.println(n);
	}

}
