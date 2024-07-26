package com.programmercarl.tree_node;

/**
 * ClassName: IsSymmetric
 * Package: com.programmercarl.tree_node
 * Description:
 * 101
 * @Author Zhirui Zhao
 * @Create 2024/3/29 13:15
 * @Version 1.0
 */
public class E101 {
    /**
     * 递归
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            return check(left.left, right.right) && check(left.right, right.left);
        }
        return false;
    }

    /**
     * 迭代
     */
//    public boolean isSymmetric1(TreeNode root) {
//        TreeNode cur = root;
//        while(cur.left.val == cur.right.val) {
//
//        }
//    }

}
