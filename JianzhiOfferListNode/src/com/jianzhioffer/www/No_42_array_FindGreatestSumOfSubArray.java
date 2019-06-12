package com.jianzhioffer.www;

public class No_42_array_FindGreatestSumOfSubArray {
	boolean isInvalidInput = false; //��־�Ƿ�����Ч���룬������������Ϊ0����Ч����ʱ���ص�0
    
	public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) { //������Чʱ����־��Ϊtrue��ͬʱ����0
        	isInvalidInput = true;
        	return 0;
        }
        
        int maxSum = Integer.MIN_VALUE; //�洢��ǰ����
        int sum = 0;
        
        for (int i = 0; i < array.length; i++) {
        	
        	if (sum < 0) { //���ڵ�ǰֵarray[i]��������ߵļӺ�ֵС���㣬����ʹ��sum + array[i] < array[i]�����������ܺͻ�������
        		sum = array[i]; //����ȥ֮ǰ�ļӺͽ��
        	} else { //���ڵ�ǰֵarray[i]��������ߵļӺ�ֵ�����㣬����ʹ��sum + array[i] > array[i]�����ܺ�����
        		sum += array[i]; //�ʼ����ۼ�
        	}
        	
        	if (sum > maxSum) {
        		maxSum = sum;
        	}
        }
        
        return maxSum;
    }
}
