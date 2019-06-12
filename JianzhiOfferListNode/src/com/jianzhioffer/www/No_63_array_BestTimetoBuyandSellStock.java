package com.jianzhioffer.www;

public class No_63_array_BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int min = prices[0];
		int maxDiff = 0;
		
		for (int i = 1; i < prices.length; i++) { //最早买入时间为第一天，最早卖出时间为第二天
			min = prices[i] < min ? prices[i] : min;
			
			int diff = prices[i] - min;
			
			maxDiff = diff > maxDiff ? diff : maxDiff;
		}
		
		return maxDiff;
	}
}
