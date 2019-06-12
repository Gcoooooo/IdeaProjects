package com.jianzhioffer.www;

public class No_21_array_ReOrderArrayClass {
    public void reOrderArray(int[] array) {
        if (array.length == 0 || array == null) {
        	return ;
        }
        
        int start = 0;
        int end = array.length - 1;
        
        while (start <= end) {
        	while (start <= end && array[start] >= 0) { //��Ϊ����������ż������ѭ��
        		start++;
        	}
        	
        	while (start <= end && array[end] < 0) { //��Ϊż��
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
