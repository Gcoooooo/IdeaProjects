package com.jianzhioffer.www;

public class No_49_math_UglyNumber {
	/*
	 * ���ǰѵõ��ĵ�һ����������2�Ժ�õ��Ĵ���M�Ľ����ΪM2��
	 * ͬ�������ǰ����е�ÿһ����������3��5���ܵõ���һ������M�Ľ��M3��M5��
	 * ��ôM�������һ������Ӧ����M2,M3��M5���е���Сֵ��Min(M2,M3,M5)��
	 * ���罫���������е����ְ���С�������2��ֱ���õ���һ������M����Ϊֹ��
	 * ��ôӦ����2*2=4<M��3*2=6>M������M2=6��ͬ��M3=6��M5=10��������һ������Ӧ����6��
	 */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
        	return 0;
        }
        
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyNumberIndex = 1;
        
        /*
         * 2��3��5�ֱ��Ӧһ��ָ�룬�ֱ�ָ�������˵����г���
         */
        int p2Index = 0; //ָ�����ں�2��˵����г���
        int p3Index = 0;
        int p5Index = 0;
        
        /*
         * ��һ�֣�2��3��5����1��� --> ��СֵΪ2 --> ���¸�����Ϊ2(i = 1)--> p2Index���Ʊ��1��ָ��2����ѡ���ĳ���2��
         * �ڶ��֣�2��2��ˣ�3��5��Ȼ��1��� --> ��СֵΪ3 --> ���¸�����Ϊ3(i = 2) --> p3Index���Ʊ��1��ָ��2
         * �����֣�2��2��ˣ�3��2��ˣ�5��Ȼ��1��� --> ��СֵΪ4 --> ���¸�����Ϊ4(i = 3) --> p2Index���Ʊ��2��ָ��3
         * .....
         */
        for (int i = 1; i < index; i++) { //ÿһ���ҳ�һ�����������������Ҫ�� δ�ҵ��ĳ�������С��
        	
        	uglyNumbers[i] = findMinNum(2 * uglyNumbers[p2Index], 3 * uglyNumbers[p3Index], 5 * uglyNumbers[p5Index]);
        	
        	if (uglyNumbers[i] == 2 * uglyNumbers[p2Index]) { //��ѡ������С����Ϊ2����ĳ�����г�������p2Index���ƣ��´γ���һ�����г�����
        		p2Index++;
        	}
        	
        	if (uglyNumbers[i] == 3 * uglyNumbers[p3Index]) { //��ѡ������С����Ϊ3����ĳ�����г�������p3Index���ƣ��´γ���һ�����г�����
        		p3Index++;
        	}
        	
        	if (uglyNumbers[i] == 5 * uglyNumbers[p5Index]) { //��ѡ������С����Ϊ5����ĳ�����г�������p5Index���ƣ��´γ���һ�����г�����
        		p5Index++;
        	}
        }
        
        return uglyNumbers[index - 1];
        
    }
    
    public int findMinNum(int num1, int num2, int num3) {
    	return Math.min(num1, Math.min(num2, num3));
    }
}
