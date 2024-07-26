package com.programmercarl.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: E34
 * Package: com.programmercarl.array
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/6/21 18:05
 * @Version 1.0
 */
public class E34 {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int mid = binarySearch("normal", 0, nums.length - 1, nums, target);
        if (mid >= 0) {
            start = binarySearch("leftmost", 0, mid, nums, target);
            end = binarySearch("rightmost", mid, nums.length - 1, nums, target);
        }
        return new int[]{start, end};

    }

    private int binarySearch(String mode, int low, int high, int[] nums, int target) {
        int index = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                // 找到target
                index = mid;
                if (mode.equals("normal")) {
                    return index;
                }
                if (mode.equals("leftmost")) {
                    high = mid - 1;
                }
                if (mode.equals("rightmost")) {
                    low = mid + 1;
                }
            }
        }
        return index;
    }
    
    @Test
    public void test1(){
        System.out.println("hello");
        int[] nums = {5,7,7,8,8,10};
        Arrays.stream(searchRange(nums, 8)).forEach((element)->System.out.println(element));;
    }
}
