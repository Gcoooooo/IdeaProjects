package com.jianzhioffer.www;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No_32_tree_PrintBinaryTreeColByColClass {
	/*
	 * 打印上一层的时候，就对下一层的个数进行统计，每打印一个节点，就统计其子节点
	 * 正在打印层的打印次数由   打印上一层的时候统计的 上一层的子节点个数 约束
	 */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
    	
    	if (pRoot == null) {
    		return arrayLists;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(pRoot);
    	int toBePritend = 1; //初始值为1，及第一个根节点
    	int nextLayerCount = 0; //记录下一层的节点数，当本层打印完后（toBePritend = 0时），就把此值存入toBePritend以备下一次打印
    	                        //同时将nextLayerCount再次置为0，在下一次打印时，每打印一个节点就去统计其子节点的数量（nextLayerCount累加）
    	                        //下一次打印的次数 == 打印上一层时nextLayerCount统计的数量 == 上一层打印结束时存入toBePritend的值
    	ArrayList<Integer> list = new ArrayList<>(); //用于存储每行的节点
    	
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		
    		list.add(node.val);
			toBePritend--;
    		
			if (node.left != null) {
    			queue.add(node.left);
    			nextLayerCount++; //对node的左节点计数
    		}
    		
    		if (node.right != null) {
    			queue.add(node.right);
    			nextLayerCount++; //对node的右节点计数
    		}
    		
    		if (toBePritend == 0) { //当某行打印结束时
    			arrayLists.add(list); //将该行的结果存入arrayLists中
    			list = new ArrayList<>(); //下一行重新申请存储地址
    			toBePritend = nextLayerCount; //下一行待打印个数，注意不要将此代码块放到前面，因为nextLayerCount的值应该在该行最后一个节点打印完并将其子节点统计完之后才赋值给toBePrinted
    			nextLayerCount = 0; //为下下一行计数做准备
    		}
    	}
    	
    	return arrayLists;
    }
}
