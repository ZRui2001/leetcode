package com.programmercarl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: E17
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/12 9:22
 * @Version 1.0
 */
public class E17 {

    char[] charArray;
    List<String> result;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        charArray = new char[digits.length()];
        result = new ArrayList<>();
        int[] digitArray = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            digitArray[i] = digits.charAt(i) - '0';
        }

        HashMap<Integer, char[]> map = new HashMap<>();
        int count = 0;
        for (int i = 2; i < 10; i++) {
            int numChar = i == 7 || i == 9 ? 4 : 3;
            char[] chars = new char[numChar];
            for (int j = 0; j < numChar; j++) {
                chars[j] = (char) ('a' + count);
                count++;
            }
            map.put(i, chars);
        }

        backtracking(digitArray, 0, map);
        return result;
    }

    private void backtracking(int[] digitArray, int index, HashMap<Integer, char[]> map) {
        if (index >= digitArray.length) {
            result.add(new String(charArray));
            return;
        }

        int number = digitArray[index];
        char[] chars = map.get(number);
        for (int i = 0; i < chars.length; i++) {
            charArray[index] = chars[i];
            backtracking(digitArray, index + 1, map);
        }
    }

    @Test
    public void test1(){
        System.out.println(letterCombinations("329"));
    }
}
