package com.programmercarl.tree_node;

/**
 * ClassName: E617
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/5 10:15
 * @Version 1.0
 */
public class E617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode root =  new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
