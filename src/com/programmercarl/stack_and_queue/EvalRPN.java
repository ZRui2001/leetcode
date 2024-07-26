package com.programmercarl.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: EvalRPn
 * Package: com.programmercarl.stack_and_queue
 * Description:
         * 150.逆波兰表达式求值
         * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
         * 请你计算该表达式。返回一个表示表达式值的整数。

         * 注意：
         * 有效的算符为 '+'、'-'、'*' 和 '/' 。
         * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
         * 两个整数之间的除法总是 向零截断 。
         * 表达式中不含除零运算。
         * 输入是一个根据逆波兰表示法表示的算术表达式。
         * 答案及所有中间计算结果可以用 32 位 整数表示。

         * 示例 1：
         * 输入：tokens = ["2","1","+","3","*"]
         * 输出：9
         * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
         * 示例 2：
         * 输入：tokens = ["4","13","5","/","+"]
         * 输出：6
         * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
         * 示例 3：
         * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
         * 输出：22
         * 解释：该算式转化为常见的中缀算术表达式为：
         *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
         * = ((10 * (6 / (12 * -11))) + 17) + 5
         * = ((10 * (6 / -132)) + 17) + 5
         * = ((10 * 0) + 17) + 5
         * = (0 + 17) + 5
         * = 17 + 5
         * = 22

         * 提示：
         * 1 <= tokens.length <= 104
         * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数

         * 逆波兰表达式：
         * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
         * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
         * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。

         * 逆波兰表达式主要有以下两个优点：
         * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
         * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 * @Author Zhirui Zhao
 * @Create 2024/3/22 13:33
 * @Version 1.0
 */
public class EvalRPN {
//    public int evalRPN(String[] tokens) {
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        // 遍历tokens，数字入栈；运算符则取出栈顶两个数运算，结果入栈
//        for (String token : tokens) {
//            if (canConvertTOInt(token)) {
//                // tokens[i]是整数，入栈
//                stack.push(Integer.parseInt(token));
//            } else {
//                // token[i]是运算符，取出栈顶两个数运算，结果入栈
//                int num2 = stack.pop();
//                int num1 = stack.pop();
//                stack.push(calculate(num1, num2, token));
//            }
//        }
//        return stack.pop();
//    }
//
//    /**
//     * 判断字符串能否转为整数
//     * @param s
//     * @return
//     */
//    boolean canConvertTOInt(String s) {
//        try {
//            Integer.parseInt(s);
//        } catch (NumberFormatException e) {
//            return false;
//        }
//        return true;
//    }
//
//    int calculate(int num1, int num2, String operator) {
//        switch (operator) {
//            case "+":
//                return num1 + num2;
//            case "-":
//                return num1 - num2;
//            case "*":
//                return num1 * num2;
//            case "/":
//                if (num2 != 0) {
//                    return num1 / num2;
//                } else {
//                    throw new ArithmeticException("除数不能为零");
//                }
//            default:
//                throw new IllegalArgumentException("非法的操作符: " + operator);
//        }
//    }
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
