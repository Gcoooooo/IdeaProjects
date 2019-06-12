package com.jianzhioffer.www;

public class No_43_math_NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
    	if (n < 1) {
    		return 0;
    	}
    	
        int base = 1;
        int round = n;
        int count = 0;
        
    	while (round > 0) {
    		int weight = round % 10; //从个位开始取
    		int former = n % base; //当前位之后的低位数
    		round = round / 10; // 当前位之前的高位数
    		
    		/*
    		 * round之所以要乘base，如：十位需要乘10是因为十位每轮出现1（或任意目标值）十位的1都会和低位的0~9再进行组合
    		 */
    		if (weight < 1) {
    			count = count + round * base;
    		} else if (weight > 1) {
    			count = count + round * base + base;
    		} else {
    			count = count + round * base + former + 1;
    		}
    		
    		base *= 10;
    	}
    	
    	return count;
    }
}
