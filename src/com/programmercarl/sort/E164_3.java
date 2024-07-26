package com.programmercarl.sort;

/**
 * ClassName: E164_3
 * Package: com.programmercarl.sort
 * Description:
 * 不进行桶内排序，计算桶间间距，即上一个桶的最大值-下一个桶的最小值
 * 在有空桶的情况下，桶内元素的最大间距一定小于桶间的最大间距。可以人为设置桶的数量=数组长度+1，以保证有空桶。
 * @Author Zhirui Zhao
 * @Create 2024/5/29 14:42
 * @Version 1.0
 */
public class E164_3 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        // 找出数组最值
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        // 桶排序
        // 1. 准备桶，桶的数量=数组长度+1
        int range = Math.max(1, (max - min) / nums.length);
        Pair[] buckets = new Pair[(max - min) / range + 1];
        // 2. 放入数据
        for (int i : nums) {
            int idx = (i - min) / range;
            if (buckets[idx] == null) {
                buckets[idx] = new Pair();
            }
            buckets[idx].add(i);
        }

        // 找最大差值
        int maxGap = 0;
        int lastMax = buckets[0].max;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] != null) {
                maxGap = Math.max(maxGap, buckets[i].min - lastMax);
                lastMax = buckets[i].max;
            }
        }
        return maxGap;
    }

    class Pair {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        void add(int x) {
            min = Integer.min(min, x);
            max = Integer.max(max, x);
        }
    }
}
