package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: E78
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/15 17:27
 * @Version 1.0
 */
public class E78 {

    List<List<Integer>> result;
    List<Integer> subset;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        subset = new ArrayList<>();
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int start) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtracking(nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
