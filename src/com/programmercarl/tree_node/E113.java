package com.programmercarl.tree_node;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: E113
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/2 21:39
 * @Version 1.0
 */
public class E113 {
    int pathValSum;
    List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }

        path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, targetSum, res);
        return res;
    }

    private void traversal(TreeNode node, int targetSum, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        pathValSum += node.val;
        path.add(node.val);

        if (node.left == null && node.right == null && pathValSum == targetSum) {
            res.add(new ArrayList<>(path));  // 不能add path，因为后续path会改变
            return;
        }

        if (node.left != null) {
            traversal(node.left, targetSum, res);
            pathValSum -= node.left.val;
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            traversal(node.right, targetSum, res);
            pathValSum -= node.right.val;
            path.remove(path.size() - 1);
        }
    }
    
    @Test
    public void test0(){
        TreeNode root = TreeNodeUtil.arrayToTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        E113 e113 = new E113();
        System.out.println(e113.pathSum(root, 22));
    }
}

