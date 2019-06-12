package com.jianzhioffer.www;

public class No_11_array_minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0 || array == null) {
        	return 0;
        }
        
        int lo = 0;
        int hi = array.length - 1;
        int mid = lo;
        
        while (array[lo] >= array[hi]) { //������������ֱ�ӷ���array[lo]��ֵ���ʳ�ʼ��midΪlo
        	if (lo + 1 == hi) { //����ָ������ʱ��lo��ǰ�벿�ֵ����hi�ں�벿�ֵ���ǰ�棩����ʱ��ֹ�������غ�벿�ֵ���ʼֵ����hiָ���ֵ
        		return array[hi]; 
        	} 
        	
        	mid = lo + ((hi - lo) >> 1);
        	
        	//��lo��hi��midָ���ֵ���ʱ���޷����ж��ֲ��ң���ʱֻ��ʹ��˳�����
        	if (array[lo] == array [hi] && array[lo] == array[mid]) { 
        		int min = Integer.MAX_VALUE;
        		
        		for (int i = lo; i <= hi; i++) {
        			if (array[i] < min) {
        				min = array[i];
        			}
        		}
        		
        		return min;
        	}
        	
        	//����ʹ�����ƶ��ֲ��ҵķ������в���
        	if (array[mid] <= array[hi]) {
        		hi = mid; //Ϊ�˱���hiԽ�絽ǰ�벿��
        	} else if (array[mid] > array[hi]) {
        		lo = mid;
        	}
        	
        } 
        
        return array[lo];
    }
}
