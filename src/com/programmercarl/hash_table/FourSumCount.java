package com.programmercarl.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: FourSumCount
 * Package: com.programmercarl.hash_table
 * Description:
     * 454
     * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

     * 示例 1：
     * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
     * 输出：2
     * 解释：
     * 两个元组如下：
     * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
     * 示例 2：
     * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
     * 输出：1

     * 提示：
     * n == nums1.length
     * n == nums2.length
     * n == nums3.length
     * n == nums4.length
     * 1 <= n <= 200
     * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 * @Author Zhirui Zhao
 * @Create 2024/3/12 12:31
 * @Version 1.0
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> recordAB = new HashMap<>();

        // 遍历nums1和nums2,记录2数组求和的结果及其次数
        for (Integer a : nums1) {
            for (Integer b : nums2) {
                int value = recordAB.getOrDefault(a + b, 0);
                recordAB.put(a + b, value + 1);
            }
        }
        // 记录和为0的可能结果数量
        int count = 0;
        // 遍历nums3和nums4
        for (Integer c : nums3) {
            for (Integer d : nums4){
                count += recordAB.getOrDefault(-(c + d), 0);
            }
        }

        return count;
    }
}
