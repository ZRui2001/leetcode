package com.programmercarl.listnode;

/**
 * ClassName: ReverseList
 * Package: com.programmercarl.listnode
 * Description:
 * 206
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * @Author Zhirui Zhao
 * @Create 2024/3/5 11:35
 * @Version 1.0
 */
class ReverseList {
    // 双指针法
    public ListNode doublePointer(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        // reverse
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归法
    public ListNode recursion(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;  // 终止条件
        // 交换指向，双指针指向下一个位置
        ListNode nex = cur.next;
        cur.next = pre;

        return reverse(cur, nex);
    }
}
