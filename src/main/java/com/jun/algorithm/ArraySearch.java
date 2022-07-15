package com.jun.algorithm;

import com.jun.algorithm.util.StringSplitUtil;

public class ArraySearch {

    public String solve(int row, int col, String data) {

        int[][] arr = StringSplitUtil.splitDataByComma(row, col, data);
        StringBuilder sb = new StringBuilder();

        // 윗 삼각형 (0 ~ 2)
        for (int i = 0; i < row; i++) {
            int count = 0;

            // 홀수
            if (i % 2 != 0) {
                for (int k = 0; k < i + 1; k++) {
                    sb.append(arr[count][i - count]).append(",");
                    count++;
                }

            // 짝수
            } else {
                for (int k = 0; k < i + 1; k++) {
                    sb.append(arr[i - count][count]).append(",");
                    count++;
                }
            }
        }

        // 아래 삼각형 (1 ~ 2)
        for (int i = 1; i <= row - 1; i++) {
            int count = 0;

            // 홀수
            if ((i + row - 1) % 2 != 0) {
                for (int k = i; k < row; k++) {
                    sb.append(arr[i + count][row - 1 - count]).append(",");
                    count++;
                }

            } else {
                for (int k = i; k < row; k++) {
                    sb.append(arr[row - 1 - count][i + count]).append(",");
                    count++;
                }

            }
        }

        return sb.toString().replaceAll(",$", "");
    }
}
