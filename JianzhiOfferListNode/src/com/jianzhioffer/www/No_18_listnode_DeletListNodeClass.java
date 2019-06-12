package com.jianzhioffer.www;

import java.util.List;

public class No_18_listnode_DeletListNodeClass {
    public void DeletNode(ListNode head, ListNode toBeDeleted) {
    	if (head == null || toBeDeleted == null) {
    		return ;
    	}
    	
    	if (toBeDeleted == head && head.next == null) { //��ֻ��һ���ڵ㣬��ɾ���ýڵ�ʱ
    		head = null;
    	} else if (toBeDeleted.next != null) { // ��ɾ���Ľڵ㲻�����һ���ڵ�
    		toBeDeleted.val = toBeDeleted.next.val; // ֻ��Ҫ��ɾ���ڵ��ֵ��Ϊ��next�ڵ��ֵ
    		toBeDeleted.next = toBeDeleted.next.next; //��ɾ���ڵ��next�ڵ��Ϊnext.next�ڵ�
    	} else if (toBeDeleted.next == null) { //ɾ�����һ���ڵ㣬��Ҫ�������ڶ����ڵ��next��Ϊnull����
    		     //ע�ⲻ��ֱ�ӽ�toBeDeleted��Ϊ�գ������Ļ������ڶ����ڵ��next��Ȼָ�����һ���ڵ㣬ֻ�����һ���ڵ���null
    		ListNode node = head;
    		
    		while (node.next != toBeDeleted) { //ѭ��ֱ���ҵ�toBeDeleted��ǰһ���ڵ�
    			node = node.next;
    		}
    		
    		node.next = null;
    	}
    }
}
