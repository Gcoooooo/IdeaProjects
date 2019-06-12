package com.jianzhioffer.www;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No_41_heap_GetMedianInDataStreamClass {
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1); //o1 < o2返回1，反之返回-1
		}
		
	});
	private int count = 0; //插入计数
	
    public void Insert(Integer num) {
        count++;
        //需要保证最大堆中的数据小于最小堆中的数据
        if (count % 2 != 0) { //插入时数据的总数目为奇数，此时插入最大堆，但为了避免待插入的数据大于最小堆中的数据
        	                  //此时先插入到最小堆，然后从最小堆中取出堆顶元素（minData），再插入到最大堆
        	minHeap.offer(num);
        	maxHeap.offer(minHeap.poll());
        } else { //插入时数据总数目为偶数，此时插入最小堆，但为了避免待插入的数据小于最大堆中的数据
        	     //此时先插入到最大堆，然后从最大堆中取出堆顶元素（maxData），再插入到最小堆，这就可以保证最小堆中的数据始终大于最大堆中的数据
        	maxHeap.offer(num);
        	minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if (count % 2 != 0) { //若有奇数个元素，并按照奇数插入最大堆，偶数插入最小堆，此时最大堆会多插入一个元素，即此时最大堆的堆顶为目标值
        	return (double)maxHeap.poll();
        } else {
        	return ((double)minHeap.poll() + (double)maxHeap.poll()) / 2.0d;
        }
    }
}
