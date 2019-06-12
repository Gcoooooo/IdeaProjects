package com.jianzhioffer.www;

public class No_21_array_ReOrderArrayClass {
    public void reOrderArray(int[] array) {
        if (array.length == 0 || array == null) {
        	return ;
        }
        
        int start = 0;
        int end = array.length - 1;
        
        while (start <= end) {
        	while (start <= end && array[start] >= 0) { //若为奇数，遇到偶数跳出循环
        		start++;
        	}
        	
        	while (start <= end && array[end] < 0) { //若为偶数
        		end--;
        	}
        	
        	if (start <= end) {
        		int temp = array[start];
            	array[start++] = array[end];
            	array[end--] = temp;
        	}
        }
    }
}
