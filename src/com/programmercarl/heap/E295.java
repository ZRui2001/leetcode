package com.programmercarl.heap;

/**
 * ClassName: E295
 * Package: com.programmercarl.heap
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/4/20 15:31
 * @Version 1.0
 */
public class E295 {
    Heap left;
    Heap right;

    public E295() {
        // 大顶堆存放较小的一半数
        left = new Heap(10, true);
        // 小顶堆存放较大的一半数
        right = new Heap(10, false);
    }

    public void addNum(int num) {
        if (left.size() == right.size()) {
            // 两个堆大小相等，先加左边
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return left.peek();
    }
}
