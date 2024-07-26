package com.programmercarl.tree_node;

/**
 * ClassName: E112
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/2 21:18
 * @Version 1.0
 */
public class E112 {

    int pathSum;
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        traversal(root, targetSum);
        return res;
    }

    private void traversal(TreeNode node, int targetSum) {
        if (node == null || res) {
            return;
        }
        pathSum += node.val;
        if (node.left == null && node.right == null) {
            res = (pathSum == targetSum);
            return;
        }

        if (node.left != null) {
            traversal(node.left, targetSum);
            pathSum -= node.left.val;
        }
        if (node.right != null) {
            traversal(node.right, targetSum);
            pathSum -= node.right.val;
        }
    }
}
