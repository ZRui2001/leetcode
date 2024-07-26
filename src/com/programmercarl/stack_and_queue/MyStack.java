package com.programmercarl.stack_and_queue;

/**
 * ClassName: QueueImplementsStack
 * Package: com.programmercarl.stack_and_queue
 * Description:
         * 使用队列实现栈的下列操作：

         * push(x) -- 元素 x 入栈
         * pop() -- 移除栈顶元素
         * top() -- 获取栈顶元素
         * empty() -- 返回栈是否为空
         * 注意:
         * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
         * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
         * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * @Author Zhirui Zhao
 * @Create 2024/3/20 19:07
 * @Version 1.0
 */
public class MyStack<T> {
    private MyQueue<T> que1;
    private MyQueue<T> que2;


    MyStack() {
        que1 = new MyQueue<>();
        que2 = new MyQueue<>();
    }

    void push(T x) {
        que1.push(x);
    }

    T pop() {
        if (que1.empty()) {
            throw new RuntimeException("栈空，pop操作无效");
        }

        // 把que1中除队尾元素的其他元素移至que2存储
        while (que1.getSize() > 1) {
            que2.push(que1.pop());
        }
        // 弹出队尾元素，也是栈顶元素
        T popedElement = que1.pop();
        // 把que2中存的队列返还que1
        while (!que2.empty()) {
            que1.push(que2.pop());
        }
        return popedElement;
    }

    T top() {
        T top = this.pop();
        this.push(top);
        return top;
    }

    boolean empty() {
        return que1.empty();
    }
}
