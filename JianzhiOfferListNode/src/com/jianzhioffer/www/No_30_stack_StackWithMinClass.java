package com.jianzhioffer.www;

import java.util.IllegalFormatCodePointException;
import java.util.Stack;

public class No_30_stack_StackWithMinClass {
	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
    
	public void push(int node) {
        dataStack.push(node);
        
        if (!minStack.isEmpty()) {
        	minStack.push(node < minStack.peek() ? node : minStack.peek());
        } else {
        	minStack.push(node);
        }
       
    }
    
    public void pop() {
    	if (!dataStack.isEmpty() && !minStack.isEmpty()) {
    		dataStack.pop();
            minStack.pop();
    	}
        
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    } 

}
