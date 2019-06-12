package com.jianzhioffer.www;

public class No_53_search_GetNumberOfKInSortedArray {
    public int GetNumberOfK(int [] array , int k) {
        return GetIndexOfLastK(array, k) - GetIndexOfFirstK(array, k) + 1;
     }
     
     public int GetIndexOfFirstK(int[] array, int k) {
         int lo = 0;
         int hi = array.length - 1;
         
         while (lo <= hi) {
             int mid = lo + (hi - lo) / 2;
             if (array[mid] > k) {
                 hi = mid - 1;
             } else if (array[mid] < k) {
                 lo = mid + 1;
             } else {
                 if (mid - 1 >= 0 && array[mid - 1] == k) {
                     hi = mid - 1;
                 } else {
                     return mid;
                 }
             }
         }
         
         return -1;
     }
     
     public int GetIndexOfLastK(int[] array, int k) {
         int lo = 0;
         int hi = array.length - 1;
         
         while (lo <= hi) {
             int mid = lo + (hi - lo) / 2;
             if (array[mid] > k) {
                 hi = mid - 1;
             } else if (array[mid] < k) {
                 lo = mid + 1;
             } else {
                 if (mid + 1 < array.length && array[mid + 1] == k) {
                     lo = mid + 1;
                 } else {
                     return mid;
                 }
             }
         }
         
         return -1;
     }
}
