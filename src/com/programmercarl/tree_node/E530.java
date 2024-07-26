package com.programmercarl.tree_node;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: E530
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/7 11:32
 * @Version 1.0
 */
public class E530 {

    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        AtomicInteger minDiff = new AtomicInteger(Integer.MAX_VALUE);
        inTraversal(root, minDiff);
        return minDiff.get();
    }

    private void inTraversal(TreeNode node, AtomicInteger minDiff) {
        if (node == null) {
            return;
        }

        inTraversal(node.left, minDiff);

        if (prev != null) {
            int diff = Math.abs(prev.val - node.val);
            if (diff < minDiff.get()) {
                minDiff.set(diff);
            }
        }
        prev = node;

        inTraversal(node.right, minDiff);
    }
    
    @Test
    public void test1(){
        TreeNode root = TreeNodeUtil.arrayToTree(new Integer[]{5, 4, 7});
        System.out.println(getMinimumDifference(root));
    }
}
