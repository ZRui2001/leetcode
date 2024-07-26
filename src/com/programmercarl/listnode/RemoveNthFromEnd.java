package com.programmercarl.listnode;

/**
 * ClassName: RemoveNthFromEnd
 * Package: com.programmercarl.listnode
 * Description:
 * 19
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]

 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz

 * 进阶：你能尝试使用一趟扫描实现吗？

 * @Author Zhirui Zhao
 * @Create 2024/3/6 14:51
 * @Version 1.0
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;

        // 找要删除的点
        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;  // 删除
        return dummy.next;
    }
}
