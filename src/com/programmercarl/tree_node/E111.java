package com.programmercarl.tree_node;

import java.util.LinkedList;

/**
 * ClassName: MinDepth
 * Package: com.programmercarl.tree_node
 * Description:
 * 111
 * @Author Zhirui Zhao
 * @Create 2024/3/31 13:19
 * @Version 1.0
 */
public class E111 {
    /**
     * 递归
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int d1 = minDepth(root.left);
        int d2 = minDepth(root.right);
        if (d1 == 0) {
            return d2 + 1;
        }
        if (d2 == 0) {
            return d1 + 1;
        }
        return Integer.min(d1, d2) + 1;
    }

    /**
     * 层序遍历
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int size =queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != poll) {
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
