package com.programmercarl.tree_node;

import java.util.LinkedList;

/**
 * ClassName: MaxDepth
 * Package: com.programmercarl.tree_node
 * Description:
 * 104
 * @Author Zhirui Zhao
 * @Create 2024/3/29 16:01
 * @Version 1.0
 */
public class E104 {
    /**
     * 递归
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 迭代
     * 基本和traversal中的一样
     */
    public int maxDepth1(TreeNode root) {
        TreeNode cur = root;
        TreeNode pop = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int max = 0;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                if (stack.size() > max) {
                    max = stack.size();
                }
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    cur = peek.right;
                }
            }
        }
        return max;
    }

    /**
     * 层序遍历
     */
    public int maxDepth2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = queue.size();
        int depth = 0;

        while (!queue.isEmpty()) {
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
