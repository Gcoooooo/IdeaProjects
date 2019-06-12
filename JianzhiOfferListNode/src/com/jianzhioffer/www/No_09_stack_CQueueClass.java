package com.jianzhioffer.www;

import java.util.Stack;

public class No_09_stack_CQueueClass {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() { //出队时，先把stack1中的元素出栈然后入栈到stack2中，此时元素从stack2出栈的顺序就符合队列的要求了
    	if (stack2.isEmpty()) { //当stack2中没有元素时，需要将stack1中的元素都入栈到stack2中
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
