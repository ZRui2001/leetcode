package com.programmercarl.sort;

import java.util.ArrayList;

/**
 * ClassName: E164
 * Package: com.programmercarl.sort
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/5/27 17:26
 * @Version 1.0
 */
public class E164_1 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        // 找出数组最大值
        int max = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
        }

        // 基数排序
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        int m = 1;
        while (m <= max) {
            for (int i : nums) {
                buckets[i / m % 10].add(i);
            }
            int k = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (Integer i : bucket) {
                    nums[k++] = i;
                }
                bucket.clear();
            }
            m *= 10;
        }

        // 找最大差值
        int max_gap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max_gap = Math.max(max_gap, nums[i + 1] - nums[i]);
        }
        return max_gap;
    }
}
