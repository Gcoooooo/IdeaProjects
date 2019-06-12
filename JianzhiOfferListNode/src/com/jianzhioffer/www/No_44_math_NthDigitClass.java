package com.jianzhioffer.www;

public class No_44_math_NthDigitClass {
    public int findNthDigit(int n) {
        long baseCount = 9; //ÿ��λ�������� 9��90��900....������1��ʼ������0��ʼһλ����10����
        int len = 1; //λ��
        int baseStart = 1; //ÿ��λ���ĵ�һ�������� 1��10��100.....
        
        while (n > baseCount * len) {
        	n -= baseCount * len;
        	baseCount *= 10;
        	baseStart *= 10;
        	len++;
        }
        
        //ѭ��������n��¼��Ŀ��ֵλ��baseStart֮��Ķ���λ������istart�����ʴ�ʱ��Ҫ��1����1֮���Ǵ�istart֮��һλ��ʼ��
        //���̵õ����ڿ�ʼ����ĵڼ�����������õ�����lenΪһ��������ô��λ����ָ��ĳ�������ĸ�λ�ã�0ʱ�պ�ָ��ĳ�����Ŀ�ʼλ��
        int num = baseStart + (n - 1) / len; //�������baseStart֮����digitλΪһ������ָ�����
        int target = (n - 1) % len; //�����baseStart֮���λ����ָ����digitλΪһ�������ĸ�������һλ
        
        return Integer.toString(num).charAt(target) - '0';
    }
}
