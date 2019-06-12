package sortAlgorithms;

public class HeapSortClass {

	public void swim(int[] nums, int k) {
		while (k > 1) {
			if (nums[k] < nums[k / 2]) { //当子节点nums[k]的值大于其父节点nums[k / 2]
				int temp = nums[k / 2];
				nums[k / 2] = nums[k];
				nums[k] = temp;
			}
		}
	}
	
	public void sink(int[] nums, int k) {
		int N = nums.length;
		while (2 * k < N) {
			int maxChildIndex = nums[2 * k] >= nums[2 * k + 1] ? 2 * k : 2 * k + 1; //取出子节点中较大者
			
			if (nums[k] > nums[maxChildIndex]) { //若较大者也小于
				break;
			} else { //否则，下沉
				int temp = nums[k];
				nums[k] = nums[maxChildIndex];
				nums[maxChildIndex] = temp;
			}		
		}
	}
}
