package com.programmercarl.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ClassName: E64
 * Package: com.programmercarl.sort
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/5/28 14:44
 * @Version 1.0
 */
public class E164_2 {
    /*
    * 桶排序，桶的数量等于数组长度
    * */
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
        // 1. 准备桶
        int range = Math.max(1, (max - min) / (nums.length - 1));
        ArrayList<Integer>[] buckets = new ArrayList[(max - min) / range + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList();
        }
        // 2. 放入数据
        for (int i : nums) {
            buckets[(i - min) / range].add(i);
        }
        int k = 0;
        for (ArrayList<Integer> bucket : buckets) {
            // 3. 排序桶内元素
            Collections.sort(bucket);
            // 4. 把每个桶排序好的内容，依次放入原始数组
            for (int i : bucket) {
                nums[k++] = i;
            }
        }

        // 找最大差值
        int max_gap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max_gap = Math.max(max_gap, nums[i + 1] - nums[i]);
        }
        return max_gap;
    }
}
