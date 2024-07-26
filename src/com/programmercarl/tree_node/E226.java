package com.programmercarl.tree_node;

/**
 * ClassName: InvertTree
 * Package: com.programmercarl.tree_node
 * Description:
 * 226
 * @Author Zhirui Zhao
 * @Create 2024/3/31 13:35
 * @Version 1.0
 */
public class E226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
    }
}
