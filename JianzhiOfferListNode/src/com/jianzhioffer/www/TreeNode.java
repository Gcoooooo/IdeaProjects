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
    
    // 访问树的节点
    public static void visit(TreeNode node) {
        System.out.println(node.val);
    }
    
    /** 
     * 递归实现二叉树的先序遍历
     */
    public static void preOrder(TreeNode node) {
        if (node != null) {
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /** 
     * 递归实现二叉树的中序遍历 
     */
    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }

    /** 
     * 递归实现二叉树的后序遍历 
     */
    public static void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }

    /** 
     * 非递归实现二叉树的先序遍历 
     */
    public static void iterativePreorder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
            while (!stack.empty()) {
                node = stack.pop();
                // 先访问节点
                visit(node);
                // 把右子结点压入栈
                if (node.right != null) {
                    stack.push(node.right);
                }
                // 把左子结点压入栈
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    /** 
     * 非递归实现二叉树的中序遍历 
     */
    public static void iterativeInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            // 把当前节点的所有左侧子结点压入栈
            while (node != null) {
                stack.push(node); //先入栈这个根节点
                node = node.left; //继续遍历左节点，直至叶子节点
            }
            // 访问节点，处理该节点的右子树
            if (stack.size() > 0) {
                node = stack.pop(); //出栈栈顶的节点
                visit(node); //访问左节点，左节点下面压着的就是其根节点
                node = node.right; //遍历右节点
            }
        }
    }

    /** 
     * 非递归使用单栈实现二叉树后序遍历
     */
    public static void iterativePostOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        // 访问根节点时判断其右子树是够被访问过
        TreeNode preNode = null;
        while (node != null || stack.size() > 0) {
            // 把当前节点的左侧节点全部入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
            	TreeNode temp = stack.peek().right;
                // 一个根节点被访问的前提是：无右子树或右子树已被访问过
                if (temp == null || temp == preNode) {
                    node = stack.pop();
                    visit(node);
                    preNode = node;// 记录刚被访问过的节点
                    node = null;
                } else {
                    // 处理右子树
                    node = temp;
                }
            }
        }
    }

    /** 
     * 非递归使用双栈实现二叉树后序遍历
     */
    public static void iterativePostOrderByTwoStacks(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            // 把当前节点和其右侧子结点推入栈
            while (node != null) {
                stack.push(node);
                temp.push(node);
                node = node.right;
            }
            // 处理栈顶节点的左子树
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
     * 二叉树广度优先遍历——层序遍历
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
