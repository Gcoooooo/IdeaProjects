package com.jianzhioffer.www;

import java.nio.file.spi.FileSystemProvider;
import java.util.Stack;

public class No_31_stack_IsPopOrderClass {
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		Stack<Integer> stack = new Stack<>();
		int popIndex = 0;
		
		for (int i = 0; i < pushA.length; i++) { //每一轮入栈一个元素
			stack.push(pushA[i]);
			
			while (!stack.isEmpty() && popA[popIndex] == stack.peek()) { //入栈后，查看其栈顶的元素是否和当前指向的出栈数组的元素相等
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
