package com.programmercarl.tree_node;

/**
 * ClassName: E669_1
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/9 11:23
 * @Version 1.0
 */
public class E669_1 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
