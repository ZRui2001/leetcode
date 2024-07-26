package com.programmercarl.tree_node;

/**
 * ClassName: E235
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/4/12 16:52
 * @Version 1.0
 */
public class E235 {
    // 若p和q在某个节点的两侧，则该节点为最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (p.val < node.val && q.val < node.val || p.val > node.val && q.val > node.val) {
            // p,q在同一侧
            if (p.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }
}
