package com.jianzhioffer.www;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No_32_tree_PrintBinaryTreeColByColClass {
	/*
	 * ��ӡ��һ���ʱ�򣬾Ͷ���һ��ĸ�������ͳ�ƣ�ÿ��ӡһ���ڵ㣬��ͳ�����ӽڵ�
	 * ���ڴ�ӡ��Ĵ�ӡ������   ��ӡ��һ���ʱ��ͳ�Ƶ� ��һ����ӽڵ���� Լ��
	 */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
    	
    	if (pRoot == null) {
    		return arrayLists;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(pRoot);
    	int toBePritend = 1; //��ʼֵΪ1������һ�����ڵ�
    	int nextLayerCount = 0; //��¼��һ��Ľڵ������������ӡ���toBePritend = 0ʱ�����ͰѴ�ֵ����toBePritend�Ա���һ�δ�ӡ
    	                        //ͬʱ��nextLayerCount�ٴ���Ϊ0������һ�δ�ӡʱ��ÿ��ӡһ���ڵ��ȥͳ�����ӽڵ��������nextLayerCount�ۼӣ�
    	                        //��һ�δ�ӡ�Ĵ��� == ��ӡ��һ��ʱnextLayerCountͳ�Ƶ����� == ��һ���ӡ����ʱ����toBePritend��ֵ
    	ArrayList<Integer> list = new ArrayList<>(); //���ڴ洢ÿ�еĽڵ�
    	
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		
    		list.add(node.val);
			toBePritend--;
    		
			if (node.left != null) {
    			queue.add(node.left);
    			nextLayerCount++; //��node����ڵ����
    		}
    		
    		if (node.right != null) {
    			queue.add(node.right);
    			nextLayerCount++; //��node���ҽڵ����
    		}
    		
    		if (toBePritend == 0) { //��ĳ�д�ӡ����ʱ
    			arrayLists.add(list); //�����еĽ������arrayLists��
    			list = new ArrayList<>(); //��һ����������洢��ַ
    			toBePritend = nextLayerCount; //��һ�д���ӡ������ע�ⲻҪ���˴����ŵ�ǰ�棬��ΪnextLayerCount��ֵӦ���ڸ������һ���ڵ��ӡ�겢�����ӽڵ�ͳ����֮��Ÿ�ֵ��toBePrinted
    			nextLayerCount = 0; //Ϊ����һ�м�����׼��
    		}
    	}
    	
    	return arrayLists;
    }
}
