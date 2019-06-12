package com.jianzhioffer.www;

public class No_44_math_NthDigitClass {
    public int findNthDigit(int n) {
        long baseCount = 9; //每种位数依次有 9、90、900....个（从1开始，若从0开始一位数有10个）
        int len = 1; //位数
        int baseStart = 1; //每种位数的第一个数，如 1，10，100.....
        
        while (n > baseCount * len) {
        	n -= baseCount * len;
        	baseCount *= 10;
        	baseStart *= 10;
        	len++;
        }
        
        //循环结束后n记录了目标值位于baseStart之后的多少位（包括istart），故此时需要减1，减1之后是从istart之后一位开始算
        //求商得到了在开始数后的第几个数，求余得到了以len为一个数后，这么多位数该指向某个数的哪个位置，0时刚好指向某个数的开始位置
        int num = baseStart + (n - 1) / len; //计算出从baseStart之后，以digit位为一个数后，指向的数
        int target = (n - 1) % len; //计算从baseStart之后的位数，指向了digit位为一个数后，哪个数的哪一位
        
        return Integer.toString(num).charAt(target) - '0';
    }
}
