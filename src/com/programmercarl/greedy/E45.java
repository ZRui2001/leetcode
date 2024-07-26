package com.programmercarl.greedy;

/**
 * ClassName: E45
 * Package: com.programmercarl.greedy
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/22 15:10
 * @Version 1.0
 */
public class E45 {
    public int jump(int[] nums) {
        int border = 0;
        int start = 0;
        int end = 0;
        int times = 0;
        while (true) {
            if (border >= nums.length - 1) {
                // 第 times 步的边界覆盖整个数组
                return times;
            }
            // 遍历第 times 步的范围（不包括前 times - 1 步的范围）
            for (int i = start; i <= end; i++) {
                // 扩充第 times + 1 步的边界
                border = Math.max(border, i + nums[i]);
            }
            // 边界不够大，准备走下一步
            times++;
            start = end + 1;
            end = border;
        }
    }
}
