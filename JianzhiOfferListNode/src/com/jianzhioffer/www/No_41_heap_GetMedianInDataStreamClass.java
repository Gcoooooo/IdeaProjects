package com.jianzhioffer.www;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No_41_heap_GetMedianInDataStreamClass {
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1); //o1 < o2����1����֮����-1
		}
		
	});
	private int count = 0; //�������
	
    public void Insert(Integer num) {
        count++;
        //��Ҫ��֤�����е�����С����С���е�����
        if (count % 2 != 0) { //����ʱ���ݵ�����ĿΪ��������ʱ�������ѣ���Ϊ�˱������������ݴ�����С���е�����
        	                  //��ʱ�Ȳ��뵽��С�ѣ�Ȼ�����С����ȡ���Ѷ�Ԫ�أ�minData�����ٲ��뵽����
        	minHeap.offer(num);
        	maxHeap.offer(minHeap.poll());
        } else { //����ʱ��������ĿΪż������ʱ������С�ѣ���Ϊ�˱�������������С�������е�����
        	     //��ʱ�Ȳ��뵽���ѣ�Ȼ���������ȡ���Ѷ�Ԫ�أ�maxData�����ٲ��뵽��С�ѣ���Ϳ��Ա�֤��С���е�����ʼ�մ��������е�����
        	maxHeap.offer(num);
        	minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if (count % 2 != 0) { //����������Ԫ�أ������������������ѣ�ż��������С�ѣ���ʱ���ѻ�����һ��Ԫ�أ�����ʱ���ѵĶѶ�ΪĿ��ֵ
        	return (double)maxHeap.poll();
        } else {
        	return ((double)minHeap.poll() + (double)maxHeap.poll()) / 2.0d;
        }
    }
}
