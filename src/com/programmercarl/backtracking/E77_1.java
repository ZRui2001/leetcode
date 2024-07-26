package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: E77_1
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/10 13:29
 * @Version 1.0
 */
public class E77_1 {

    List<Integer> path;
    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        path = new ArrayList<>();
        result = new ArrayList<>();
        backtracking(n, k, 1);
        return result;
    }

    private void backtracking(int n, int k, int start) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
