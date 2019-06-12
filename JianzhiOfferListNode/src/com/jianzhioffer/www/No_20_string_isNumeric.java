package com.jianzhioffer.www;

import java.util.Collections;

public class No_20_string_isNumeric {
	int index = 0; //指向当前字符
	
	/*
	 * 分别需要扫描整数部分、小数点、小数部分、e或E、指数部分
	 * 整数部分和指数部分可以带正负号，小数部分不能带正负号
	 * 从前往后依次进行扫描，设置一个全局的指针，指向字符串中的字符
	 * 每个部分若符合要求，则返回true，指针也后移
	 * 若不符合要求，则函数会返回false，指针也不会移动，下一次调用函数扫描时，仍然从该处开始扫描
	 */
    public boolean isNumeric(char[] str) {
        if (str.length == 0 || str == null) {
        	return false;
        }
        
        //开头：1) 无符号整数; 2)有符号整数; 3)小数点
        boolean numeric = scanInteger(str); //扫描有符号整数或无符号整数，若扫描符合，则index就会一直移动，直到发现非0~9的字符
        
        //当遇到小数点时的处理，开头就是小数点也在这里扫描
        if (index < str.length && str[index] == '.') {
        	index++; //跳过小数点比较接下来的东西
        	numeric = scanUnsignedInteger(str) || numeric; //小数点前有整数，即可返回ture，小数点后使用scanUnsignedInteger扫描后续部分
        	                                               //****特别注意，此处不能调换顺序，否则根据短路原则，有可能不执行scanUnsignedInteger，忽略扫描小数部分

            //对于abc.123这种无效字符串，由于abc不符合要求，故最开始的判断会返回false，即numeric为false，且指针不会右移
        	//此时调用scanUnsignedInteger，就需要从头开始扫描，仍然会返回false
        }
        
        //遇到e或E时的处理
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
        	index++;
        	numeric = numeric && scanInteger(str); //e前面必须有整数，且指数部分也需要有整数
        }
        
        return numeric && (index == str.length); //当扫描完整个字符串且numeric为true时就返回true
    }
    
    //+123和123都返回true，返回false时index不会移动
    public boolean scanInteger(char[] str) { //用于扫描字符串中以 +或-开头的0~9数位（是否是带符号整数），或不带符号的0~9数位
    	if (index < str.length && (str[index] == '+' || str[index] == '-')) { //判断是否是以"+"或"-"开头，是的话index后移
    		                                                                  //不是就不做任何操作，此时相当于直接调用scanUnsignedInteger
    		index++;
    	}
    	
    	return scanUnsignedInteger(str); //若含有正负号，则此时输入扫描的是正负号之后的内容，若不含正负号，则相当于直接调用scanUnsignedInteger
    }
    
    //123返回true，返回false时index不会移动
    private boolean scanUnsignedInteger(char[] str) { //用于扫描字符串中0~9的数位（是否是无符号整数）
    	int start = index; //若是0~9的数字，则index必定后移
    	
    	while (index < str.length && (str[index] >= '0' && str[index] <= '9')) {
    		index++;
    	}
    	
    	return start < index; //若index后移了，则表明扫描到了无符号整数
    }
}
