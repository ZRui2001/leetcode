package com.programmercarl.tree_node;

/**
 * ClassName: SearchBST
 * Package: com.programmercarl.tree_node
 * Description:
 * 700
 * @Author Zhirui Zhao
 * @Create 2024/4/1 21:43
 * @Version 1.0
 */
public class E700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}
