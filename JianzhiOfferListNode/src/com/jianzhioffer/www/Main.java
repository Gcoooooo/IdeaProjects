package com.jianzhioffer.www;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;

public class Main {
	public static void main(String[] args) throws UnsupportedEncodingException {
//		ListNode head = new ListNode(1);
//		ListNode l1 = new ListNode(2);
//		ListNode l2 = new ListNode(3);
//		ListNode l3 = new ListNode(4);
//		ListNode l4 = new ListNode(5);
//		ListNode l5 = new ListNode(6);
//		ListNode l6 = new ListNode(7);
//		ListNode l7 = new ListNode(8);
//		ListNode copyHead = head;
		
		RandomListNode head = new RandomListNode(1);
		RandomListNode l1 = new RandomListNode(2);
		RandomListNode l2 = new RandomListNode(3);
		RandomListNode l3 = new RandomListNode(4);
		RandomListNode l4 = new RandomListNode(5);
		RandomListNode l5 = new RandomListNode(6);
		RandomListNode l6 = new RandomListNode(7);
		RandomListNode l7 = new RandomListNode(8);
		RandomListNode copyHead = head;
		
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = null;
		
		l2.random = l5;
		
		TreeNode root = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(2);
//		TreeNode t7 = new TreeNode(7);
//		TreeNode t8 = new TreeNode(8);
//		TreeNode t9 = new TreeNode(9);
//		TreeNode t10 = new TreeNode(10);
//		TreeNode t11 = new TreeNode(11);
//		TreeNode t12 = new TreeNode(12);
//		TreeNode t13 = new TreeNode(13);
//		TreeNode t14 = new TreeNode(14);
		
		root.left = t1;
		root.right = t2;
		
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		t2.right = t6;
//		t3.left = t7;
//		t3.right = t8;
//		t4.left = t9;
//		t4.right = t10;
//		t5.left = t11;
//		t5.right = t12;
//		t6.left = t13;
//		t6.right = t14;
		
		No_03_array_DuplicateInArray dia = new No_03_array_DuplicateInArray();
		No_10_FibonacciClass fbc = new No_10_FibonacciClass();
		No_16_math_PowerClass powerClass = new No_16_math_PowerClass();
		No_18_listnode_DeletListNodeClass dlnc = new No_18_listnode_DeletListNodeClass();
		No_18_listnode_DeleteDuplicationClass ddc = new No_18_listnode_DeleteDuplicationClass();
		No_21_array_ReOrderArrayClass roac = new No_21_array_ReOrderArrayClass();
		No_22_listnode_FindKthToTailClass fkttc = new No_22_listnode_FindKthToTailClass();
		No_23_listnode_EntryNodeOfLoopClass enolc = new No_23_listnode_EntryNodeOfLoopClass();
		No_27_tree_MirrorOfBinaryTreeClass mobrc = new No_27_tree_MirrorOfBinaryTreeClass();
		No_32_tree_PrintBinaryTreeColByColClass ptcbc = new No_32_tree_PrintBinaryTreeColByColClass();
		No_32_tree_PrintBinaryTreeByZShape ptbz = new No_32_tree_PrintBinaryTreeByZShape();
		No_28_tree_isSymmetricalClass issc = new No_28_tree_isSymmetricalClass();
		No_35_listnode_RandomListNodeCloneClass rlncc = new No_35_listnode_RandomListNodeCloneClass();
		No_39_sort_MoreThanHalfNum mthn = new No_39_sort_MoreThanHalfNum();
		No_44_math_NthDigitClass ndc = new No_44_math_NthDigitClass();
		No_41_heap_GetMedianInDataStreamClass gmidc = new No_41_heap_GetMedianInDataStreamClass();
		No_53_search_GetNumberOfKInSortedArray gnkisa = new No_53_search_GetNumberOfKInSortedArray();
		No_53_search_MissingNum mnc = new No_53_search_MissingNum();
		No_53_search_GetNumberSameAsIndex gnsai = new No_53_search_GetNumberSameAsIndex();
		No_38_string_PermutationClass pc = new No_38_string_PermutationClass();
		No_56_bit_FindNumsAppearOnce2 fnao2 = new No_56_bit_FindNumsAppearOnce2();
		No_57_array_FindContinuousSequence fcs = new No_57_array_FindContinuousSequence();
		No_49_math_UglyNumber un = new No_49_math_UglyNumber();
		No_51_sort_InversePairs ip = new No_51_sort_InversePairs();
		No_11_array_minNumberInRotateArray mnira = new No_11_array_minNumberInRotateArray();
		No_20_string_isNumeric in = new No_20_string_isNumeric();
		
		String str = "abc";
		
//		ArrayList<ArrayList<Integer>> arrayLists = ptbz.Print(root);
		
//		System.out.println(issc.isSymmetrical(root));
		
//		mobrc.Mirror(root);
		
//		TreeNode.iterativePostOrder(root);
		
//		ListNode node = enolc.EntryNodeOfLoop(head);
//		
//		System.out.println(ndc.findNthDigit(2147483647));
		
		int[] nums = {3,2};
		//123.45e+6
		char[] cs = {'1','2','3','.','4','5','e','+','6'};
		
		System.out.println(in.isNumeric(cs));
		
//		gmidc.Insert(5);
//		gmidc.Insert(2);
//		gmidc.Insert(3);
//		gmidc.Insert(4);
//		gmidc.Insert(1);
//		gmidc.Insert(6);
//		gmidc.Insert(7);
//		gmidc.Insert(0);
//		gmidc.Insert(8);
		
//		System.out.println(gmidc.GetMedian());
		
//		int[] nums = {-1,3,3,-2,5};
		
//		roac.reOrderArray(nums);
//		
//		for (int i = 0; i < nums.length; i++) {
//			System.out.println(nums[i]);
//		}

//		dlnc.DeletNode(head, head);
		
		
//		copyHead = rlncc.Clone(head);
		
//		System.out.println(copyHead.val);
//		
//		while (copyHead != null) {
//			System.out.print(copyHead.label + " ");
//			copyHead = copyHead.next;
//		}
	
	}
}
