package com.programmercarl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: E93
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/14 9:22
 * @Version 1.0
 */
public class E93 {

    StringBuilder IP;
    // 记录IP有多少段
    int count;
    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return new ArrayList<>();
        }
        IP = new StringBuilder();
        count = 0;
        result = new ArrayList<>();
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int start) {
        if (start >= s.length()) {
            return;
        }
        if (count == 3) {
            // 剩余数字直接作为第4段IP
            if (isValid(s, start, s.length() - 1)) {
                // IP合法
                result.add(IP.toString() + s.substring(start));
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!isValid(s, start, i)) {
                break;
            }

            String substring = s.substring(start, i + 1);
            IP.append(substring);
            IP.append('.');
            count++;
            backtracking(s, i + 1);
            count--;
            IP.deleteCharAt(IP.length() - 1);
            IP.delete(IP.length() - substring.length(), IP.length());
        }
    }

    // [start, end]
    private boolean isValid(String s, int start, int end) {
        if (start > end || end - start >= 3) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int value = Integer.parseInt(s.substring(start, end + 1));
        return value <= 255;
    }

    @Test
    public void test1() {
        restoreIpAddresses("25525511135");
    }
}
