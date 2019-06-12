package com.jianzhioffer.www;

import java.util.HashMap;

public class No_03_array_DuplicateInArray {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0 || numbers == null) {
        	return false;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        duplication[0] = -1;
        
        for (int i = 0; i < length; i++) {
        	if (!map.containsKey(numbers[i])) {
        		map.put(numbers[i], 1);
        	} else {
        		duplication[0] = numbers[i];
        		return true;
        	}
        }
        
        return false;
    }
}
