package com.jianzhioffer.www;

import java.util.List;

public class No_23_listnode_EntryNodeOfLoopClass {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		
		ListNode meetNode = hasCycle(pHead); //�ҵ�������
		
//		/*
//		 * ����һ���������Ϊa, ��ڵ�������ľ���Ϊb, �����㵽��ڵľ���Ϊc�����ĳ���Ϊb + c
//		 * 1.������ʱ����ָ������a + b�ľ��룬��ָ������a + n * (b + c) + b�ľ��루����a + ����nȦ + ����nȦ�����ߵľ���b��
//		 * 2.���ڿ�ָ����ٶ�����ָ��������������ƶ�����Ҳ����ָ����������� 2 * (a + b) = a + b + n * (b + c)
//		 * 3.������ʽ�任�ɵ�a = (n - 1) * b + n * c = (n - 1) * (b +c) + c, 
//		 * 4.��������P1\P2����ָ������ͬ�ٶȴ���������������ͬʱ��������P1�ƶ����������ʱ������a��, P2����c����nȦ��������������պÿ�������c��
//		 * ����ָ��ͻ��ڻ��������������ΪP1�ƶ���a��
//		 */
//		
//		ListNode P1 = pHead; //P1������������
//		ListNode P2 = meetNode; //P2�����������
//		
//		while (P1 != P2) {
//			P1 = P1.next;
//			P2 = P2.next;
//		}
//		
//		return P1;
		
		/*
		 * ���������������Ϊa�����ĳ���Ϊn����P2�ƶ�����ڴ�ʱ���ƶ���a����P1�ƶ���a + n�������ǻ��ڻ������������P1��Ҫ���ƶ�n
		 */
		
		//��������ĳ���
		int loopLength = 1; //ע���Ǵ�1��ʼ��meetNode���ǵ�һ�����������ѭ�����Ǵ���֮��ſ�ʼ����
		ListNode copyMeetNode = meetNode;
		while (copyMeetNode.next != meetNode) {
			copyMeetNode = copyMeetNode.next;
			loopLength++;
		}
		
		ListNode P1 = pHead;
		ListNode P2 = pHead;
		
		for (int i = 0; i < loopLength; i++) { //P1���ƶ����ĳ���n
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
