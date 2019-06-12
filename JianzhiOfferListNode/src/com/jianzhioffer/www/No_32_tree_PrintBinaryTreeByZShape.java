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
//    	int toBePritend = 1; //初始值为1，及第一个根节点
//    	int nextLayerCount = 0; //记录下一层的节点数，当本层打印完后（toBePritend = 0时），就把此值存入toBePritend以备下一次打印
//    	                        //同时将nextLayerCount再次置为0，在下一次打印时，每打印一个节点就去统计其子节点的数量（nextLayerCount累加）
//    	                        //下一次打印的次数 == 打印上一层时nextLayerCount统计的数量 == 上一层打印结束时存入toBePritend的值
//    	ArrayList<Integer> list = new ArrayList<Integer>(); //用于存储每行的节点
//    	Stack<Integer> stack = new Stack<Integer>();
//    	boolean isEvenRow = false; //用来识别该行是否为偶数行
//    	
//    	while (!queue.isEmpty()) {
//    		TreeNode node = queue.poll();
//    		if (!isEvenRow) {
//    			list.add(node.val);
//			    toBePritend--;
//    		} else { //偶数行时，节点都先入栈，待toBePritend == 0时，再出栈加入到list中
//    			stack.push(node.val);
//    			toBePritend--;
//    		}
//    		
//    		
//			if (node.left != null) {
//    			queue.add(node.left);
//    			nextLayerCount++; //对node的左节点计数
//    		}
//    		
//    		if (node.right != null) {
//    			queue.add(node.right);
//    			nextLayerCount++; //对node的右节点计数
//    		}
//    		
//    		if (toBePritend == 0) { //当某行打印结束时
//    			if (isEvenRow) { //改行为偶数行时
//    				while (!stack.isEmpty()) {
//    					list.add(stack.pop());
//    				}
//    			}
//    			
//    			arrayLists.add(list); //将该行的结果存入arrayLists中
//    			
//    			isEvenRow = isEvenRow ? false : true; //下一行与上一行相反
//    			list = new ArrayList<>(); //下一行重新申请存储地址
//    			toBePritend = nextLayerCount; //下一行待打印个数，注意不要将此代码块放到前面，因为nextLayerCount的值应该在该行最后一个节点打印完并将其子节点统计完之后才赋值给toBePrinted
//    			nextLayerCount = 0; //为下下一行计数做准备
//    		}
//    	}
//    	
//    	return arrayLists;
		
		
		/*
		 * 剑指offer的解法：
		 * 打印奇数层时，第一个栈先存左节点再存右节点（打印下一层时先打印右再打印左）；
		 * 打印偶数层时，第一个栈先存右节点再存左节点（打印下一层时先打印左再打印右）；
		 */
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
    	
    	if (pRoot == null) {
    		return arrayLists;
    	}
    	
    	int toBePritend = 1; //初始值为1，及第一个根节点
    	int nextLayerCount = 0; //记录下一层的节点数，当本层打印完后（toBePritend = 0时），就把此值存入toBePritend以备下一次打印
    	                        //同时将nextLayerCount再次置为0，在下一次打印时，每打印一个节点就去统计其子节点的数量（nextLayerCount累加）
    	                        //下一次打印的次数 == 打印上一层时nextLayerCount统计的数量 == 上一层打印结束时存入toBePritend的值
    	ArrayList<Integer> list = new ArrayList<>(); //用于存储每行的节点
    	Stack<TreeNode> sOdd = new Stack<TreeNode>(); //记录奇数层节点
    	Stack<TreeNode> sEven = new Stack<TreeNode>(); //记录偶数层节点
    	boolean isEvenRow = false;
    	sOdd.add(pRoot);
    	
    	while (!sOdd.isEmpty() || !sEven.isEmpty()) {
    		if (isEvenRow) { //偶数层
    			TreeNode node = sEven.pop();
    			
    			list.add(node.val);
    			toBePritend--;
    			
    			//偶数层的下一层（奇数层），先入栈右节点，打印时先打印左节点
    			if (node.right != null) {
    				sOdd.push(node.right);
        			nextLayerCount++; //对node的右节点计数
        		}
    			
    			if (node.left != null) {
    				sOdd.push(node.left);
        			nextLayerCount++; //对node的左节点计数
        		}
    			
    		} else {
                TreeNode node = sOdd.pop();
                
                list.add(node.val);
    			toBePritend--;
    			
    			//先入栈左节点
    			if (node.left != null) {
    				sEven.push(node.left);
        			nextLayerCount++; //对node的左节点计数
        		}
        		
    			if (node.right != null) {
    				sEven.push(node.right);
        			nextLayerCount++; //对node的右节点计数
        		}
    		}
    		
    		if (toBePritend == 0) { //当某行打印结束时
    			arrayLists.add(list); //将该行的结果存入arrayLists中
    			isEvenRow = isEvenRow ? false : true; //下一行与上一行相反
    			list = new ArrayList<>(); //下一行重新申请存储地址
    			toBePritend = nextLayerCount; //下一行待打印个数，注意不要将此代码块放到前面，因为nextLayerCount的值应该在该行最后一个节点打印完并将其子节点统计完之后才赋值给toBePrinted
    			nextLayerCount = 0; //为下下一行计数做准备
    		}
    	}
    	
    	return arrayLists;
    }
}
