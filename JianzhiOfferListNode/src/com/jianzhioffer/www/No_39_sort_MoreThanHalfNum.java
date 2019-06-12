package com.jianzhioffer.www;

public class No_39_sort_MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0 || array == null) {
        	return 0; //����Ϊnull��û��Ԫ�أ��򷵻�0
        }
        
        int lo = 0;
        int hi = array.length - 1;
        int mid = array.length / 2;
        
        int index = Partition(array, lo, hi);
        
        while (index != mid) { //ѭ��ֱ���ҵ��ֽ�� == �е�
        	if (index > mid) { //�ֽ�����е��ұ�ʱ����Ҫ��lo�ͷֽ��֮������з�
        		hi = index - 1; //����Ҫ�ı�hi��ֵ������ֱ���ڵ���Partition����ʱ��index - 1�����������������֮���ѭ������
        		index = Partition(array, lo, hi);
        	} else {
        		lo = index + 1;
        		index = Partition(array, lo, hi);
        	}
        }
        
        int target = array[index];
        int targetCount = 0;
        
        //���ڿ��ܳ����κ�����û�г���һ��������������Ҫ��֤��ʱ���е㴦�������Ƿ���ֳ�����һ��
        for (int n : array) {
        	if (n == target) {
        		targetCount++;
        	}
        }
        
        if (targetCount > array.length / 2) {
        	return target;
        } else {
        	return 0;
        }
    }
    
    public int Partition(int[] array, int lo, int hi) {
    	int baseIndex = lo;
    	int base = array[lo];
    	
    	lo = lo + 1;
    	
    	while (lo <= hi) {
    		while (lo <= hi && array[lo] <= base) {
    			lo++;
    		}
    		
    		while (lo <= hi && array[hi] >= base) {
    			hi--;
    		}
    		
    		if (lo <= hi) {
    			int temp = array[hi];
    			array[hi] = array[lo];
    			array[lo] = temp;
    		}
    	}
    	
    	int temp = array[hi];
    	array[hi] = base;
    	array[baseIndex] = temp;
    	
    	return hi;
    	
    }
}
