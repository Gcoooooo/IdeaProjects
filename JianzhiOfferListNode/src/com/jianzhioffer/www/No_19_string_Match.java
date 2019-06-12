package com.jianzhioffer.www;

public class No_19_string_Match {
	/*
	 * 1、遇到"."和普通字符，模式和字符串同时后移。
	 * 2、模式的第二个字符是"*"：
	 *    1) 第一个字符不匹配，那么"*"表示其前面的字符出现0次，如'ba'与'a*ba'，此时字符串不变，模式后移两个字符。
	 *    2) 第一个字符匹配了，那么"*"表示其前面的字符出现0次、1次或多次，比如'aaa'与'a*aaa'、'aba'与'a*ba'、'aaaba'与'a*ba'：
	 *       a、匹配0次时，字符串不变，模式后移两个字符；
	 *       b、匹配1次时，字符串后移一个字符，模式后移连个字符；
	 *       c、匹配多次时，字符串后移一个字符，模式不变；
	 * 3、模式的第二个字符不是"*"：
	 *    1) 字符串的第一个字符和模式的第一个字符匹配，则两者都后移一个字符
	 *    2) 字符串的第一个字符和模式的第一个字符不匹配，则返回false
	 */
    public boolean match(char[] str, char[] pattern) {
        if (str== null || pattern == null) {
        	return false;
        }
        
        int strIndex = 0; //字符串指针
        int patternIndex = 0; //模式指针
        
        return matchCore(str, pattern, strIndex, patternIndex);
    }
    
    public boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
    	//两者指针皆到尾部，则返回true
    	if (strIndex == str.length && patternIndex == pattern.length) {
    		return true;
    	}
    	
    	//若字符串未到尾部，但模式到了尾部，则说明不匹配，则返回false
    	if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
    	
    	//若模式未到尾部，但字符串到了尾部(不一定匹配失败，比如"a*"、".*"可以匹配0个字符)
    	if (strIndex == str.length && patternIndex != pattern.length) {
    		//如果模式的第二个字符是"*"，则此时模式后移两个字符
    		if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
    			return matchCore(str, pattern, strIndex, patternIndex + 2); 
    		}
    		
    		return false;
    	}
    	
    	//若模式的当前指针的下一位是"*"，即输入的模式的第二位是"*"
    	if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
    		//若字符串未到尾部，字符串的第一位匹配了模式中的第一位字符或是"."
    		if ((strIndex < str.length && pattern[patternIndex] == str[strIndex]) 
    				|| (strIndex < str.length) && pattern[patternIndex] == '.') {
    			return matchCore(str, pattern, strIndex, patternIndex + 2) //匹配0次时，字符串不变，模式后移两个字符	
    					|| matchCore(str, pattern, strIndex + 1, patternIndex + 2) //匹配1次时，字符串后移一个字符，模式后移连个字符
    					|| matchCore(str, pattern, strIndex + 1, patternIndex); //匹配多次时，字符串后移一个字符，模式不变 	
    		} else {
    			//字符串的第一位不匹配模式中的第一位
                return matchCore(str, pattern, strIndex, patternIndex + 2); //第一个字符不匹配，那么"*"表示其前面的字符出现0次，如'ba'与'a*ba'，此时字符串不变，模式后移两个字符
    		}
    	}
    
    	//若模式的当前指针的下一位不是"*"，即输入的模式的第二位不是"*"
    	if ((strIndex < str.length && pattern[patternIndex] == str[strIndex]) //若字符串未到尾部，字符串的第一位匹配了模式中的第一位字符或是"."
    			|| (pattern[patternIndex] == '.' && strIndex < str.length)) {
    		return matchCore(str, pattern, strIndex + 1, patternIndex + 1); //则两者都后移一个字符
    	}
    	
    	return false; //字符串的第一个字符和模式的第一个字符不匹配，则返回false
    }
}
