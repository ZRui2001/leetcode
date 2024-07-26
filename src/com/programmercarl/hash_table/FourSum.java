package com.programmercarl.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: FourSumn
 * Package: com.programmercarl.hash_table
 * Description:
         * 18.四数之和
         * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
         * 0 <= a, b, c, d < n
         * a、b、c 和 d 互不相同
         * nums[a] + nums[b] + nums[c] + nums[d] == target
         * 你可以按 任意顺序 返回答案 。

         * 示例 1：
         * 输入：nums = [1,0,-1,0,-2,2], target = 0
         * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
         * 示例 2：
         * 输入：nums = [2,2,2,2,2], target = 8
         * 输出：[[2,2,2,2]]

         * 提示：
         * 1 <= nums.length <= 200
         * -10^9 <= nums[i] <= 10^9
         * -10^9 <= target <= 10^9
 * @Author Zhirui Zhao
 * @Create 2024/3/12 15:40
 * @Version 1.0
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // 对数组排序
        Arrays.sort(nums);

        // 设四元组为（nums[i], nums[left], nums[right], nums[j]），由小到大排序
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0 && nums[i] > target) {
                return ans;
            }

            // 去重nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = nums.length - 1; j > i; j--) {
                // 去重nums[j]
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }

                // 双指针遍历nums[b]和nums[c]
                int left = i + 1;
                int right = j - 1;
                while (left < right) {
                    // int会溢出
                    long sum = (long) nums[i] + nums[left] + nums[right] + nums[j];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else { // sum == target
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                        // 找到一个解后，对nums[left], nums[right]去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
