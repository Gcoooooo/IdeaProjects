package sortAlgorithms;

public class QuickSortClass {
	
	public void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	
    public void quickSort(int[] nums, int lo, int hi) {
		if (lo >= hi) {
			return ; //��ֹ����
		}
		
		int divideIndex = partition(nums, lo, hi);
		
		quickSort(nums, lo, divideIndex);
		quickSort(nums, divideIndex + 1, hi);
	}
	
	private int partition(int[] nums, int lo, int hi) {
		int baseIndex = lo;
		int base = nums[baseIndex]; //��a[lo]Ϊ��׼��С�ķ�������ߣ���ķ������ұ�

		String
		
		lo = lo + 1; //��lo֮��ʼ������loʼ��ָ��
		
		while (lo <= hi) {
			while (lo <= hi && nums[lo] <= base) { //ֱ���ҵ���v���
				lo++;
			}
			
			while (lo <= hi && nums[hi] >= base) { //ֱ���ҵ���vС��
				hi--;
			}
			
			if (lo <= hi) {
				int temp = nums[lo];
				nums[lo] = nums[hi];
				nums[hi] = temp;
			}
		}
		
		int temp = nums[hi]; //��׼ֵ��hiλ�õ�ֵ����λ�ã���ʱ��base��Ϊ�ֽ���
		nums[hi] = base;
		nums[baseIndex] = temp;
		
		return hi; //���طֽ����±�
	}
	
	
}
