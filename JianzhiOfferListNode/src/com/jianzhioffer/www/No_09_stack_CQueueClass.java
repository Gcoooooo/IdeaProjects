package com.jianzhioffer.www;

import java.util.Stack;

public class No_09_stack_CQueueClass {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() { //����ʱ���Ȱ�stack1�е�Ԫ�س�ջȻ����ջ��stack2�У���ʱԪ�ش�stack2��ջ��˳��ͷ��϶��е�Ҫ����
    	if (stack2.isEmpty()) { //��stack2��û��Ԫ��ʱ����Ҫ��stack1�е�Ԫ�ض���ջ��stack2��
    		if (stack1.isEmpty()) {
    			 throw new RuntimeException("Queue is empty!");
    		}
    		
    		while (!stack1.isEmpty()) {
    			stack2.push(stack1.pop());
    		}
    	}
    	
    	return stack2.pop();
    }
}
