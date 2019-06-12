package sortAlgorithms;

public class HeapSortClass {

	public void swim(int[] nums, int k) {
		while (k > 1) {
			if (nums[k] < nums[k / 2]) { //���ӽڵ�nums[k]��ֵ�����丸�ڵ�nums[k / 2]
				int temp = nums[k / 2];
				nums[k / 2] = nums[k];
				nums[k] = temp;
			}
		}
	}
	
	public void sink(int[] nums, int k) {
		int N = nums.length;
		while (2 * k < N) {
			int maxChildIndex = nums[2 * k] >= nums[2 * k + 1] ? 2 * k : 2 * k + 1; //ȡ���ӽڵ��нϴ���
			
			if (nums[k] > nums[maxChildIndex]) { //���ϴ���ҲС��
				break;
			} else { //�����³�
				int temp = nums[k];
				nums[k] = nums[maxChildIndex];
				nums[maxChildIndex] = temp;
			}		
		}
	}
}
