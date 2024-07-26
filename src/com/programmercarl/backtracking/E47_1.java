package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: E47_1
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/18 9:55
 * @Version 1.0
 */
public class E47_1 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 过滤树层
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 过滤树枝
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrack(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
