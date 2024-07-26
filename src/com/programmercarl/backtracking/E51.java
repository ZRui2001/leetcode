package com.programmercarl.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: E51
 * Package: com.programmercarl.backtracking
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/20 12:00
 * @Version 1.0
 */
public class E51 {

    // 棋盘
    LinkedList<String> chessboard;
    // 结果
    ArrayList<List<String>> result;
    // 一行棋的n种下法
    String[] nSituations;

    public List<List<String>> solveNQueens(int n) {
        chessboard = new LinkedList<>();
        result = new ArrayList<>();
        boolean[][] record = new boolean[n][n];
        for (int i = 0; i < record.length; i++) {
            Arrays.fill(record[i], true);
        }
        nSituations = new String[n];
        for (int i = 0; i < n; i++) {
            nSituations[i] = putQ(i, n);
        }

        backtracking(n, 0, record);

        return result;
    }

    private void backtracking(int n, int row, boolean[][] record) {
        if (chessboard.size() == n) {
            result.add(new ArrayList<>(chessboard));
            return;
        }

        // 处理一行
        for (int i = 0; i < n; i++) {
            // 如果i处可以落子
            if (record[row][i]){
                // 放Q在i处
                String rowChess = nSituations[i];

//                System.out.println(row);
//                for (boolean[] a : record) {
//                    System.out.println(Arrays.toString(a));
//                }
//                System.out.println(rowChess + "\n");

                // 放进棋盘
                chessboard.add(rowChess);
                // 更新可以落子的位置
                boolean[][] newRecord = update(record, row, i);
                // 处理下一行
                backtracking(n, row + 1, newRecord);
                // 回溯
                chessboard.removeLast();
            }
        }
    }

    private boolean[][] update(boolean[][] record, int row, int col) {
        boolean[][] newRecord = new boolean[record.length][record[0].length];
        for (int i = 0; i < record.length; i++) {
            newRecord[i] = Arrays.copyOf(record[i], record[i].length);
        }
        for (int i = row + 1; i < newRecord.length; i++) {
            // 正下方
            newRecord[i][col] = false;
            // 右下
            if (col + (i - row) < newRecord[0].length) {
                newRecord[i][col + (i - row)] = false;
            }
            // 左下
            if (col - (i - row) >= 0) {
                newRecord[i][col - (i - row)] = false;
            }
        }
        return newRecord;
    }

    /* 根据index放置Q */
    private String putQ(int index, int n) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            if (i == index) {
                chars[i] = 'Q';
            } else {
                chars[i] = '.';
            }
        }
        return new String(chars);
    }

    @Test
    public void test1(){
        solveNQueens(4);
    }
}
