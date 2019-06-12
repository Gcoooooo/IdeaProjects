package com.jianzhioffer.www;

public class No_22_listnode_FindKthToTailClass {
	/*
	 * 1.��Ҫ���������k == 0�����
	 * 2.��Ҫ����k���������ȵ����
	 * 3.˫ָ�룬��һ��ָ���ߵ�kʱ���ڶ���ָ�����
	 */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
        	return null;
        }
        
        ListNode copy = head;
        
        //��һ��ָ������k - 1��������k���ܳ��������ȣ���k - 1��ൽ�ﵹ���ڶ����ڵ㣬
        for (int i = 0; i < k - 1; i++) { //k - 1����ൽ�����ڶ����ڵ㣬��k��������������ĳ���
        	if (copy.next != null) { //��ָ��Ų��������һ���ڵ㣨��ʱcopy.next == null��ʱ���ͷ���null
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
