package com.jun.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArraySearchTest {

    @DisplayName("배열 탐색 테스트")
    @Test
    void arraySearchTest() {
        // given
        int row = 3;
        int col = 3;
        String data = "1,2,3,4,5,6,7,8,9";
        ArraySearch arraySearch = new ArraySearch();

        // when
        String result = arraySearch.solve(row, col, data);

        // then
        assertThat(result).isEqualTo("1,2,4,7,5,3,6,8,9");
    }

}
