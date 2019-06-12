package sortAlgorithms;

public class SelectionSortClass {
	
	public void selectionSort(int[] nums) {
		/*
		 * 1.跟输入数组无关，无论如何都要遍历整个数组（外层for循环）
		 * 2.无论如何都要执行交换的逻辑，即交换次数和数组大小是线性关系
		 * 3.索引之前的元素已经有序，且不会再被访问，选取最小值的区域逐渐缩小，从nums.length一直递减到1，总的比较次数为N^2/2
		 * 4.索引处的元素和选出来的最小值进行交换，相等元素的相对顺序会被破坏，由此会造成算法不稳定
		 */
		for (int i = 0; i < nums.length; i++) { //每轮循环完成一个元素的放置，无论如何都要遍历整个数组
			int indexOfMin = i; //
			
			//找出待排序部分的最小值
			for (int j = i + 1; j < nums.length; j++) { //每轮循环找出[i + 1,nums.length]之间的最小值下标             
				if (nums[j] < nums[indexOfMin]) {//由于i在自增，故比较次数从nums.length一直递减到1，总的比较次数为N^2/2
					indexOfMin = j;
				}
			}
			
			//交换下标为i和indexOfMin的值，整个排序将会有N次交换
			//这种交换就会造成算法不稳定
			//如 5 5 1 2 3，第一次循环，会将第一个5和1进行交换，第一个5和第二个5的相对顺序就会变
			int temp = nums[i];
			nums[i] = nums[indexOfMin];
			nums[indexOfMin] = temp;
		}
	}

}
