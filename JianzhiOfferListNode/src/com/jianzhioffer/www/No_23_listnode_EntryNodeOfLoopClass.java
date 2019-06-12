package com.jianzhioffer.www;

import java.util.List;

public class No_23_listnode_EntryNodeOfLoopClass {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		
		ListNode meetNode = hasCycle(pHead); //找到相遇点
		
//		/*
//		 * 方法一：环外距离为a, 入口到相遇点的距离为b, 相遇点到入口的距离为c，环的长度为b + c
//		 * 1.当相遇时，慢指针走了a + b的距离，快指针走了a + n * (b + c) + b的距离（环外a + 环内n圈 + 走完n圈后又走的距离b）
//		 * 2.由于快指针的速度是慢指针的两倍，故其移动距离也是慢指针的两倍，即 2 * (a + b) = a + b + n * (b + c)
//		 * 3.经过等式变换可得a = (n - 1) * b + n * c = (n - 1) * (b +c) + c, 
//		 * 4.即若设置P1\P2两个指针以相同速度从链表起点和相遇点同时出发，当P1移动到环的入口时（距离a）, P2先走c再走n圈（从相遇点出发刚好可以先走c）
//		 * 两个指针就会在环的入口相遇（因为P1移动了a）
//		 */
//		
//		ListNode P1 = pHead; //P1从链表起点出发
//		ListNode P2 = meetNode; //P2从相遇点出发
//		
//		while (P1 != P2) {
//			P1 = P1.next;
//			P2 = P2.next;
//		}
//		
//		return P1;
		
		/*
		 * 方法二：环外距离为a，环的长度为n，当P2移动到入口处时（移动了a），P1移动了a + n，则他们会在环入口相遇，故P1需要先移动n
		 */
		
		//先求出环的长度
		int loopLength = 1; //注意是从1开始，meetNode就是第一个，后面计数循环都是从它之后才开始计数
		ListNode copyMeetNode = meetNode;
		while (copyMeetNode.next != meetNode) {
			copyMeetNode = copyMeetNode.next;
			loopLength++;
		}
		
		ListNode P1 = pHead;
		ListNode P2 = pHead;
		
		for (int i = 0; i < loopLength; i++) { //P1先移动环的长度n
			P1 = P1.next;
		}
		
		while (P1 != P2) {
		    P1 = P1.next;
		    P2 = P2.next;
	    }
	
	    return P1;
    }
	
	public ListNode hasCycle(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		
		ListNode slow = pHead;
		ListNode fast = pHead;
		
		while (slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) {
				return slow;
			}
		}
		
		return null;
	}
}
