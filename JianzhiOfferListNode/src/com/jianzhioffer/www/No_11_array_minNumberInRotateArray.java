package com.jianzhioffer.www;

public class No_11_array_minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0 || array == null) {
        	return 0;
        }
        
        int lo = 0;
        int hi = array.length - 1;
        int mid = lo;
        
        while (array[lo] >= array[hi]) { //若数组有序则直接返回array[lo]的值，故初始化mid为lo
        	if (lo + 1 == hi) { //两个指针相邻时（lo在前半部分的最后，hi在后半部分的最前面），此时终止，并返回后半部分的起始值，即hi指向的值
        		return array[hi]; 
        	} 
        	
        	mid = lo + ((hi - lo) >> 1);
        	
        	//当lo、hi和mid指向的值相等时，无法进行二分查找，此时只能使用顺序查找
        	if (array[lo] == array [hi] && array[lo] == array[mid]) { 
        		int min = Integer.MAX_VALUE;
        		
        		for (int i = lo; i <= hi; i++) {
        			if (array[i] < min) {
        				min = array[i];
        			}
        		}
        		
        		return min;
        	}
        	
        	//否则使用类似二分查找的方法进行查找
        	if (array[mid] <= array[hi]) {
        		hi = mid; //为了避免hi越界到前半部分
        	} else if (array[mid] > array[hi]) {
        		lo = mid;
        	}
        	
        } 
        
        return array[lo];
    }
}
