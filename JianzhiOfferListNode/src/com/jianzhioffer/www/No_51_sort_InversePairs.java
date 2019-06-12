package com.jianzhioffer.www;

public class No_51_sort_InversePairs {
	int[] aux;
	int count;
	
    public int InversePairs(int [] array) {
    	if (array.length == 0 || array == null) {
    		return 0;
    	}
    	
        aux = new int[array.length];
        
        mergeSort(array, 0, array.length - 1);
        
        return count;
    }
    
    public void mergeSort(int[] nums, int lo, int hi) {
    	if (lo >= hi) {
    		return ;
    	}
    	
    	int mid = lo + ((hi - lo) >> 2);
    	
    	mergeSort(nums, lo, mid);
    	mergeSort(nums, mid + 1, hi);
    	
    	merge(nums, lo, mid, hi);
    }
    
    public void merge(int[] nums, int lo, int mid, int hi) {
    	int i = lo;
    	int j = mid + 1;
    	int cur = lo;
    	
    	for (int k = lo; k <= hi; k++) {
    		aux[k] = nums[k];
    	}
    	
    	/*
    	 * 所谓逆序就是前面的数字比后面的数字大
    	 */
    	while (i <= mid && j <= hi) { //分别从前半部分和后半部分取出较小的数放入数组nums
    		if (aux[i] <= aux[j]) {
    			nums[cur++] = aux[i++];
    		} else {
    			/*
        		 * 当前面的数字aux[i]比后面的数字aux[j]大时
        		 * 由于前半部分和后半部分都是有序的
        		 * 所以此时aux[i]到aux[mid]之间的数字都和aux[j]形成了逆序对，逆序对数即为aux[i]到aux[mid]之间的数字个数
        		 */
    			
    			nums[cur++] = aux[j++];
    			count += mid - i + 1; //aux[i]到aux[mid]之间的数字都和aux[j]形成的逆序对数
    			
    			if (count >= 1000000007) {
    				count %= 1000000007;
    			}
    		}
    	}
    	
    	while (i <= mid) {
    		nums[cur++] = aux[i++];
    	}
    	
    	while (j <= hi) {
    		nums[cur++] = aux[j++];
    	}
    	
    }
}
