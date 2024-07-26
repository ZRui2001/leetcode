package com.programmercarl.stack_and_queue;

import java.util.Stack;

/**
 * ClassName: StackImplementsQueue
 * Package: com.programmercarl.stack_and_queue
 * Description:
         * 使用栈实现队列的下列操作：
         * push(x) -- 将一个元素放入队列的尾部。
         * pop() -- 从队列首部移除元素。
         * peek() -- 返回队列首部的元素。
         * empty() -- 返回队列是否为空。

         * 说明:
         * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
         * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
         * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * @Author Zhirui Zhao
 * @Create 2024/3/20 14:15
 * @Version 1.0
 */

public class MyQueue<T> {
    private Stack<T> stIn;
    private Stack<T> stOut;
    private int size;

    public MyQueue() {
        stIn = new Stack<>();
        stOut = new Stack<>();
        size = 0;
    }

    /*
    把元素加到队列尾部
     */
    void push(T x) {
        stIn.push(x);
        size++;
    }

    /*
            从队列首部弹出元素
             */
    T pop() {
        // 判断是否为空
        if (this.empty()) {
            // 队列为空，抛出异常
            throw new RuntimeException("队列为空，pop无效");
        } else if (stOut.empty()){
            // stOut为空，把stIn的所有数据取到stOut
            getDataFromInToOut();
            size--;
            return stOut.pop();
        } else {
            // stOut不为空，直接从stOut弹出数据
            size--;
            return stOut.pop();
        }
    }

    /*
    查看队列首部元素，但不做改动
     */
    T peek() {
        T element = this.pop();
        this.push(element);
        return element;
    }

    boolean empty() {
        return stIn.empty() && stOut.empty();
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "stIn=" + stIn.toString() +
                ", stOut=" + stOut.toString() +
                '}';
    }

    int getSize() {
        return size;
    }
    void getDataFromInToOut() {
        while (!stIn.empty()) {
            stOut.push(stIn.pop());
        }
    }
}