package com.jianzhioffer.www;

import java.util.ArrayList;
import java.util.Stack;

public class No_28_tree_isSymmetricalClass {
    public boolean isSymmetrical(TreeNode pRoot) {
    	ArrayList<Integer> list1 = iterativePreorder(pRoot);
    	ArrayList<Integer> list2 = iterativeSymmetricalPreorder(pRoot);
    	
    	if (list1.size() != list2.size()) {
    		return false;
    	} else {
    		for (int i = 0; i < list1.size(); i++) {
    			if (list1.get(i) == list2.get(i)) {
    				continue;
    			} else {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    public ArrayList<Integer> iterativePreorder(TreeNode pRoot) {
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	if (pRoot == null) {
    		return list;
    	}
    	
    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(pRoot);
    	
    	while (!stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		list.add(node.val);
    		
    		if (node.right != null) {
    			stack.push(node.right);
    		}
    		
    		if (node.right == null && node.left != null) {
    			stack.push(null);
    		}
    		
    		if (node.left != null) {
    			stack.push(node.left);
    		}
    		
    		if (node.right != null && node.left == null) {
    			stack.push(null);
    		}
    		
    		if (node.left == null && node.right == null) {
    			stack.push(null);
    			stack.push(null);
    		}
    	}
    	
    	return list;
    }
    
    public ArrayList<Integer> iterativeSymmetricalPreorder(TreeNode pRoot) {
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	if (pRoot == null) {
    		return list;
    	}
    	
    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(pRoot);
    	
    	while (!stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		list.add(node.val);

    		if (node.left != null) {
    			stack.push(node.left);
    		}
    		
    		if (node.right != null && node.left == null) {
    			stack.push(null);
    		}
    		
    		if (node.right != null) {
    			stack.push(node.right);
    		}
    		
    		if (node.right == null && node.left != null) {
    			stack.push(null);
    		}
    		
    		if (node.left == null && node.right == null) {
    			stack.push(null);
    			stack.push(null);
    		}
    		
    		
    	}
    	
    	return list;
    }
}
