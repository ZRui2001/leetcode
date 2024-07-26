package com.programmercarl.stack_and_queue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: MaxSlidingWindow
 * Package: com.programmercarl.stack_and_queue
 * Description:
         * 239.滑动窗口最大值
         * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
         * 返回 滑动窗口中的最大值 。

         * 示例 1：
         * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
         * 输出：[3,3,5,5,6,7]
         * 解释：
         * 滑动窗口的位置                最大值
         * ---------------               -----
         * [1  3  -1] -3  5  3  6  7       3
         *  1 [3  -1  -3] 5  3  6  7       3
         *  1  3 [-1  -3  5] 3  6  7       5
         *  1  3  -1 [-3  5  3] 6  7       5
         *  1  3  -1  -3 [5  3  6] 7       6
         *  1  3  -1  -3  5 [3  6  7]      7
         * 示例 2：
         * 输入：nums = [1], k = 1
         * 输出：[1]

         * 提示：
         * 1 <= nums.length <= 105
         * -104 <= nums[i] <= 104
         * 1 <= k <= nums.length
 * @Author Zhirui Zhao
 * @Create 2024/3/23 14:13
 * @Version 1.0
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 存放结果
        int[] res = new int[nums.length - k + 1];
        // 单调队列，队列中元素从大到小排列
        ArrayDeque<Integer> window = new ArrayDeque<>();

        // i指向窗口末端
        for (int i = 0; i < nums.length; i++) {
            /*旧元素出队*/
            if (i >= k && window.peek() == nums[i - k]) {
                window.poll();
            }

            /*新元素入队*/
            // 队列为空，入队
            if (window.isEmpty()) {
                window.offer(nums[i]);
            } else if (nums[i] > window.peek()) {
                // nums[i]大于队首元素，清空队列后入队
                window.clear();
                window.offer(nums[i]);
            } else if (nums[i] <= window.peekLast()) {
                // nums[i]小于队尾元素，入队
                window.offer(nums[i]);
            } else if (nums[i] > window.peekLast()) {
                // nums[i]大于队尾元素，移除所有小于nums[i]的队尾元素后入队
                while (!window.isEmpty() && nums[i] > window.peekLast()) {
                    window.pollLast();
                }
                window.offer(nums[i]);
            }

            // 记录窗口最大值
            if (i >= k - 1) {
                res[i - k + 1] = window.peek();
            }
        }
        return res;
    }

    //解法一
//自定义数组
class MyQueue {
    Deque<Integer> deque = new LinkedList<>();
    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    //同时判断队列当前是否为空
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }
    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //保证队列元素单调递减
    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }
    //队列队顶元素始终为最大值
    int peek() {
        return deque.peek();
    }
}

class Solution0 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];
        int num = 0;
        //自定义队列
        MyQueue myQueue = new MyQueue();
        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }
}

//解法二
//利用双端队列手动实现单调队列
/**
 * 用一个单调队列来存储对应的下标，每当窗口滑动的时候，直接取队列的头部指针对应的值放入结果集即可
 * 单调队列类似 （tail -->） 3 --> 2 --> 1 --> 0 (--> head) (右边为头结点，元素存的是下标)
 */
class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
    @Test
    public void test0(){
        System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
