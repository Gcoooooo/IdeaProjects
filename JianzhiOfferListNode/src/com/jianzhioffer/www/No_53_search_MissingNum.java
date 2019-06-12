package com.jianzhioffer.www;

public class No_53_search_MissingNum {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return -1;
        }
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
        	int mid = lo + (hi - lo) / 2;
        	
        	if (nums[mid] != mid) { //元素和其下标不相等时
        		if (mid == 0 || nums[mid - 1] == mid - 1) { //若该元素的前一个元素符合元素等于下标，则该元素就是第一个错位的地方
        			                                        //mid == 0是因为若元素下标为0，则其不存在上一个元素
        			return mid;
        		} else { //其他情况，到前半段继续搜索
        			hi = mid - 1;
        		}
        	} else{
        		lo = mid + 1;
        	} 
        }
        
        return -1;
    }
}
