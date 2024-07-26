package com.programmercarl.tree_node;

import java.util.LinkedList;

/**
 * ClassName: E938
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/4/11 18:43
 * @Version 1.0
 */
public class E938 {
    // 解法1. 中序非递归实现, 4ms，效率低
    public int rangeSumBST1(TreeNode root, int low, int high) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        int sum = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop.val >= low && pop.val <= high) {
                    sum += pop.val;
                }
                if (pop.val >= high) {
                    break;
                }
                p = pop.right;
            }
        }
        return sum;
    }

    // 解法1. 上下限递归，效率高
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST2(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST2(root.left, low, high);
        }
        return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
    }
}







































