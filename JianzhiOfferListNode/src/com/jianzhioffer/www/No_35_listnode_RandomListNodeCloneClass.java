package com.jianzhioffer.www;

import java.awt.print.PrinterGraphics;
import java.util.Collections;

public class No_35_listnode_RandomListNodeCloneClass {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) { //注意此处不能设置条件 pHead.next == null
        	return pHead;
        }
        
        RandomListNode tempNode = pHead;
        
        //先将每个节点复制后，将复制节点放在原节点之后
        while (tempNode != null) {
        	RandomListNode next = tempNode.next;
        	RandomListNode random = tempNode.random;
        	
        	tempNode.next = new RandomListNode(tempNode.label);
        	tempNode.next.next = next;
        	
        	tempNode = tempNode.next.next;
        }
        
        tempNode = pHead;
        //若原节点有random指针，则将复制指针指向原节点的原random的下一个节点
        while (tempNode != null) {
        	if (tempNode.random != null) {
        		tempNode.next.random = tempNode.random;
        	}
        	
        	tempNode = tempNode.next.next; //每此遍历原节点即可
        }
        
        //拆表
        RandomListNode newHead = pHead.next; //新链表
        RandomListNode oldHead = pHead; //原链表
        
        RandomListNode newHeadCopy = newHead;
        
        while (oldHead != null) {
        	oldHead.next = oldHead.next.next;
        	oldHead = oldHead.next;
        	
        	if (newHeadCopy.next != null) { //当遍历至最后一个新节点时，对最后一个节点不进行操作
        		newHeadCopy.next = newHeadCopy.next.next;
        		newHeadCopy = newHeadCopy.next;
        	}	
        }
        
        return newHead;
    }
}
