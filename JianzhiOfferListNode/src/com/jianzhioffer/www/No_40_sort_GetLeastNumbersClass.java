package com.jianzhioffer.www;

import java.util.ArrayList;

public class No_40_sort_GetLeastNumbersClass {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        
        if (input == null || input.length < k || k < 1) {
        	return list;
        }
        
        int lo = 0;
        int hi = input.length - 1;
        int index = Partition(input, lo, hi);
        
        while (index != k - 1) {
        	if (index < k) { //当分界点位于k左边，则需要去当前分界点的右边继续切分
        		lo = index + 1;
        		index = Partition(input, lo, hi);
        	} else {
        		hi = index - 1;
        		index = Partition(input, lo, hi);
        	}
        }
        
        for (int i = 0; i < k; i++) {
        	list.add(input[i]);
        }
        
        return list;
    }
    
    public int Partition(int[] input, int lo, int hi) {
    	int baseIndex = lo;
    	int base = input[lo];
    	
    	lo++;
    	
    	while (lo <= hi) {
    		while (lo <= hi && input[lo] <= base) {
    			lo++;
    		}
    		
    		while (lo <= hi && input[hi] >= base) {
    			hi--;
    		}
    		
    		if (lo <= hi) {
    			int temp = input[hi];
    			input[hi] = input[lo];
    			input[lo] = temp;
    		}
    	}
    	
    	int temp = input[hi];
    	input[hi] = input[baseIndex];
    	input[baseIndex] = temp;
    	
    	return hi;
    }
}
