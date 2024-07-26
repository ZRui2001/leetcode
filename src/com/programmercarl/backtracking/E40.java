package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: E40
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/12 11:36
 * @Version 1.0
 */
public class E40 {

    List<Integer> path;
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, candidates.length - 1);
        return result;
    }

    private void backtracking(int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i >= 0; i--) {
            if (i < start && candidates[i] == candidates[i + 1]) {
                continue;
            }
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i - 1);
            path.remove(path.size() - 1);
        }
    }
}
