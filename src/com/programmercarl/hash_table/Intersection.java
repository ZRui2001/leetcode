package com.programmercarl.hash_table;

import org.junit.Test;

import java.util.HashSet;

/**
 * ClassName: Intersection
 * Package: com.programmercarl.hash_table
 * Description:
 * 349
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。

 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的

 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * @Author Zhirui Zhao
 * @Create 2024/3/7 16:37
 * @Version 1.0
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();
        // 遍历数组1放进Hashset
        for (Integer num : nums1){
            set1.add(num);
        }
        // 遍历数组2，同时判断是否与数组1存在相同元素，放入结果集合
        for (Integer num : nums2){
            if (set1.contains(num)){
                intersectionSet.add(num);
            }
        }

        // 把intersectionSet转为数组
        int[] res = new int[intersectionSet.size()];
        int i = 0;
        for (Integer element : intersectionSet) {
            res[i++] = element;
        }

        return res;
    }

    @Test
    public void test0(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = intersection(nums1, nums2);
    }
}
