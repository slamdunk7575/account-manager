package com.jun.algorithm.util;

public class StringSplitUtil {

    private StringSplitUtil() {
    }

    public static int[][] splitDataByComma(int row, int col, String data) {
        String[] splitData = data.split(",");
        int[][] result = new int[row][col];
        int index = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = Integer.parseInt(splitData[index++]);
            }
        }

        return result;
    }

    public static String[] splitDataByEmpty(String data) {
        return data.split("");
    }

}
