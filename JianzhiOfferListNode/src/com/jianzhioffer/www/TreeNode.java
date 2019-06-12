package com.jianzhioffer.www;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
    
    // �������Ľڵ�
    public static void visit(TreeNode node) {
        System.out.println(node.val);
    }
    
    /** 
     * �ݹ�ʵ�ֶ��������������
     */
    public static void preOrder(TreeNode node) {
        if (node != null) {
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /** 
     * �ݹ�ʵ�ֶ�������������� 
     */
    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }

    /** 
     * �ݹ�ʵ�ֶ������ĺ������ 
     */
    public static void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }

    /** 
     * �ǵݹ�ʵ�ֶ�������������� 
     */
    public static void iterativePreorder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
            while (!stack.empty()) {
                node = stack.pop();
                // �ȷ��ʽڵ�
                visit(node);
                // �����ӽ��ѹ��ջ
                if (node.right != null) {
                    stack.push(node.right);
                }
                // �����ӽ��ѹ��ջ
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    /** 
     * �ǵݹ�ʵ�ֶ�������������� 
     */
    public static void iterativeInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            // �ѵ�ǰ�ڵ����������ӽ��ѹ��ջ
            while (node != null) {
                stack.push(node); //����ջ������ڵ�
                node = node.left; //����������ڵ㣬ֱ��Ҷ�ӽڵ�
            }
            // ���ʽڵ㣬����ýڵ��������
            if (stack.size() > 0) {
                node = stack.pop(); //��ջջ���Ľڵ�
                visit(node); //������ڵ㣬��ڵ�����ѹ�ŵľ�������ڵ�
                node = node.right; //�����ҽڵ�
            }
        }
    }

    /** 
     * �ǵݹ�ʹ�õ�ջʵ�ֶ������������
     */
    public static void iterativePostOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        // ���ʸ��ڵ�ʱ�ж����������ǹ������ʹ�
        TreeNode preNode = null;
        while (node != null || stack.size() > 0) {
            // �ѵ�ǰ�ڵ�����ڵ�ȫ����ջ
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
            	TreeNode temp = stack.peek().right;
                // һ�����ڵ㱻���ʵ�ǰ���ǣ������������������ѱ����ʹ�
                if (temp == null || temp == preNode) {
                    node = stack.pop();
                    visit(node);
                    preNode = node;// ��¼�ձ����ʹ��Ľڵ�
                    node = null;
                } else {
                    // ����������
                    node = temp;
                }
            }
        }
    }

    /** 
     * �ǵݹ�ʹ��˫ջʵ�ֶ������������
     */
    public static void iterativePostOrderByTwoStacks(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            // �ѵ�ǰ�ڵ�����Ҳ��ӽ������ջ
            while (node != null) {
                stack.push(node);
                temp.push(node);
                node = node.right;
            }
            // ����ջ���ڵ��������
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.left;
            }
        }
        while (temp.size() > 0) {
            node = temp.pop();
            visit(node);
        }
    }

    /** 
     * ������������ȱ��������������
     */
    public static void layerTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
            	TreeNode currentNode = queue.poll();
                visit(currentNode);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }

            }
        }
    }

}
