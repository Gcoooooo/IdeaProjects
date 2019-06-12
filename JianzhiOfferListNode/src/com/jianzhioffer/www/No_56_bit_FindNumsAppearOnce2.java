package com.jianzhioffer.www;

public class No_56_bit_FindNumsAppearOnce2 {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int[] bitSum = new int[32]; //用于存储所有数每一位出现1的次数总和
        
        for (int i = 0; i < A.length; i++) {
            int bitMask = 1;
            
            //从右往左对取出来的每个数的每一位与1进行&运算
            for (int j = 31; j >=0; j--) { 
                int bit = A[i] & bitMask;
                
                if (bit != 0) { //若该位为1，则运算结果为1
                    bitSum[j] += 1; //该位计数加1
                }
                
                bitMask <<= 1; //左移，对下一位进行&运算
            }
        }
        
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitSum[i] % 3 != 0) {//不能被3整除说明目标数在那个位上一定为1
                result += (1 << (31 - i)); //1左移i位即加上该位为1时的数
            } 
        }
        
        return result;
    }
}
