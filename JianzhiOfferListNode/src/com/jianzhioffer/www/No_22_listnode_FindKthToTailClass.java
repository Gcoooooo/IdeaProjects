package com.jianzhioffer.www;

public class No_22_listnode_FindKthToTailClass {
	/*
	 * 1.需要处理空链表及k == 0的情况
	 * 2.需要处理当k大于链表长度的情况
	 * 3.双指针，第一个指针走到k时，第二个指针出发
	 */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
        	return null;
        }
        
        ListNode copy = head;
        
        //第一个指针先走k - 1步，由于k不能超过链表长度，故k - 1最多到达倒数第二个节点，
        for (int i = 0; i < k - 1; i++) { //k - 1步最多到倒数第二个节点，即k最多等于整个链表的长度
        	if (copy.next != null) { //当指针挪到倒数第一个节点（此时copy.next == null）时，就返回null
        		copy = copy.next;
        	} else { 
        		return null; 
        	}
        } 
        
        while (copy.next != null) {
        	copy = copy.next;
        	head = head.next;
        }
        
        return head;
    }
}
