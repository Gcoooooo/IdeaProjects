package com.jianzhioffer.www;

import java.util.Collections;

public class No_20_string_isNumeric {
	int index = 0; //ָ��ǰ�ַ�
	
	/*
	 * �ֱ���Ҫɨ���������֡�С���㡢С�����֡�e��E��ָ������
	 * �������ֺ�ָ�����ֿ��Դ������ţ�С�����ֲ��ܴ�������
	 * ��ǰ�������ν���ɨ�裬����һ��ȫ�ֵ�ָ�룬ָ���ַ����е��ַ�
	 * ÿ������������Ҫ���򷵻�true��ָ��Ҳ����
	 * ��������Ҫ�������᷵��false��ָ��Ҳ�����ƶ�����һ�ε��ú���ɨ��ʱ����Ȼ�Ӹô���ʼɨ��
	 */
    public boolean isNumeric(char[] str) {
        if (str.length == 0 || str == null) {
        	return false;
        }
        
        //��ͷ��1) �޷�������; 2)�з�������; 3)С����
        boolean numeric = scanInteger(str); //ɨ���з����������޷�����������ɨ����ϣ���index�ͻ�һֱ�ƶ���ֱ�����ַ�0~9���ַ�
        
        //������С����ʱ�Ĵ�����ͷ����С����Ҳ������ɨ��
        if (index < str.length && str[index] == '.') {
        	index++; //����С����ȽϽ������Ķ���
        	numeric = scanUnsignedInteger(str) || numeric; //С����ǰ�����������ɷ���ture��С�����ʹ��scanUnsignedIntegerɨ���������
        	                                               //****�ر�ע�⣬�˴����ܵ���˳�򣬷�����ݶ�·ԭ���п��ܲ�ִ��scanUnsignedInteger������ɨ��С������

            //����abc.123������Ч�ַ���������abc������Ҫ�󣬹��ʼ���жϻ᷵��false����numericΪfalse����ָ�벻������
        	//��ʱ����scanUnsignedInteger������Ҫ��ͷ��ʼɨ�裬��Ȼ�᷵��false
        }
        
        //����e��Eʱ�Ĵ���
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
        	index++;
        	numeric = numeric && scanInteger(str); //eǰ���������������ָ������Ҳ��Ҫ������
        }
        
        return numeric && (index == str.length); //��ɨ���������ַ�����numericΪtrueʱ�ͷ���true
    }
    
    //+123��123������true������falseʱindex�����ƶ�
    public boolean scanInteger(char[] str) { //����ɨ���ַ������� +��-��ͷ��0~9��λ���Ƿ��Ǵ��������������򲻴����ŵ�0~9��λ
    	if (index < str.length && (str[index] == '+' || str[index] == '-')) { //�ж��Ƿ�����"+"��"-"��ͷ���ǵĻ�index����
    		                                                                  //���ǾͲ����κβ�������ʱ�൱��ֱ�ӵ���scanUnsignedInteger
    		index++;
    	}
    	
    	return scanUnsignedInteger(str); //�����������ţ����ʱ����ɨ�����������֮������ݣ������������ţ����൱��ֱ�ӵ���scanUnsignedInteger
    }
    
    //123����true������falseʱindex�����ƶ�
    private boolean scanUnsignedInteger(char[] str) { //����ɨ���ַ�����0~9����λ���Ƿ����޷���������
    	int start = index; //����0~9�����֣���index�ض�����
    	
    	while (index < str.length && (str[index] >= '0' && str[index] <= '9')) {
    		index++;
    	}
    	
    	return start < index; //��index�����ˣ������ɨ�赽���޷�������
    }
}
