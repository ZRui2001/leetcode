package com.programmercarl.tree_node;

/**
 * ClassName: E110
 * Package: com.programmercarl.binary_search
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/6/24 9:54
 * @Version 1.0
 */

/*递归*/
public class E110_1 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}
