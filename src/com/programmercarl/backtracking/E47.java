package com.programmercarl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: E47
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/18 9:11
 * @Version 1.0
 */
public class E47 {

    List<List<Integer>> result;
    List<Integer> path;
    boolean[] verVisited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        verVisited = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return result;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        boolean[] horiVisited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 纵向过滤
            if (verVisited[i]) {
                continue;
            }
            // 横向过滤
            if (i > 0 && nums[i] == nums[i - 1] && horiVisited[i -1]){
                horiVisited[i] = true;
                continue;
            }
            horiVisited[i] = true;
            verVisited[i] = true;
            path.add(nums[i]);
            backtracking(nums);
            path.remove(path.size() - 1);
            verVisited[i] = false;
        }
    }

    @Test
    public void test1(){
        permuteUnique(new int[]{1,1,2}).forEach(System.out::println);
    }
}
