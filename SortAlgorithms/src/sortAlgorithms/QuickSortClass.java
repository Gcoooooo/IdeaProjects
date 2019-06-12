package sortAlgorithms;

public class QuickSortClass {
	
	public void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	
    public void quickSort(int[] nums, int lo, int hi) {
		if (lo >= hi) {
			return ; //终止条件
		}
		
		int divideIndex = partition(nums, lo, hi);
		
		quickSort(nums, lo, divideIndex);
		quickSort(nums, divideIndex + 1, hi);
	}
	
	private int partition(int[] nums, int lo, int hi) {
		int baseIndex = lo;
		int base = nums[baseIndex]; //以a[lo]为标准，小的放在它左边，大的放在它右边

		String
		
		lo = lo + 1; //从lo之后开始操作，lo始终指向
		
		while (lo <= hi) {
			while (lo <= hi && nums[lo] <= base) { //直到找到比v大的
				lo++;
			}
			
			while (lo <= hi && nums[hi] >= base) { //直到找到比v小的
				hi--;
			}
			
			if (lo <= hi) {
				int temp = nums[lo];
				nums[lo] = nums[hi];
				nums[hi] = temp;
			}
		}
		
		int temp = nums[hi]; //基准值和hi位置的值交换位置，此时以base作为分界线
		nums[hi] = base;
		nums[baseIndex] = temp;
		
		return hi; //返回分界点的下标
	}
	
	
}
