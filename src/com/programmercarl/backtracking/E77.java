package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: E77
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/10 10:06
 * @Version 1.0
 */
public class E77 {
    public List<List<Integer>> combine(int n, int k) {

        if (k == n) {
            List<List<Integer>> result = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            result.add(list);
            return result;
        }
        if (k == 1) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                result.add(list);
            }
            return result;
        }

        List<List<Integer>> combWithN = combine(n - 1, k - 1);
        for (List<Integer> l : combWithN) {
            l.add(n);
        }
        List<List<Integer>> combWithoutN = combine(n - 1, k);
        combWithN.addAll(combWithoutN);
        return combWithN;
    }
}
