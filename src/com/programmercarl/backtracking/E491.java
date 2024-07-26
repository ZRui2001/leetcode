package com.programmercarl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: E491
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/16 9:52
 * @Version 1.0
 */
public class E491 {

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

        HashMap<Integer, Boolean> isVisited = new HashMap<>();
        for (int i = start; i < nums.length; i++) {
            if (isVisited.containsKey(nums[i]) && isVisited.get(nums[i])) {
                continue;
            }

            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                isVisited.put(nums[i], true);  // 同层不同值
                backtracking(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test1(){
        findSubsequences(new int[]{4, 6, 7, 7});
    }
}
