package com.jianzhioffer.www;

import java.util.IllegalFormatCodePointException;
import java.util.List;

public class No_24_listnode_ReverseListClass {
    public ListNode ReverseList(ListNode head) {
    	if (head == null || head.next == null) { //空节点和只有一个节点
    		return head;
    	}
    	
    	ListNode prev = null;
    	
    	while (head != null) {
    		ListNode next = head.next;
    		head.next = prev;
    		
    		prev = head;
    		head = next;
    	}
    	
    	return prev; //由于跳出循环时，head已经等于null，即指向了最后一个节点的后面，而prev才是指向最后一个节点
    }
}
