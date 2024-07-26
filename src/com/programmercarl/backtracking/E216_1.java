package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: E216_1
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/11 16:19
 * @Version 1.0
 */
public class E216_1 {
    int sum;
    List<Integer> path;
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        sum = 0;
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(k, n, 1);
        return result;
    }

    private void backtracking(int k, int n, int start) {
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        if ((2 * (path.size() == 0 ? 0 : path.get(path.size() - 1))
                + k - path.size() + 1) / 2 * (k - path.size()) > n - sum) {
            return;
        }

        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(k, n, i + 1);
            sum -= i;
            path.remove(path.size() - 1);
        }
    }
}
