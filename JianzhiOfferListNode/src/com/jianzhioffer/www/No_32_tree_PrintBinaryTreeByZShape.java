package com.jianzhioffer.www;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No_32_tree_PrintBinaryTreeByZShape {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//    	ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
//    	
//    	if (pRoot == null) {
//    		return arrayLists;
//    	}
//    	
//    	Queue<TreeNode> queue = new LinkedList<>();
//    	queue.add(pRoot);
//    	int toBePritend = 1; //��ʼֵΪ1������һ�����ڵ�
//    	int nextLayerCount = 0; //��¼��һ��Ľڵ������������ӡ���toBePritend = 0ʱ�����ͰѴ�ֵ����toBePritend�Ա���һ�δ�ӡ
//    	                        //ͬʱ��nextLayerCount�ٴ���Ϊ0������һ�δ�ӡʱ��ÿ��ӡһ���ڵ��ȥͳ�����ӽڵ��������nextLayerCount�ۼӣ�
//    	                        //��һ�δ�ӡ�Ĵ��� == ��ӡ��һ��ʱnextLayerCountͳ�Ƶ����� == ��һ���ӡ����ʱ����toBePritend��ֵ
//    	ArrayList<Integer> list = new ArrayList<Integer>(); //���ڴ洢ÿ�еĽڵ�
//    	Stack<Integer> stack = new Stack<Integer>();
//    	boolean isEvenRow = false; //����ʶ������Ƿ�Ϊż����
//    	
//    	while (!queue.isEmpty()) {
//    		TreeNode node = queue.poll();
//    		if (!isEvenRow) {
//    			list.add(node.val);
//			    toBePritend--;
//    		} else { //ż����ʱ���ڵ㶼����ջ����toBePritend == 0ʱ���ٳ�ջ���뵽list��
//    			stack.push(node.val);
//    			toBePritend--;
//    		}
//    		
//    		
//			if (node.left != null) {
//    			queue.add(node.left);
//    			nextLayerCount++; //��node����ڵ����
//    		}
//    		
//    		if (node.right != null) {
//    			queue.add(node.right);
//    			nextLayerCount++; //��node���ҽڵ����
//    		}
//    		
//    		if (toBePritend == 0) { //��ĳ�д�ӡ����ʱ
//    			if (isEvenRow) { //����Ϊż����ʱ
//    				while (!stack.isEmpty()) {
//    					list.add(stack.pop());
//    				}
//    			}
//    			
//    			arrayLists.add(list); //�����еĽ������arrayLists��
//    			
//    			isEvenRow = isEvenRow ? false : true; //��һ������һ���෴
//    			list = new ArrayList<>(); //��һ����������洢��ַ
//    			toBePritend = nextLayerCount; //��һ�д���ӡ������ע�ⲻҪ���˴����ŵ�ǰ�棬��ΪnextLayerCount��ֵӦ���ڸ������һ���ڵ��ӡ�겢�����ӽڵ�ͳ����֮��Ÿ�ֵ��toBePrinted
//    			nextLayerCount = 0; //Ϊ����һ�м�����׼��
//    		}
//    	}
//    	
//    	return arrayLists;
		
		
		/*
		 * ��ָoffer�Ľⷨ��
		 * ��ӡ������ʱ����һ��ջ�ȴ���ڵ��ٴ��ҽڵ㣨��ӡ��һ��ʱ�ȴ�ӡ���ٴ�ӡ�󣩣�
		 * ��ӡż����ʱ����һ��ջ�ȴ��ҽڵ��ٴ���ڵ㣨��ӡ��һ��ʱ�ȴ�ӡ���ٴ�ӡ�ң���
		 */
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
    	
    	if (pRoot == null) {
    		return arrayLists;
    	}
    	
    	int toBePritend = 1; //��ʼֵΪ1������һ�����ڵ�
    	int nextLayerCount = 0; //��¼��һ��Ľڵ������������ӡ���toBePritend = 0ʱ�����ͰѴ�ֵ����toBePritend�Ա���һ�δ�ӡ
    	                        //ͬʱ��nextLayerCount�ٴ���Ϊ0������һ�δ�ӡʱ��ÿ��ӡһ���ڵ��ȥͳ�����ӽڵ��������nextLayerCount�ۼӣ�
    	                        //��һ�δ�ӡ�Ĵ��� == ��ӡ��һ��ʱnextLayerCountͳ�Ƶ����� == ��һ���ӡ����ʱ����toBePritend��ֵ
    	ArrayList<Integer> list = new ArrayList<>(); //���ڴ洢ÿ�еĽڵ�
    	Stack<TreeNode> sOdd = new Stack<TreeNode>(); //��¼������ڵ�
    	Stack<TreeNode> sEven = new Stack<TreeNode>(); //��¼ż����ڵ�
    	boolean isEvenRow = false;
    	sOdd.add(pRoot);
    	
    	while (!sOdd.isEmpty() || !sEven.isEmpty()) {
    		if (isEvenRow) { //ż����
    			TreeNode node = sEven.pop();
    			
    			list.add(node.val);
    			toBePritend--;
    			
    			//ż�������һ�㣨�����㣩������ջ�ҽڵ㣬��ӡʱ�ȴ�ӡ��ڵ�
    			if (node.right != null) {
    				sOdd.push(node.right);
        			nextLayerCount++; //��node���ҽڵ����
        		}
    			
    			if (node.left != null) {
    				sOdd.push(node.left);
        			nextLayerCount++; //��node����ڵ����
        		}
    			
    		} else {
                TreeNode node = sOdd.pop();
                
                list.add(node.val);
    			toBePritend--;
    			
    			//����ջ��ڵ�
    			if (node.left != null) {
    				sEven.push(node.left);
        			nextLayerCount++; //��node����ڵ����
        		}
        		
    			if (node.right != null) {
    				sEven.push(node.right);
        			nextLayerCount++; //��node���ҽڵ����
        		}
    		}
    		
    		if (toBePritend == 0) { //��ĳ�д�ӡ����ʱ
    			arrayLists.add(list); //�����еĽ������arrayLists��
    			isEvenRow = isEvenRow ? false : true; //��һ������һ���෴
    			list = new ArrayList<>(); //��һ����������洢��ַ
    			toBePritend = nextLayerCount; //��һ�д���ӡ������ע�ⲻҪ���˴����ŵ�ǰ�棬��ΪnextLayerCount��ֵӦ���ڸ������һ���ڵ��ӡ�겢�����ӽڵ�ͳ����֮��Ÿ�ֵ��toBePrinted
    			nextLayerCount = 0; //Ϊ����һ�м�����׼��
    		}
    	}
    	
    	return arrayLists;
    }
}
