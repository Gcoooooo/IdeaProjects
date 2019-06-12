package com.jianzhioffer.www;

import java.util.ArrayList;

public class No_38_string_PermutationClass {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strs = new ArrayList<>();
        
        if (str.trim().length() == 0 || str == null) {
        	return strs;
        }
        char[] cs = str.toCharArray();
        Permutation(strs, cs, 0);
        
        return strs;
    }
    
    public void Permutation(ArrayList<String> strs, char[] cs, int start) {
        
        if (start == cs.length - 1) {
        	if (!strs.contains(String.valueOf(cs))) {
        		strs.add(String.valueOf(cs));
        	}
        } else {
        	
        	for (int i = start; i < cs.length; i++) {
        		char temp = cs[start];
        		cs[start] = cs[i];
        		cs[i] = temp;
        		
        		Permutation(strs, cs, start + 1);
        		
        		temp = cs[start];
        		cs[start] = cs[i];
        		cs[i] = temp;
        		
        	}
        }   
    }
}
