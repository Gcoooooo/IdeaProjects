package com.jianzhioffer.www;

public class No_39_sort_MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0 || array == null) {
        	return 0; //数组为null或没有元素，则返回0
        }
        
        int lo = 0;
        int hi = array.length - 1;
        int mid = array.length / 2;
        
        int index = Partition(array, lo, hi);
        
        while (index != mid) { //循环直至找到分界点 == 中点
        	if (index > mid) { //分界点在中点右边时，需要在lo和分界点之间继续切分
        		hi = index - 1; //必须要改变hi的值，不能直接在调用Partition方法时用index - 1当参数，这样会造成之后的循环出错
        		index = Partition(array, lo, hi);
        	} else {
        		lo = index + 1;
        		index = Partition(array, lo, hi);
        	}
        }
        
        int target = array[index];
        int targetCount = 0;
        
        //由于可能出现任何数都没有超过一半的情况，所以需要验证此时在中点处的数字是否出现超过了一半
        for (int n : array) {
        	if (n == target) {
        		targetCount++;
        	}
        }
        
        if (targetCount > array.length / 2) {
        	return target;
        } else {
        	return 0;
        }
    }
    
    public int Partition(int[] array, int lo, int hi) {
    	int baseIndex = lo;
    	int base = array[lo];
    	
    	lo = lo + 1;
    	
    	while (lo <= hi) {
    		while (lo <= hi && array[lo] <= base) {
    			lo++;
    		}
    		
    		while (lo <= hi && array[hi] >= base) {
    			hi--;
    		}
    		
    		if (lo <= hi) {
    			int temp = array[hi];
    			array[hi] = array[lo];
    			array[lo] = temp;
    		}
    	}
    	
    	int temp = array[hi];
    	array[hi] = base;
    	array[baseIndex] = temp;
    	
    	return hi;
    	
    }
}
