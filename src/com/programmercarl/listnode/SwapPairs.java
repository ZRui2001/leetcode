package com.programmercarl.listnode;

/**
 * ClassName: SwapPairs
 * Package: com.programmercarl.listnode
 * Description:
 * 24
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]

 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * @Author Zhirui Zhao
 * @Create 2024/3/5 12:17
 * @Version 1.0
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(-1, head);
        ListNode cur = head;

        while (cur.next != null) {
            // 交换
            pre.next = cur.next;
            cur.next = pre.next.next;
            pre.next.next = cur;
            if (cur == head) head = pre.next;  // 仅在第一步更新头节点

            // 更新指针
            pre = cur;
            cur = cur.next;
            if (cur == null) break;
        }
        return head;
    }
}
