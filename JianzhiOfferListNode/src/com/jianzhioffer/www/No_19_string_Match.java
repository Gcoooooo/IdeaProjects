package com.jianzhioffer.www;

public class No_19_string_Match {
	/*
	 * 1������"."����ͨ�ַ���ģʽ���ַ���ͬʱ���ơ�
	 * 2��ģʽ�ĵڶ����ַ���"*"��
	 *    1) ��һ���ַ���ƥ�䣬��ô"*"��ʾ��ǰ����ַ�����0�Σ���'ba'��'a*ba'����ʱ�ַ������䣬ģʽ���������ַ���
	 *    2) ��һ���ַ�ƥ���ˣ���ô"*"��ʾ��ǰ����ַ�����0�Ρ�1�λ��Σ�����'aaa'��'a*aaa'��'aba'��'a*ba'��'aaaba'��'a*ba'��
	 *       a��ƥ��0��ʱ���ַ������䣬ģʽ���������ַ���
	 *       b��ƥ��1��ʱ���ַ�������һ���ַ���ģʽ���������ַ���
	 *       c��ƥ����ʱ���ַ�������һ���ַ���ģʽ���䣻
	 * 3��ģʽ�ĵڶ����ַ�����"*"��
	 *    1) �ַ����ĵ�һ���ַ���ģʽ�ĵ�һ���ַ�ƥ�䣬�����߶�����һ���ַ�
	 *    2) �ַ����ĵ�һ���ַ���ģʽ�ĵ�һ���ַ���ƥ�䣬�򷵻�false
	 */
    public boolean match(char[] str, char[] pattern) {
        if (str== null || pattern == null) {
        	return false;
        }
        
        int strIndex = 0; //�ַ���ָ��
        int patternIndex = 0; //ģʽָ��
        
        return matchCore(str, pattern, strIndex, patternIndex);
    }
    
    public boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
    	//����ָ��Ե�β�����򷵻�true
    	if (strIndex == str.length && patternIndex == pattern.length) {
    		return true;
    	}
    	
    	//���ַ���δ��β������ģʽ����β������˵����ƥ�䣬�򷵻�false
    	if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
    	
    	//��ģʽδ��β�������ַ�������β��(��һ��ƥ��ʧ�ܣ�����"a*"��".*"����ƥ��0���ַ�)
    	if (strIndex == str.length && patternIndex != pattern.length) {
    		//���ģʽ�ĵڶ����ַ���"*"�����ʱģʽ���������ַ�
    		if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
    			return matchCore(str, pattern, strIndex, patternIndex + 2); 
    		}
    		
    		return false;
    	}
    	
    	//��ģʽ�ĵ�ǰָ�����һλ��"*"���������ģʽ�ĵڶ�λ��"*"
    	if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
    		//���ַ���δ��β�����ַ����ĵ�һλƥ����ģʽ�еĵ�һλ�ַ�����"."
    		if ((strIndex < str.length && pattern[patternIndex] == str[strIndex]) 
    				|| (strIndex < str.length) && pattern[patternIndex] == '.') {
    			return matchCore(str, pattern, strIndex, patternIndex + 2) //ƥ��0��ʱ���ַ������䣬ģʽ���������ַ�	
    					|| matchCore(str, pattern, strIndex + 1, patternIndex + 2) //ƥ��1��ʱ���ַ�������һ���ַ���ģʽ���������ַ�
    					|| matchCore(str, pattern, strIndex + 1, patternIndex); //ƥ����ʱ���ַ�������һ���ַ���ģʽ���� 	
    		} else {
    			//�ַ����ĵ�һλ��ƥ��ģʽ�еĵ�һλ
                return matchCore(str, pattern, strIndex, patternIndex + 2); //��һ���ַ���ƥ�䣬��ô"*"��ʾ��ǰ����ַ�����0�Σ���'ba'��'a*ba'����ʱ�ַ������䣬ģʽ���������ַ�
    		}
    	}
    
    	//��ģʽ�ĵ�ǰָ�����һλ����"*"���������ģʽ�ĵڶ�λ����"*"
    	if ((strIndex < str.length && pattern[patternIndex] == str[strIndex]) //���ַ���δ��β�����ַ����ĵ�һλƥ����ģʽ�еĵ�һλ�ַ�����"."
    			|| (pattern[patternIndex] == '.' && strIndex < str.length)) {
    		return matchCore(str, pattern, strIndex + 1, patternIndex + 1); //�����߶�����һ���ַ�
    	}
    	
    	return false; //�ַ����ĵ�һ���ַ���ģʽ�ĵ�һ���ַ���ƥ�䣬�򷵻�false
    }
}
