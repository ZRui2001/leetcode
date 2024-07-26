package com.programmercarl.listnode;

/**
 * ClassName: ListNode
 * Package: com.programmercarl.listnode.create
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/3/4 11:45
 * @Version 1.0
 */
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
