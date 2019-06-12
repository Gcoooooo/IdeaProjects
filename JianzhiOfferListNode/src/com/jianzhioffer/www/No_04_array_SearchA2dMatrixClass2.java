package com.jianzhioffer.www;

public class No_04_array_SearchA2dMatrixClass2 {
	public boolean Find(int target, int [][] array) {
        
		 /*
		  * ������ĿҪ��ľ��������¹��ɣ�
		  * # # # # A
		  * # # # # #
		  * # # # # #
		  * B # # # #
		  * A�����е��������Ԫ�ض�С��A��A�����е��±�����Ԫ�ض�����A
		  * B�����е��ұ�����Ԫ�ض�����B��B�����е��ϱ�����Ԫ�ض�С��B
		  * 
		  * ˼�룺
		  * ÿ�δӾ���ʣ�ಿ�ֵ����Ͻǿ�ʼ, 
		  * �Ƚ�target �� matrix[i][j]��ֵ. ���С��target, ����в������д���, �ų�����;
		  * �������target, ����в������д���, �ų�����;
		  * �����߽�������þ��󲻺�target.
		  */
		 
		 if (array == null || array.length == 0 || array[0].length == 0) {
			 return false;
		 }
		 
		 int row = 0; //�����Ͻǿ�ʼ
		 int col = array[0].length - 1;
		 
		 while (row < array.length && col >= 0) {
			 int temp = array[row][col]; //ȡ���Ͻǵ�ֵ
			 
			 if (target > temp) { //�ų�temp������
				 row++;
			 } else if (target < temp) { //�ų�temp������
				 col--;
			 } else {
				 return true;
			 }
		 }
		 
		 return false;
		 
		 
	 
   }
}
