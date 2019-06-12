package com.jianzhioffer.www;

import java.util.IllegalFormatCodePointException;
import java.util.List;

public class No_24_listnode_ReverseListClass {
    public ListNode ReverseList(ListNode head) {
    	if (head == null || head.next == null) { //�սڵ��ֻ��һ���ڵ�
    		return head;
    	}
    	
    	ListNode prev = null;
    	
    	while (head != null) {
    		ListNode next = head.next;
    		head.next = prev;
    		
    		prev = head;
    		head = next;
    	}
    	
    	return prev; //��������ѭ��ʱ��head�Ѿ�����null����ָ�������һ���ڵ�ĺ��棬��prev����ָ�����һ���ڵ�
    }
}
