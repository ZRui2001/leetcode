package com.programmercarl.tree_node;

/**
 * ClassName: E513
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/1 9:18
 * @Version 1.0
 */
public class E513 {

    int maxDepth = -1;
    int result;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return result;

    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            // 当前节点为叶子
            if (depth > maxDepth) {
                // 深度要严格大于，保证同深度下只记录第一个访问的节点
                result = node.val;
                maxDepth = depth;
            }
            return;
        }

        // 先左后右
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
