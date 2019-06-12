package com.jianzhioffer.www;

import java.util.ArrayList;

public class No_57_array_FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    	
    	if (sum < 3) {
    		return lists;
    	}
    	
    	int small = 1;
    	int big = 2;
    	int curSum = small + big;
    	
    	while (small <= ((1 + sum) / 2)) {
    		if (curSum < sum) {
    			big++;
    			curSum = ((small + big)* (big - small + 1) / 2); //等差数列求和
    		} else if (curSum > sum) {
    			small++;
    			curSum = ((small + big)* (big - small + 1) / 2); //等差数列求和
    		} else {
    			ArrayList<Integer> list = new ArrayList<>();
    			for (int i = small; i <= big; i++) {
    				list.add(i);
    			}
    			lists.add(list);
    			
    			big++; //继续
    			curSum = ((small + big)* (big - small + 1) / 2) ; //等差数列求和
    		}
    	}
    	
    	return lists;
    }
}
