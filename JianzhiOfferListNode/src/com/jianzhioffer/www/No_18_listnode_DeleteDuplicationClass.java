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
			
			while (cur.next != null && cur.val == cur.next.val) { // ����һ��������pHead.next != null����,����Ҫǰ��
				                                                        //ֻҪpHead���滹��Ԫ�أ��Ϳ��Լ����Ƚ�
				cur.next = cur.next.next; // ��pHead�����һ��Ԫ�ػ�����ȵģ����pHead��next��ָ��null
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
