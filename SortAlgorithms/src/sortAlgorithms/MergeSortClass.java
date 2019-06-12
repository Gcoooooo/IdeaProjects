package sortAlgorithms;

public class MergeSortClass {
	int[] aux;
	
	public void mergeSort(int[] nums) {
		aux = new int[nums.length];
		mergeSort(nums, 0, nums.length - 1);
	}
	
    public void mergeSort(int[] nums, int low, int high) {
		if (low >= high) { //终止条件
			return ;
		}
		int mid = low + (high - low) / 2;
		
		mergeSort(nums, low, mid);
		mergeSort(nums, mid + 1, high);
		
		merge(nums, low, mid, high);	
	}
	
	public void merge(int[] nums, int low, int mid, int high) { //创建辅助数组并将其分成两半，将两半进行合并后将元素放入原数组中
		int i = low;
		int j = mid + 1; //将[low, high]分成两半，对两半进行合并
		int cur = low;
		
		for (int k = low; k <= high; k++) { //将待排序数组复制到辅助数组
			aux[k] = nums[k];
		}
		
		while (i <= mid && j <= high) {
			if (aux[i] <= aux[j]) { //当前半部分的元素小于后半部分的元素
				nums[cur++] = aux[i++];
			} else if (aux[i] > aux[j]) { //当后半部分的元素小于前半部分的元素
				nums[cur++] = aux[j++];
			}
		}
		
		while (i <= mid) { //前半部分还有剩余
			nums[cur++] = aux[i++];
		}
		
		while (j <= high) { //后半部分还有剩余
			nums[cur++] = aux[j++];
		}
	}
}
