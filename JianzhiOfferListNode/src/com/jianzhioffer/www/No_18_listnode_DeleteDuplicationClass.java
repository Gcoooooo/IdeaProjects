package com.jianzhioffer.www;

public class No_18_listnode_DeleteDuplicationClass {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		
		ListNode dummy = new ListNode(-1);
		dummy.next = pHead;
		ListNode prev = dummy;
		ListNode cur = pHead;
		
		// 1 2 2 2 3
		while (cur != null) {
			boolean isDuplicated = false;
			
			while (cur.next != null && cur.val == cur.next.val) { // 这种一定别忘了pHead.next != null条件,且需要前置
				                                                        //只要pHead后面还有元素，就可以继续比较
				cur.next = cur.next.next; // 若pHead与最后一个元素还是相等的，则会pHead的next会指向null
				isDuplicated = true;
			}
			
			// 1 2 3, prev = 1, cur = 3
			if (isDuplicated) {
				prev.next = cur.next;
				cur = cur.next;
			} else {
				cur = cur.next;
				prev = prev.next;
			}
		}
		
		return dummy.next;
	}
}
