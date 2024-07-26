package com.programmercarl.tree_node;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Traversal
 * Package: com.programmercarl.tree_node
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/6 15:26
 * @Version 1.0
 */
public class TraversalTemplate {

    public List<Integer> myTemplate(TreeNode root) {
        TreeNode cur = root;  // 当前访问节点
        TreeNode pop = null;  // 上一个弹出的节点
        LinkedList<TreeNode> stack = new LinkedList<>();  // 之前访问过的节点
        List<Integer> res = new ArrayList<>();  // 遍历结果

        // 向左遍历到底
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        // 回溯
        while (!stack.isEmpty()) {
            // peek的左子树一定已经处理完了。因为左孩子后入先出，左孩子已经弹出表明左子树处理完毕。
            TreeNode peek = stack.peek();

            // 没有右孩子，直接弹出当前节点
            if (peek.right == null) {
                pop = stack.pop();
                continue;
            }
            // 右孩子已弹出，说明右子树处理完毕
            if (pop == peek.right) {
                pop = stack.pop();
                continue;
            }

            // 有未处理的右子树，向左遍历到底
            cur = peek.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }

    public List<Integer> preorder(TreeNode root) {
        TreeNode cur = root;  // 当前访问节点
        TreeNode pop = null;  // 上一个弹出的节点
        LinkedList<TreeNode> stack = new LinkedList<>();  // 之前访问过的节点
        List<Integer> res = new ArrayList<>();  // 遍历结果

        // 向左遍历到底
        while (cur != null) {
            stack.push(cur);
            res.add(cur.val);
            cur = cur.left;
        }

        // 回溯
        while (!stack.isEmpty()) {
            // peek的左子树一定已经处理完了。因为左孩子后入先出，左孩子已经弹出表明左子树处理完毕。
            TreeNode peek = stack.peek();

            // 没有右孩子，直接弹出当前节点
            if (peek.right == null) {
                pop = stack.pop();
                continue;
            }
            // 右孩子已弹出，说明右子树处理完毕
            if (pop == peek.right) {
                pop = stack.pop();
                continue;
            }

            // 有未处理的右子树，向左遍历到底
            cur = peek.right;
            while (cur != null) {
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
        }
        return res;
    }

    public List<Integer> inorder(TreeNode root) {
        TreeNode cur = root;  // 当前访问节点
        TreeNode pop = null;  // 上一个弹出的节点
        LinkedList<TreeNode> stack = new LinkedList<>();  // 之前访问过的节点
        List<Integer> res = new ArrayList<>();  // 遍历结果

        // 向左遍历到底
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        // 回溯
        while (!stack.isEmpty()) {
            // peek的左子树一定已经处理完了。因为左孩子后入先出，左孩子已经弹出表明左子树处理完毕。
            TreeNode peek = stack.peek();

            // 没有右孩子，直接弹出当前节点
            if (peek.right == null) {
                pop = stack.pop();
                res.add(pop.val);
                continue;
            }
            // 右孩子已弹出，说明右子树处理完毕
            if (pop == peek.right) {
                pop = stack.pop();
                continue;
            }

            // 有未处理的右子树，向左遍历到底
            res.add(peek.val);
            cur = peek.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }

    public List<Integer> postorder(TreeNode root) {
        TreeNode cur = root;  // 当前访问节点
        TreeNode pop = null;  // 上一个弹出的节点
        LinkedList<TreeNode> stack = new LinkedList<>();  // 之前访问过的节点
        List<Integer> res = new ArrayList<>();  // 遍历结果

        // 向左遍历到底
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        // 回溯
        while (!stack.isEmpty()) {
            // peek的左子树一定已经处理完了。因为左孩子后入先出，左孩子已经弹出表明左子树处理完毕。
            TreeNode peek = stack.peek();

            // 没有右孩子，直接弹出当前节点
            if (peek.right == null) {
                pop = stack.pop();
                res.add(pop.val);
                continue;
            }
            // 右孩子已弹出，说明右子树处理完毕
            if (pop == peek.right) {
                pop = stack.pop();
                res.add(pop.val);
                continue;
            }

            // 有未处理的右子树，向左遍历到底
            cur = peek.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }

    @Test
    public void test1(){
        TreeNode root = TreeNodeUtil.arrayToTree(new Integer[]{5, 4, 6, 1, 2});
        myTemplate(root);
    }
}
