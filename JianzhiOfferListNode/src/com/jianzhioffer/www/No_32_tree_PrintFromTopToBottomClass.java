package com.jianzhioffer.www;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No_32_tree_PrintFromTopToBottomClass {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> arglist = new ArrayList<>();
    	
    	if (root == null) {
        	return arglist;
        }
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		arglist.add(node.val);
    		
    		if (node.left != null) {
    			queue.add(node.left);
    		}
    		
    		if (node.right != null) {
    			queue.add(node.right);
    		}
    	}
    	
    	return arglist;
    }
}
