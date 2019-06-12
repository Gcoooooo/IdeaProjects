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
    		int weight = round % 10; //�Ӹ�λ��ʼȡ
    		int former = n % base; //��ǰλ֮��ĵ�λ��
    		round = round / 10; // ��ǰλ֮ǰ�ĸ�λ��
    		
    		/*
    		 * round֮����Ҫ��base���磺ʮλ��Ҫ��10����Ϊʮλÿ�ֳ���1��������Ŀ��ֵ��ʮλ��1����͵�λ��0~9�ٽ������
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
