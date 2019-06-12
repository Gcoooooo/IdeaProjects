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
    	 * ��ν�������ǰ������ֱȺ�������ִ�
    	 */
    	while (i <= mid && j <= hi) { //�ֱ��ǰ�벿�ֺͺ�벿��ȡ����С������������nums
    		if (aux[i] <= aux[j]) {
    			nums[cur++] = aux[i++];
    		} else {
    			/*
        		 * ��ǰ�������aux[i]�Ⱥ��������aux[j]��ʱ
        		 * ����ǰ�벿�ֺͺ�벿�ֶ��������
        		 * ���Դ�ʱaux[i]��aux[mid]֮������ֶ���aux[j]�γ�������ԣ����������Ϊaux[i]��aux[mid]֮������ָ���
        		 */
    			
    			nums[cur++] = aux[j++];
    			count += mid - i + 1; //aux[i]��aux[mid]֮������ֶ���aux[j]�γɵ��������
    			
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
