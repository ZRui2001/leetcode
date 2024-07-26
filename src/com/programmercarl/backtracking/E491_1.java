package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 用hash数组记录
 */
public class E491_1 {
    List<List<Integer>> result;
    List<Integer> path;

    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();

        backtracking(nums, 0);
        return result;
    }

    void backtracking(int[] nums, int start) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        boolean[] isVisited = new boolean[201];
        for (int i = start; i < nums.length; i++) {
            if (isVisited[nums[i] + 100]) {
                continue;
            }

            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                isVisited[nums[i] + 100] = true;  // 同层不同值
                backtracking(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
