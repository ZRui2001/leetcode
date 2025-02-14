package com.programmercarl.stack_and_queue;

import java.util.ArrayDeque;

/**
 * ClassName: RemoveDuplicates
 * Package: com.programmercarl.stack_and_queue
 * Description:
         * 1047.删除字符串中的所有相邻重复项
         * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
         * 在 S 上反复执行重复项删除操作，直到无法继续删除。
         * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

         * 示例：
         * 输入："abbaca"
         * 输出："ca"
         * 解释：
         * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

         * 提示：
         * 1 <= S.length <= 20000
         * S 仅由小写英文字母组成。
 * @Author Zhirui Zhao
 * @Create 2024/3/22 12:59
 * @Version 1.0
 */
public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        //参考：https://stackoverflow.com/questions/6163166/why-is-arraydeque-better-than-linkedlist
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < S.length(); i++) {
            ch = S.charAt(i);
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            } else {
                deque.pop();
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }
}
