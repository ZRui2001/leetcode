package com.programmercarl.stack_and_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * ClassName: TopKFrequent
 * Package: com.programmercarl.stack_and_queue
 * Description:
         * 347.前K个高频yuansu
         * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

         * 示例 1:
         * 输入: nums = [1,1,1,2,2,3], k = 2
         * 输出: [1,2]
         * 示例 2:
         * 输入: nums = [1], k = 1
         * 输出: [1]

         * 提示：
         * 1 <= nums.length <= 105
         * k 的取值范围是 [1, 数组中不相同的元素的个数]
         * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的

         * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * @Author Zhirui Zhao
 * @Create 2024/3/24 12:32
 * @Version 1.0
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // map的key为元素，value为出现频率
        for (int n : nums) {
            int value = map.getOrDefault(n, 0) + 1;
            map.put(n, value);
        }

        // 小顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (pq.size() < k) {
                // 队未满，直接入队
                pq.add(new int[]{e.getKey(), e.getValue()});
            } else if (e.getValue() > pq.peek()[1]) {
                // 大于堆顶元素，移除堆顶后入队
                pq.poll();
                pq.add(new int[]{e.getKey(), e.getValue()});
            }
        }

        // 反向取出堆的元素即为答案
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
