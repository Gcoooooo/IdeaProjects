package sortAlgorithms;

public class MergeSortClass {
	int[] aux;
	
	public void mergeSort(int[] nums) {
		aux = new int[nums.length];
		mergeSort(nums, 0, nums.length - 1);
	}
	
    public void mergeSort(int[] nums, int low, int high) {
		if (low >= high) { //��ֹ����
			return ;
		}
		int mid = low + (high - low) / 2;
		
		mergeSort(nums, low, mid);
		mergeSort(nums, mid + 1, high);
		
		merge(nums, low, mid, high);	
	}
	
	public void merge(int[] nums, int low, int mid, int high) { //�����������鲢����ֳ����룬��������кϲ���Ԫ�ط���ԭ������
		int i = low;
		int j = mid + 1; //��[low, high]�ֳ����룬��������кϲ�
		int cur = low;
		
		for (int k = low; k <= high; k++) { //�����������鸴�Ƶ���������
			aux[k] = nums[k];
		}
		
		while (i <= mid && j <= high) {
			if (aux[i] <= aux[j]) { //��ǰ�벿�ֵ�Ԫ��С�ں�벿�ֵ�Ԫ��
				nums[cur++] = aux[i++];
			} else if (aux[i] > aux[j]) { //����벿�ֵ�Ԫ��С��ǰ�벿�ֵ�Ԫ��
				nums[cur++] = aux[j++];
			}
		}
		
		while (i <= mid) { //ǰ�벿�ֻ���ʣ��
			nums[cur++] = aux[i++];
		}
		
		while (j <= high) { //��벿�ֻ���ʣ��
			nums[cur++] = aux[j++];
		}
	}
}
