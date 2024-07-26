package com.programmercarl.backtracking;

import com.programmercarl.utils.DebugUtil;
import org.junit.Test;

import java.util.Arrays;

/* 优化版 */
public class E37_1 {

    boolean[][] rowAvailable = new boolean[9][9];
    boolean[][] colAvailable = new boolean[9][9];
    boolean[][] cubeAvailable = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        // 初始化3个 available 数组为 true
        fill2DArray(rowAvailable);
        fill2DArray(colAvailable);
        fill2DArray(cubeAvailable);
        // 读入 board 的原始数据，更新 3 个 available 数组
        initialize(board);

        backtracking(board, 0, 0);
    }

    private boolean backtracking(char[][] board, int row, int col) {
        if (row >= 9) {
            // 找到解
            return true;
        }
        if (col >= 9) {
            // 处理列溢出
            return backtracking(board, row + 1, 0);
        }
        if (board[row][col] != '.') {
            // 找空位
            return backtracking(board, row, col + 1);
        }


        // 依次尝试 1-9 , num = i + 1
        for (int i = 0; i < 9; i++) {
            // 行、列、块验证
            int cubeIdx = row / 3 * 3 + col / 3;
            if (rowAvailable[row][i] && colAvailable[col][i] && cubeAvailable[cubeIdx][i]) {
                // 填入
                board[row][col] = (char) ((i + 1) + '0');
                // 更新行、列、块 available
                update(row, col, i, false);
                // 递归
                if (backtracking(board, row, col + 1)) {
                    // 找到解就不回溯了，提前结束递归
                    return true;
                }
                // 回溯
                update(row, col, i, true);
                board[row][col] = '.';
            }
        }
        // 当前格无解，回溯
        return false;
    }

    private void initialize(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    update(i, j, num - 1, false);
                }
            }
        }
    }

    private void update(int row, int col, int num, boolean flag) {
        int cubeIdx = row / 3 * 3 + col / 3;
        rowAvailable[row][num] = flag;
        colAvailable[col][num] = flag;
        cubeAvailable[cubeIdx][num] = flag;
    }

    private void fill2DArray(boolean[][] array) {
        for (boolean[] a : array) {
            Arrays.fill(a, true);
        }
    }

    @Test
    public void test1(){
        char[][] board = DebugUtil.convertJsonStringToCharArray("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        solveSudoku(board);
    }
}
