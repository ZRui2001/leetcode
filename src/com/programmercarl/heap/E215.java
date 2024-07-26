package com.programmercarl.heap;


/**
 * ClassName: E215
 * Package: com.programmercarl.heap
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/4/16 22:49
 * @Version 1.0
 */
public class E215 {
    /* 小顶堆法 */
    public int findKthLargest(int[] nums, int k) {
        int[] minHeap = new int[k];
        for (int i = 0; i < k; i++) {
            minHeap[i] = nums[i];
        }

        // 建堆
        minHeapify(minHeap);

        // 处理数组剩下元素
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap[0]) {
                minHeap[0] = nums[i];
                minHeapify(minHeap);
            }
        }
        return minHeap[0];
    }

    private void minHeapify(int[] array) {
        int index = (array.length - 1) / 2;
        while (index >= 0) {
            down(array, index);
            index--;
        }
    }

    private void down(int[] minHeap, int index) {
        int left = index * 2 + 1;
        int right = left + 1;
        if (left < minHeap.length && minHeap[left] < minHeap[index]) {
            swap(minHeap, left, index);
        }
        if (right < minHeap.length && minHeap[right] < minHeap[index]) {
            swap(minHeap, right, index);
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
