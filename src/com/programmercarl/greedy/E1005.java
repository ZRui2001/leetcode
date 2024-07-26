package com.programmercarl.greedy;

import java.util.stream.IntStream;

/**
 * ClassName: E1005
 * Package: com.programmercarl.greedy
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/23 9:06
 * @Version 1.0
 */
public class E1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //从前向后遍历，遇到负数将其变为正数，同时K--
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        // 如果K还大于0，那么反复转变数值最小的元素，将K用完
        if (k % 2 == 1) {
            sum -= 2 * nums[nums.length - 1];
        }
        return sum;

    }
//    public int largestSumAfterKNegations(int[] nums, int k) {
//        Arrays.sort(nums);
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (k > 0) {
//                if (nums[i] < 0) {
//                    nums[i] = -nums[i];
//                    k--;
//                } else if (nums[i] == 0) {
//                    k = 0;
//                } else {
//                    // nums[i] > 0
//                    if (k % 2 == 1) {
//                        // 必须要有一个负数，比较 nums[i - 1] 和 nums[i]，挑小的为负
//                        if (i == 0 || nums[i - 1] >= nums[i]) {
//                            nums[i] = -nums[i];
//                        } else {
//                            // 令 nums[i - 1] 为负
//                            sum -= 2 * nums[i - 1];
//                        }
//                    }
//                    // 在第一个正数或最后一个负数反复跳转
//                    k = 0;
//                }
//            }
//            sum += nums[i];
//        }
//        // k > nums.length 且数组全为负数
//        if (k > 0 && k % 2 == 1) {
//            sum -= 2 * nums[nums.length - 1];
//        }
//        return sum;
//    }
}
