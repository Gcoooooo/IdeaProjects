package com.jianzhioffer.www;

public class No_04_array_SearchA2dMatrixClass2 {
	public boolean Find(int target, int [][] array) {
        
		 /*
		  * 符合题目要求的矩阵有如下规律：
		  * # # # # A
		  * # # # # #
		  * # # # # #
		  * B # # # #
		  * A所在行的左边其他元素都小于A，A所在列的下边其他元素都大于A
		  * B所在行的右边其他元素都大于B，B所在列的上边其他元素都小于B
		  * 
		  * 思想：
		  * 每次从矩阵剩余部分的右上角开始, 
		  * 比较target 和 matrix[i][j]的值. 如果小于target, 则该行不可能有此数, 排除该行;
		  * 如果大于target, 则该列不可能有此数, 排除该列;
		  * 遇到边界则表明该矩阵不含target.
		  */
		 
		 if (array == null || array.length == 0 || array[0].length == 0) {
			 return false;
		 }
		 
		 int row = 0; //从右上角开始
		 int col = array[0].length - 1;
		 
		 while (row < array.length && col >= 0) {
			 int temp = array[row][col]; //取右上角的值
			 
			 if (target > temp) { //排除temp所在行
				 row++;
			 } else if (target < temp) { //排除temp所在列
				 col--;
			 } else {
				 return true;
			 }
		 }
		 
		 return false;
		 
		 
	 
   }
}
