package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: E131
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/13 9:24
 * @Version 1.0
 */
public class E131 {

    List<List<String>> result;
    List<String> path;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0);
        return result;
    }

    private void backtracking(StringBuilder sb, int start) {

        if (start == sb.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < sb.length(); i++) {
            // 获取[start, i]在s中的子串
            // 判断字串是否为回文
            boolean isLegal = true;
            int left = start;
            int right = i;
            while (left < right) {
                if (sb.charAt(left) != sb.charAt(right)) {
                    isLegal = false;
                    break;
                }
                left++;
                right--;
            }
            if (!isLegal) {
                continue;
            }
            // 不是回文，加入path
            path.add(sb.substring(start, i + 1));
            backtracking(sb, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
