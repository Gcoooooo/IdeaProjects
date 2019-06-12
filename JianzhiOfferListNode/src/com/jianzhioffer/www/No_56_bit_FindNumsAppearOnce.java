package com.jianzhioffer.www;

public class No_56_bit_FindNumsAppearOnce {
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
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
        	if (isBit1(n, firstBit1Index)) { //若数n的第firstBit1Index位为1，则其分到第一组并进行异或运算
        		num1[0] ^= n;
        	} else { //否则分到第二组并进行异或运算
        		num2[0] ^= n;
        	}
        }
        
    }
    
    //二进制数，从右往左找到第一个 "1"
    public int FindFirstBit1Index(int num) {
    	int index = 0;
    	
    	while ((1 & num) != 1 && index < 32) { //num每次右移一位，直到最后一位为1为止（此时和1，即二进制0001按位取与为1）
    		                                   //同时，由于int型为32位，右移也不能超过32位
    		num >>= 1;
    	    index++;
    	}
    	
    	return index;
    }
    
   //判断这个数的二进制形式从右到左的index位是否为"1"
    public boolean isBit1(int num, int index) {
    	num >>= index;
    	return (1 & num) == 1;
    }
}
