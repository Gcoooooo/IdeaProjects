package com.jianzhioffer.www;

public class No_56_bit_FindNumsAppearOnce {
	//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	//��num1[0],num2[0]����Ϊ���ؽ��
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length < 2) {
        	return ;
        }
        
        int bitResult = 0;
        num1[0] = 0;
        num2[0] = 0;
        
        for (int n : array) {
        	bitResult ^= n;
        }
        
        int firstBit1Index = FindFirstBit1Index(bitResult);
        
        for (int n : array) {
        	if (isBit1(n, firstBit1Index)) { //����n�ĵ�firstBit1IndexλΪ1������ֵ���һ�鲢�����������
        		num1[0] ^= n;
        	} else { //����ֵ��ڶ��鲢�����������
        		num2[0] ^= n;
        	}
        }
        
    }
    
    //�������������������ҵ���һ�� "1"
    public int FindFirstBit1Index(int num) {
    	int index = 0;
    	
    	while ((1 & num) != 1 && index < 32) { //numÿ������һλ��ֱ�����һλΪ1Ϊֹ����ʱ��1����������0001��λȡ��Ϊ1��
    		                                   //ͬʱ������int��Ϊ32λ������Ҳ���ܳ���32λ
    		num >>= 1;
    	    index++;
    	}
    	
    	return index;
    }
    
   //�ж�������Ķ�������ʽ���ҵ����indexλ�Ƿ�Ϊ"1"
    public boolean isBit1(int num, int index) {
    	num >>= index;
    	return (1 & num) == 1;
    }
}
