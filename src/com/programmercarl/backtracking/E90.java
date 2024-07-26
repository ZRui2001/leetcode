package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: E90
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/16 9:20
 * @Version 1.0
 */
public class E90 {

    List<List<Integer>> result;
    List<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    void backtracking(int[] nums, int start) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
