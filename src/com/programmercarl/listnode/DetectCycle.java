package com.programmercarl.listnode;

/**
 * ClassName: DetectCycle
 * Package: com.programmercarl.listnode
 * Description:
 * 142
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。

 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。

 * 提示：
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引

 * 进阶：你是否可以使用 O(1) 空间解决此题？

 * @Author Zhirui Zhao
 * @Create 2024/3/6 16:37
 * @Version 1.0
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode fast = head, slow = head;
//        int[] distance = new int [2];
//
//        // 相遇2次
//        for (int i = 0; i < 2; i++) {
//            // 相遇或fast指向null退出
//            do {
//                fast = fast.next;
//                if (fast != null) {
//                    fast = fast.next;
//                }
//                slow = slow.next;
//                distance[i]++;
//            } while (fast != slow && fast != null);
//
//            if (fast == null) {
//                return null;
//            }
//        }
//
//        int cycleLen = distance[1];
//        int times = distance[0] / cycleLen - 1;
//        ListNode p1 = head;
//        ListNode p2 = fast;
//        if (times > 0) {
//            for (int i = 0; i < times * cycleLen; i++) {
//                p1 = p1.next;
//            }
//        }
//        while (p1 != p2) {
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        return p1;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode p1 = head;
                ListNode p2 = fast;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}
