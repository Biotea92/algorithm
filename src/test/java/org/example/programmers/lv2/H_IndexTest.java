package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class H_IndexTest {

    @Test
    void solution() {
        H_Index h_index = new H_Index();
        int[] citations = {3, 0, 6, 1, 5};
        int result = h_index.solution(citations);
        assertEquals(3, result);
    }

}
