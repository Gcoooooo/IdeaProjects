package com.jianzhioffer.www;

import java.util.Arrays;
import java.util.Comparator;

public class No_45_recursion_PrintMinNumberClass {
    public String PrintMinNumber(int [] numbers) {
    	if (numbers == null || numbers.length == 0) {
    		return "";
    	}
    	
    	String[] strs = new String[numbers.length];
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < numbers.length; i++) {
    		strs[i] = String.valueOf(numbers[i]);
    	}
    	
    	//利用自定义的排序规则进行排序
    	Arrays.sort(strs, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) { //s1s2 < s2s1，则s1 < s2
				String string1 = s1 + s2;
				String string2 = s2 + s1;
 				
				return string1.compareTo(string2);
			}
    		
		});
    	
    	for (String s : strs) {
    		sb.append(s);
    	}
    	
    	return sb.toString();
    }
}
