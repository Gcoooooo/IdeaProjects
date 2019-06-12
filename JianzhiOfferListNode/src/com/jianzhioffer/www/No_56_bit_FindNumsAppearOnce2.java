package com.jianzhioffer.www;

public class No_56_bit_FindNumsAppearOnce2 {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int[] bitSum = new int[32]; //���ڴ洢������ÿһλ����1�Ĵ����ܺ�
        
        for (int i = 0; i < A.length; i++) {
            int bitMask = 1;
            
            //���������ȡ������ÿ������ÿһλ��1����&����
            for (int j = 31; j >=0; j--) { 
                int bit = A[i] & bitMask;
                
                if (bit != 0) { //����λΪ1����������Ϊ1
                    bitSum[j] += 1; //��λ������1
                }
                
                bitMask <<= 1; //���ƣ�����һλ����&����
            }
        }
        
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitSum[i] % 3 != 0) {//���ܱ�3����˵��Ŀ�������Ǹ�λ��һ��Ϊ1
                result += (1 << (31 - i)); //1����iλ�����ϸ�λΪ1ʱ����
            } 
        }
        
        return result;
    }
}
