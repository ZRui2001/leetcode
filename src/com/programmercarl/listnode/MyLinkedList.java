package com.programmercarl.listnode;

/**
 * ClassName: MyLinkedList
 * Package: com.programmercarl.listnode
 * Description:
 * 707
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 *
 * 实现 MyLinkedList 类：
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 *
 * 示例：
 * 输入
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * 输出
 * [null, null, null, null, 2, null, 3]
 *
 * 解释
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
 * myLinkedList.get(1);              // 返回 2
 * myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
 * myLinkedList.get(1);              // 返回 3
 *
 * 提示：
 * 0 <= index, val <= 1000
 * 请不要使用内置的 LinkedList 库。
 * 调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。
 * @Author Zhirui Zhao
 * @Create 2024/3/4 12:42
 * @Version 1.0
 */
class MyLinkedList {
//    int length;
//    ListNode head, dummy, cur, pre;
//
//    public MyLinkedList() {
//        dummy = new ListNode(0);
//        length = 0;
//    }
//
//    public int get(int index) {
//        if (index < 0 || index >= length) return -1;
//
//        pre = dummy;
//        for (int i = 0; i < index; i++) {
//            pre = pre.next;
//        }
//        return pre.next.val;
//    }
//
//    public void addAtHead(int val) {
//        if (head == null) {
//            head = dummy.next = new ListNode(val);
//        } else {
//            head = dummy.next = new ListNode(val, head);
//        }
//        length++;
//    }
//
//    public void addAtTail(int val) {
//        pre = dummy;
//        while (pre.next != null) {
//            pre = pre.next;
//        }
//        pre.next = new ListNode(val);
//        if (head == null) head = pre.next;
//        length++;
//    }
//
//    public void addAtIndex(int index, int val) {
//        ListNode[] queryNodes = query(index, head, dummy);
//        if (queryNodes == null) return;
//        pre = queryNodes[0];
//        cur = queryNodes[1];
//        pre.next = new ListNode(val, cur);
//        if (index == 0) head = pre.next;
//        length++;
//    }
//
//    public void deleteAtIndex(int index) {
//
//        ListNode[] queryNodes = query(index, head, dummy);
//        if (queryNodes == null) return;
//        pre = queryNodes[0];
//        cur = queryNodes[1];
//        if (cur == null) return;
//        pre.next = cur.next;
//        if (index == 0) head = pre.next;
//        length--;
//    }
//
//    private ListNode[] query(int index, ListNode head, ListNode dummy) {
//        if (index < 0 || index > length) return null;
//
//        cur = head;
//        pre = dummy;
//        for (int i = 0; i < index; i++) {
//            pre = cur;
//            cur = cur.next;
//        }
//        return new ListNode[] {pre, cur};
//    }
    int size = 0;
    ListNode dummy;  // 虚拟头节点

    public MyLinkedList() {
        dummy = new ListNode();
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode pre = dummy;
        for (int i = 0; i <= index; i++) {
            pre = pre.next;
        }
        return pre.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        ListNode pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        pre.next = new ListNode(val, cur);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        ListNode pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        pre.next = cur.next;
        size--;
    }
}
