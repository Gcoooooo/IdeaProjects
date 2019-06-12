package com.jianzhioffer.www;

import java.awt.print.PrinterGraphics;
import java.util.Collections;

public class No_35_listnode_RandomListNodeCloneClass {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) { //ע��˴������������� pHead.next == null
        	return pHead;
        }
        
        RandomListNode tempNode = pHead;
        
        //�Ƚ�ÿ���ڵ㸴�ƺ󣬽����ƽڵ����ԭ�ڵ�֮��
        while (tempNode != null) {
        	RandomListNode next = tempNode.next;
        	RandomListNode random = tempNode.random;
        	
        	tempNode.next = new RandomListNode(tempNode.label);
        	tempNode.next.next = next;
        	
        	tempNode = tempNode.next.next;
        }
        
        tempNode = pHead;
        //��ԭ�ڵ���randomָ�룬�򽫸���ָ��ָ��ԭ�ڵ��ԭrandom����һ���ڵ�
        while (tempNode != null) {
        	if (tempNode.random != null) {
        		tempNode.next.random = tempNode.random;
        	}
        	
        	tempNode = tempNode.next.next; //ÿ�˱���ԭ�ڵ㼴��
        }
        
        //���
        RandomListNode newHead = pHead.next; //������
        RandomListNode oldHead = pHead; //ԭ����
        
        RandomListNode newHeadCopy = newHead;
        
        while (oldHead != null) {
        	oldHead.next = oldHead.next.next;
        	oldHead = oldHead.next;
        	
        	if (newHeadCopy.next != null) { //�����������һ���½ڵ�ʱ�������һ���ڵ㲻���в���
        		newHeadCopy.next = newHeadCopy.next.next;
        		newHeadCopy = newHeadCopy.next;
        	}	
        }
        
        return newHead;
    }
}
