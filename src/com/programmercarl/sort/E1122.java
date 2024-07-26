package com.programmercarl.sort;

/**
 * ClassName: E1122
 * Package: com.programmercarl.sort
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/5/25 14:44
 * @Version 1.0
 */
public class E1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        // 遍历arr1，记录各元素的出现次数
        int[] count = new int[1001];
        for (int val : arr1) {
            count[val] += 1;
        }
        // 按arr2的顺序、count中的次数填入数据
        int i = 0;
        for (int val : arr2) {
            while (count[val] > 0) {
                result[i++] = val;
                count[val]--;
            }
        }
        // 依次填入其他数据
        for (int val = 0; val < count.length; val++) {
            while (count[val] > 0) {
                result[i++] = val;
                count[val]--;
            }
        }
        return result;
    }
}
