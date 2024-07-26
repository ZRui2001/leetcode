package com.programmercarl.array;

/**
 * ClassName: E88
 * Package: com.programmercarl.array
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/4/24 16:11
 * @Version 1.0
 */
public class E88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        // k指向a2空位
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            // 双指针同时遍历2个区间
            if (nums1[i] <= nums2[j]) {
                res[k] = nums1[i];
                i++;
                k++;
            } else {
                res[k] = nums2[j];
                j++;
                k++;
            }
        }
        // 其中至少一个区间遍历完毕
        if (i >= m) {
            // 区间1遍历完毕
            System.arraycopy(nums2, j, res, k, n - j);
        }
        if (j >= n) {
            // 区间2遍历完毕
            System.arraycopy(nums1, i, res, k, m - i);
        }
        System.arraycopy(res, 0, nums1, 0, m + n);
    }
}
