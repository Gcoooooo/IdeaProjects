package com.jianzhioffer.www;

public class No_05_string_ReplaceSpaceClass {
	 public String replaceSpace(StringBuffer str) {
	        int spaceCount = 0;
	        
	        for (int i = 0; i < str.length(); i++) {
	            if (str.charAt(i) == ' ') {
	                spaceCount++;
	            }
	        }
	        
	        
	        
	        int newLength = spaceCount * 2 + str.length();
	        int oldLength = str.length(); //先保存之前sb的大小
	        
	        str.setLength(newLength); //重新设置sb的大小，注意此处的处理方法
	        int cur = newLength - 1;
	        
	        for (int i = oldLength - 1; i >= 0; i--) {
	            if (str.charAt(i) == ' ') {
	                str.setCharAt(cur--, '0');
	                str.setCharAt(cur--, '2');
	                str.setCharAt(cur--, '%');
	            } else {
	                str.setCharAt(cur--, str.charAt(i));
	            }
	        }
	        
	        return str.toString();
	    }
}
