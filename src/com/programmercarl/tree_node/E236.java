package com.programmercarl.tree_node;

/**
 * ClassName: E236
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/8 11:22
 * @Version 1.0
 */
public class E236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 由于p、q一定存在于二叉树中，故遇到一个可以直接返回
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右至少有一个为null，返回另一个
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        // 左右都不为null，则当前根节点为最近祖先
        return root;
    }
}
