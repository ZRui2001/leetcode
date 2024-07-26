package com.programmercarl.tree_node;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ClassName: IsValidBST
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/4/9 11:43
 * @Version 1.0
 */
public class E98_1 {
    /*中序非递归*/
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode p = root;
        long prev = Long.MIN_VALUE;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop.val <= prev) {
                    return false;
                }
                prev = pop.val;
                p = pop.right;
            }
        }
        return true;
    }

    /*中序递归1（全部变量记录prev）*/
    long prev = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean leftRes = isValidBST2(root.left);
        if (!leftRes || prev >= root.val) {
            return false;
        }
        prev = root.val;
        return isValidBST2(root.right);
    }

    /*中序递归2（局部变量记录prev）*/
    public boolean isValidBST3(TreeNode root) {
        return doValid(root, new AtomicLong(Long.MIN_VALUE));
    }

    boolean doValid(TreeNode root, AtomicLong prev) {
        if (root == null) {
            return true;
        }

        boolean leftRes = doValid(root.left, prev);
        if (!leftRes) {
            return false;
        }
        if (prev.get() >= root.val) {
            return false;
        }
        prev.set(root.val);
        return doValid(root.right, prev);
    }

    /*上下限递归*/
    public boolean isValidBST4(TreeNode root) {
        return doValid4(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean doValid4(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return doValid4(node.left, min, node.val) && doValid4(node.right, node.val, max);
    }
}






















