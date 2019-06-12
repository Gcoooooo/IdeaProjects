package com.jianzhioffer.www;

import java.util.ArrayList;
import java.util.Stack;

public class No_06_listnode_PrintListFromTailToHeadClass {
	
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	while (listNode != null) {
    		stack.push(listNode.val);
    		listNode = listNode.next;
    	}
    	
    	while (!stack.isEmpty()) {
    		list.add(stack.pop());
    	}
    	
    	return list;
    }

}
