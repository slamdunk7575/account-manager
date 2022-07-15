package com.jun.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ArrayRotateTest {


    @DisplayName("배열 회전 테스트")
    @Test
    void arrayRotateTest() {
        // given
        int row = 3;
        int col = 3;
        String data = "1,2,3,4,5,6,7,8,9";
        String rotateOrder = "RRT";
        String printTarget = "1,3";
        ArrayRotate arrayRotate = new ArrayRotate();

        // when
        int result = arrayRotate.solve(row, col, data, rotateOrder, printTarget);

        // then
        assertThat(result).isEqualTo(1);

    }
}
