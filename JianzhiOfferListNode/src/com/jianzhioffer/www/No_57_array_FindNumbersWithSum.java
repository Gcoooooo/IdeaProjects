package com.jianzhioffer.www;

import java.util.ArrayList;

public class No_57_array_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        if (array == null || array.length == 0) {
        	return arrayList;
        }
        
        int start = 0;
        int end = array.length - 1;
        
        while (start <= end) {
        	int tempSum = array[start] + array[end];
        	
        	if (tempSum > sum) {
        		end--;
        	} else if (tempSum < sum) {
        		start++;
        	} else {
        		arrayList.add(array[start]);
        		arrayList.add(array[end]);
        		
        		return arrayList;
        	}
        }
        
        return arrayList;
    }
}
