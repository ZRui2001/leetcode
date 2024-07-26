package com.programmercarl.tree_node;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * path使用StringBuilder
 */
public class E257_1 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        traversal(root, path, result, true);
        return result;
    }

    private void traversal(TreeNode node, StringBuilder path, List<String> result, boolean isFirst) {

        if (!isFirst) {
            path.append("->");
        }
        path.append(node.val);

        if (node.left == null && node.right == null) {
            result.add(path.toString());
            return;
        }

        if (node.left != null) {
            traversal(node.left, path, result, false);
            deleteEnd(path);
        }
        if (node.right != null) {
            traversal(node.right, path, result, false);
            deleteEnd(path);
        }
    }

    private void deleteEnd(StringBuilder path) {
        int from = path.lastIndexOf(">");
        if (from >= 1) {
            path.delete(from - 1, path.length());
        }
    }

    @Test
    public void test1(){
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode root = new TreeNode(1, n2, n3);
        n2.right = n5;
        System.out.println(binaryTreePaths(root));
    }
}
