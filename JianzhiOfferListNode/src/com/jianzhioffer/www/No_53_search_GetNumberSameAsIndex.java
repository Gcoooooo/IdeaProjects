package com.jianzhioffer.www;

public class No_53_search_GetNumberSameAsIndex {
	public int GetNumberSameAsIndex(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int lo = 0;
		int hi = nums.length - 1;
		
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if (nums[mid] > mid) { //此时mid右边的元素皆大于其下标
				hi = mid - 1;
			} else if (nums[mid] < mid) {
				lo = mid + 1;
			} else { 
				return mid;
			}
		}
		
		return -1;
	}

}
