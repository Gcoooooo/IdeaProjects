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
	        int oldLength = str.length(); //�ȱ���֮ǰsb�Ĵ�С
	        
	        str.setLength(newLength); //��������sb�Ĵ�С��ע��˴��Ĵ�����
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
