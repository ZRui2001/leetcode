package com.programmercarl.tree_node;

/**
 * ClassName: E222
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/6/22 17:01
 * @Version 1.0
 */
public class E222 {
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = searchLeft(root);
        int rightDepth = searchRight(root);
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;     // 根节点深度为0，因为2 << n = 2 ^ (n + 1)
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int searchRight(TreeNode node) {
        int depth = 0;
        while (node.right != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }

    private int searchLeft(TreeNode node) {
        int depth = 0;
        while (node.left != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

}
