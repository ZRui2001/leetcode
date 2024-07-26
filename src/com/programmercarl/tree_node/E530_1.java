package com.programmercarl.tree_node;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: E530_1
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/7 12:12
 * @Version 1.0
 */
public class E530_1 {
    public int getMinimumDifference(TreeNode root) {
        AtomicInteger minDiff = new AtomicInteger(Integer.MAX_VALUE);
        TreeNode prev = new TreeNode();
        AtomicBoolean isFirst = new AtomicBoolean(true);
        inTraversal(root, prev, minDiff, isFirst);
        return minDiff.get();
    }

    private void inTraversal(TreeNode node, TreeNode prev, AtomicInteger minDiff, AtomicBoolean isFirst) {
        if (node == null) {
            return;
        }

        inTraversal(node.left, prev, minDiff, isFirst);

        if (!isFirst.get()) {
            int diff = Math.abs(prev.val - node.val);
            if (diff < minDiff.get()) {
                minDiff.set(diff);
            }
        } else {
            isFirst.set(false);
        }
        prev.val = node.val;


        inTraversal(node.right, prev, minDiff, isFirst);
    }

    @Test
    public void test1(){
        TreeNode root = TreeNodeUtil.arrayToTree(new Integer[]{5, 4, 7});
        System.out.println(getMinimumDifference(root));
    }
}
