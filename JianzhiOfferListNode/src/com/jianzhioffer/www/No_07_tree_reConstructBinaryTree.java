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

		TreeNode root = new TreeNode(pre[preStart]); // ǰ�������ָ����ָ�ڵ���Ǹ��ڵ�

		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == pre[preStart]) { // ������������ҵ���ǰ�����startָ��ָ���Ԫ�أ���Ԫ����߾������������ұ߾���������
											// ��i - inStart������������Ԫ�ظ�����
				root.left = reConstructBinaryTree(pre, preStart + 1, preStart + (i - inStart), in, inStart, i - 1);
				root.right = reConstructBinaryTree(pre, preStart + (i - inStart) + 1, preEnd, in, i + 1, inEnd);
				break;
			}
		}

		return root;
	}
}
