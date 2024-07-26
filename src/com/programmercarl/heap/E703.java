package com.programmercarl.heap;

/**
 * ClassName: E703
 * Package: com.programmercarl.heap
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/4/20 15:00
 * @Version 1.0
 */
public class E703 {
    MinHeap heap;

    public E703(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (heap.isFull()) {
            // 比较堆顶元素和新添元素
            if (heap.peek() < val) {
                heap.replace(val);
            }
        } else {
            heap.offer(val);
        }
        return heap.peek();
    }
}
