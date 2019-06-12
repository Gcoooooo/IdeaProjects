package com.jianzhioffer.www;

public class No_49_math_UglyNumber {
	/*
	 * 我们把得到的第一个丑数乘以2以后得到的大于M的结果记为M2。
	 * 同样，我们把已有的每一个丑数乘以3和5，能得到第一个大于M的结果M3和M5。
	 * 那么M后面的那一个丑数应该是M2,M3和M5当中的最小值：Min(M2,M3,M5)。
	 * 比如将丑数数组中的数字按从小到大乘以2，直到得到第一个大于M的数为止，
	 * 那么应该是2*2=4<M，3*2=6>M，所以M2=6。同理，M3=6，M5=10。所以下一个丑数应该是6。
	 */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
        	return 0;
        }
        
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyNumberIndex = 1;
        
        /*
         * 2、3、5分别对应一个指针，分别指向和其相乘的已有丑数
         */
        int p2Index = 0; //指向用于和2相乘的已有丑数
        int p3Index = 0;
        int p5Index = 0;
        
        /*
         * 第一轮：2、3、5都和1相乘 --> 最小值为2 --> 故下个丑数为2(i = 1)--> p2Index后移变成1，指向2（刚选出的丑数2）
         * 第二轮：2和2相乘，3、5仍然和1相乘 --> 最小值为3 --> 故下个丑数为3(i = 2) --> p3Index后移变成1，指向2
         * 第三轮：2和2相乘，3和2相乘，5仍然和1相乘 --> 最小值为4 --> 故下个丑数为4(i = 3) --> p2Index后移变成2，指向3
         * .....
         */
        for (int i = 1; i < index; i++) { //每一轮找出一个丑数，这个丑数需要是 未找到的丑数中最小的
        	
        	uglyNumbers[i] = findMinNum(2 * uglyNumbers[p2Index], 3 * uglyNumbers[p3Index], 5 * uglyNumbers[p5Index]);
        	
        	if (uglyNumbers[i] == 2 * uglyNumbers[p2Index]) { //若选出的最小丑数为2乘上某个已有丑数，则p2Index后移，下次乘下一个已有丑数数
        		p2Index++;
        	}
        	
        	if (uglyNumbers[i] == 3 * uglyNumbers[p3Index]) { //若选出的最小丑数为3乘上某个已有丑数，则p3Index后移，下次乘下一个已有丑数数
        		p3Index++;
        	}
        	
        	if (uglyNumbers[i] == 5 * uglyNumbers[p5Index]) { //若选出的最小丑数为5乘上某个已有丑数，则p5Index后移，下次乘下一个已有丑数数
        		p5Index++;
        	}
        }
        
        return uglyNumbers[index - 1];
        
    }
    
    public int findMinNum(int num1, int num2, int num3) {
    	return Math.min(num1, Math.min(num2, num3));
    }
}
