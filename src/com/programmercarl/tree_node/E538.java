package com.programmercarl.tree_node;

/**
 * ClassName: E538
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/10 9:31
 * @Version 1.0
 */
public class E538 {

    int pre;

    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        inTraversal(root);
        return root;
    }

    private void inTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inTraversal(root.right);
        root.val += pre;
        pre = root.val;
        inTraversal(root.left);
    }
}
