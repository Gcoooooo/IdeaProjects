package com.jianzhioffer.www;

import java.nio.file.spi.FileSystemProvider;
import java.util.Stack;

public class No_31_stack_IsPopOrderClass {
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		Stack<Integer> stack = new Stack<>();
		int popIndex = 0;
		
		for (int i = 0; i < pushA.length; i++) { //ÿһ����ջһ��Ԫ��
			stack.push(pushA[i]);
			
			while (!stack.isEmpty() && popA[popIndex] == stack.peek()) { //��ջ�󣬲鿴��ջ����Ԫ���Ƿ�͵�ǰָ��ĳ�ջ�����Ԫ�����
				popIndex++;
				stack.pop();
			} 
		}
		
		if (!stack.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
