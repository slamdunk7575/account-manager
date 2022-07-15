package com.jun.algorithm;

import com.jun.algorithm.util.StringSplitUtil;

public class ArrayRotate {

    public int solve(int row, int col, String data, String rotateOrder, String printTarget) {

        int[][] arr = StringSplitUtil.splitDataByComma(row, col, data);

        String[] rotateOrders = StringSplitUtil.splitDataByEmpty(rotateOrder);

        int[][] result = null;

        for (String order : rotateOrders) {
            if (order.equals("R")) {
                if (result != null) {
                    result = rotateRight(row, col, result);
                } else {
                    result = rotateRight(row, col, arr);
                }
            } else if (order.equals("L")) {
                if (result != null) {
                    result = rotateLeft(row, col, result);
                } else {
                    result = rotateLeft(row, col, arr);
                }
            } else {
                if (result != null) {
                    result = reverseLeftRight(row, col, result);
                } else {
                    result = reverseLeftRight(row, col, arr);
                }
            }
        }

        String[] target = printTarget.split(",");
        int i = Integer.parseInt(target[0]) - 1;
        int j = Integer.parseInt(target[1]) - 1;

        return result[j][i];
    }

    private int[][] rotateRight(int row, int col, int[][] arr) {
        // 회전하기 때문에 행과 열을 반대로 셋팅
        int[][] rotateResult = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                rotateResult[i][j] = arr[row - 1 - j][i];
            }
        }

        return rotateResult;
    }

    private int[][] rotateLeft(int row, int col, int[][] arr) {
        int[][] rotateResult = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                rotateResult[i][j] = arr[j][col - 1 - i];
            }
        }

        return rotateResult;
    }

    private int[][] reverseLeftRight(int row, int col, int[][] arr) {
        int[][] reverseResult = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                reverseResult[i][j] = arr[i][col - 1 - j];
            }
        }

        return reverseResult;
    }

}
