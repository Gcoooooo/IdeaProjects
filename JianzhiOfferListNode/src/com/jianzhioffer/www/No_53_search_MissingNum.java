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
        	
        	if (nums[mid] != mid) { //Ԫ�غ����±겻���ʱ
        		if (mid == 0 || nums[mid - 1] == mid - 1) { //����Ԫ�ص�ǰһ��Ԫ�ط���Ԫ�ص����±꣬���Ԫ�ؾ��ǵ�һ����λ�ĵط�
        			                                        //mid == 0����Ϊ��Ԫ���±�Ϊ0�����䲻������һ��Ԫ��
        			return mid;
        		} else { //�����������ǰ��μ�������
        			hi = mid - 1;
        		}
        	} else{
        		lo = mid + 1;
        	} 
        }
        
        return -1;
    }
}
