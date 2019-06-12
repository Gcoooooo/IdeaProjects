package com.jianzhioffer.www;

import java.util.List;

public class No_18_listnode_DeletListNodeClass {
    public void DeletNode(ListNode head, ListNode toBeDeleted) {
    	if (head == null || toBeDeleted == null) {
    		return ;
    	}
    	
    	if (toBeDeleted == head && head.next == null) { //当只有一个节点，且删除该节点时
    		head = null;
    	} else if (toBeDeleted.next != null) { // 当删除的节点不是最后一个节点
    		toBeDeleted.val = toBeDeleted.next.val; // 只需要将删除节点的值改为其next节点的值
    		toBeDeleted.next = toBeDeleted.next.next; //将删除节点的next节点改为next.next节点
    	} else if (toBeDeleted.next == null) { //删除最后一个节点，需要将倒数第二个节点的next置为null即可
    		     //注意不能直接将toBeDeleted置为空，那样的话倒数第二个节点的next仍然指向最后一个节点，只是最后一个节点是null
    		ListNode node = head;
    		
    		while (node.next != toBeDeleted) { //循环直至找到toBeDeleted的前一个节点
    			node = node.next;
    		}
    		
    		node.next = null;
    	}
    }
}
