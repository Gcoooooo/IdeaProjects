package com.jianzhioffer.www;

import java.awt.event.MouseWheelEvent;

public class No_07_tree_reConstructBinaryTree {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length == 0 || in.length == 0) {
			return null;
		}

		TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);

		return root;
	}

	public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(pre[preStart]); // 前序遍历的指针所指节点就是根节点

		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == pre[preStart]) { // 在中序遍历中找到和前序遍历start指针指向的元素，该元素左边就是左子树，右边就是右子树
											// 故i - inStart就是左子树的元素个数，
				root.left = reConstructBinaryTree(pre, preStart + 1, preStart + (i - inStart), in, inStart, i - 1);
				root.right = reConstructBinaryTree(pre, preStart + (i - inStart) + 1, preEnd, in, i + 1, inEnd);
				break;
			}
		}

		return root;
	}
}
