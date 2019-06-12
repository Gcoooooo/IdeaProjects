package com.jianzhioffer.www;

import org.w3c.dom.Node;

public class No_27_tree_MirrorOfBinaryTreeClass {
    public void Mirror(TreeNode root) {
        if (root == null) {
        	return ;
        }
        
        if (root.left == null && root.right == null) {
        	return ;
        }
        
        int val = root.val;
        
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        
        if (root.left != null) {
        	Mirror(root.left);
        }
        
        if (root.right != null) {
        	Mirror(root.right);
        }
    }
}
