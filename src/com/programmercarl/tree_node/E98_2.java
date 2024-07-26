package com.programmercarl.tree_node;

/**
 * ClassName: E98_2
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/6 12:45
 * @Version 1.0
 */
public class E98_2 {

    long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }


        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }

        if (prev >= root.val) {
            return false;
        }
        prev = root.val;

        return isValidBST(root.right);
    }
}
