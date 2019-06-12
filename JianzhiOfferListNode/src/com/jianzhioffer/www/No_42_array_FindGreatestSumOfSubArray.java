package com.jianzhioffer.www;

public class No_42_array_FindGreatestSumOfSubArray {
	boolean isInvalidInput = false; //标志是否是无效输入，用于区别最大和为0和无效输入时返回的0
    
	public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) { //输入无效时，标志置为true，同时返回0
        	isInvalidInput = true;
        	return 0;
        }
        
        int maxSum = Integer.MIN_VALUE; //存储当前最大和
        int sum = 0;
        
        for (int i = 0; i < array.length; i++) {
        	
        	if (sum < 0) { //对于当前值array[i]，若其左边的加和值小于零，则会对使得sum + array[i] < array[i]，即对最后的总和会有拖累
        		sum = array[i]; //故舍去之前的加和结果
        	} else { //对于当前值array[i]，若其左边的加和值大于零，则会对使得sum + array[i] > array[i]，对总和有益
        		sum += array[i]; //故继续累加
        	}
        	
        	if (sum > maxSum) {
        		maxSum = sum;
        	}
        }
        
        return maxSum;
    }
}
