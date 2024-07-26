package com.programmercarl.backtracking;

import com.programmercarl.utils.DebugUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * ClassName: E37
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/21 10:50
 * @Version 1.0
 */
public class E37 {

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

        int[] coordinate = searchNext(board, 0, 0);
        backtracking(board, coordinate);
    }

    private boolean backtracking(char[][] board, int[] coordinate) {
        if (coordinate == null) {
            // 找到解
            return true;
        }

        int row = coordinate[0];
        int col = coordinate[1];
        // 依次尝试 1-9 , num = i + 1
        for (int i = 0; i < 9; i++) {
            // 行、列、块验证
            int cubeIdx = row / 3 * 3 + col / 3;
            if (rowAvailable[row][i] && colAvailable[col][i] && cubeAvailable[cubeIdx][i]) {
                // 填入
                board[row][col] = (char) ((i + 1) + '0');
                // 更新行、列、块 available
                update(row, col, i);
                // 递归
                if (backtracking(board, searchNext(board, row, col))) {
                    // 找到解就不回溯了，提前结束递归
                    return true;
                }
                // 回溯
                rowAvailable[row][i] = true;
                colAvailable[col][i] = true;
                cubeAvailable[cubeIdx][i] = true;
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
                    update(i, j, num - 1);
                }
            }
        }
    }

    private void update(int row, int col, int num) {
        int cubeIdx = row / 3 * 3 + col / 3;
        rowAvailable[row][num] = false;
        colAvailable[col][num] = false;
        cubeAvailable[cubeIdx][num] = false;
    }

    /* 从（row，col）开始搜索下一个空位，包括（row，col） */
    private int[] searchNext(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == row && j < col) {
                    continue;
                }
                if (board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
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
