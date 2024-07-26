package com.programmercarl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: E46
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/17 9:06
 * @Version 1.0
 */
public class E46 {

    List<List<Integer>> result;
    List<Integer> path;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        visited = new boolean[nums.length];
        backtracking(nums);
        return result;
    }

    private void backtracking(int[] nums) {
        if (path.size() >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtracking(nums);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
    
    @Test
    public void test1(){
        permute(new int[]{1,2,3});
    }
}
