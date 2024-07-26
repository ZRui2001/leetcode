package com.programmercarl.stack_and_queue;

import java.util.Stack;

/**
 * ClassName: IsValid
 * Package: com.programmercarl.stack_and_queue
 * Description:
         * 20.有效的括号
         * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
         * 有效字符串需满足：
         * 左括号必须用相同类型的右括号闭合。
         * 左括号必须以正确的顺序闭合。
         * 每个右括号都有一个对应的相同类型的左括号。

         * 示例 1：
         * 输入：s = "()"
         * 输出：true
         * 示例 2：
         * 输入：s = "()[]{}"
         * 输出：true
         * 示例 3：
         * 输入：s = "(]"
         * 输出：false

         * 提示：
         * 1 <= s.length <= 104
         * s 仅由括号 '()[]{}' 组成
 * @Author Zhirui Zhao
 * @Create 2024/3/21 22:44
 * @Version 1.0
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    charStack.push(')');
                    break;
                case '[':
                    charStack.push(']');
                    break;
                case '{':
                    charStack.push('}');
                    break;
                case ')':
                    if (charStack.empty()) {
                        return false;
                    } else if (charStack.pop() != ')') {
                        return false;
                    }
                    break;
                case ']':
                    if (charStack.empty()) {
                        return false;
                    } else if (charStack.pop() != ']') {
                        return false;
                    }
                    break;
                case '}':
                    if (charStack.empty()) {
                        return false;
                    } else if (charStack.pop() != '}') {
                        return false;
                    }
                    break;
            }
        }
        return charStack.empty();
    }
}
