package sortAlgorithms;

public class SelectionSortClass {
	
	public void selectionSort(int[] nums) {
		/*
		 * 1.�����������޹أ�������ζ�Ҫ�����������飨���forѭ����
		 * 2.������ζ�Ҫִ�н������߼��������������������С�����Թ�ϵ
		 * 3.����֮ǰ��Ԫ���Ѿ������Ҳ����ٱ����ʣ�ѡȡ��Сֵ����������С����nums.lengthһֱ�ݼ���1���ܵıȽϴ���ΪN^2/2
		 * 4.��������Ԫ�غ�ѡ��������Сֵ���н��������Ԫ�ص����˳��ᱻ�ƻ����ɴ˻�����㷨���ȶ�
		 */
		for (int i = 0; i < nums.length; i++) { //ÿ��ѭ�����һ��Ԫ�صķ��ã�������ζ�Ҫ������������
			int indexOfMin = i; //
			
			//�ҳ������򲿷ֵ���Сֵ
			for (int j = i + 1; j < nums.length; j++) { //ÿ��ѭ���ҳ�[i + 1,nums.length]֮�����Сֵ�±�             
				if (nums[j] < nums[indexOfMin]) {//����i���������ʱȽϴ�����nums.lengthһֱ�ݼ���1���ܵıȽϴ���ΪN^2/2
					indexOfMin = j;
				}
			}
			
			//�����±�Ϊi��indexOfMin��ֵ���������򽫻���N�ν���
			//���ֽ����ͻ�����㷨���ȶ�
			//�� 5 5 1 2 3����һ��ѭ�����Ὣ��һ��5��1���н�������һ��5�͵ڶ���5�����˳��ͻ��
			int temp = nums[i];
			nums[i] = nums[indexOfMin];
			nums[indexOfMin] = temp;
		}
	}

}
