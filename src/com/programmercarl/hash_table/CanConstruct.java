package com.programmercarl.hash_table;

/**
 * ClassName: CanConstruct
 * Package: com.programmercarl.hash_table
 * Description:
         * 383.赎金信
         * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
         * 如果可以，返回 true ；否则返回 false 。
         * magazine 中的每个字符只能在 ransomNote 中使用一次。

         * 示例 1：
         * 输入：ransomNote = "a", magazine = "b"
         * 输出：false
         * 示例 2：
         * 输入：ransomNote = "aa", magazine = "ab"
         * 输出：false
         * 示例 3：
         * 输入：ransomNote = "aa", magazine = "aab"
         * 输出：true

         * 提示：
         * 1 <= ransomNote.length, magazine.length <= 105
         * ransomNote 和 magazine 由小写英文字母组成
 * @Author Zhirui Zhao
 * @Create 2024/3/12 13:25
 * @Version 1.0
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
//        // 把magazine中的字符存入map，key为字符，value为数量
//        Map<Character, Integer> map = new HashMap<>();
//        char[] magazineChars = magazine.toCharArray();
//        for (Character c : magazineChars) {
//            int count = map.getOrDefault(c, 0);
//            map.put(c, count + 1);
//        }
//
//        // 遍历ransomNote，同时查询map，若存在对应的key，则value-1
//        char[] ransomNoteChars = ransomNote.toCharArray();
//        for (Character c : ransomNoteChars) {
//            int value = map.getOrDefault(c, 0);
//            if (value == 0) {
//                return false;
//            }
//            map.put(c, value - 1);
//        }
//
//        return true;
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // 记录字母出现次数
        int[] record = new int[26];

        // 遍历magazine
        for (Character c : magazine.toCharArray()) {
            ++record[c - 'a'];
        }

        // 遍历ransomNOte
        for (Character c : ransomNote.toCharArray()) {
            if (--record[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
