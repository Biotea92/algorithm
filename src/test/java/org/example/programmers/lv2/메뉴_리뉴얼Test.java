package org.example.programmers.lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 메뉴_리뉴얼Test {

    @Test
    void test1() {
        메뉴_리뉴얼 obj = new 메뉴_리뉴얼();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] result = obj.solution(orders, course);
        assertArrayEquals(new String[]{"AC", "ACDE", "BCFG", "CDE"}, result);
    }

    @Test
    void test2() {
        메뉴_리뉴얼 obj = new 메뉴_리뉴얼();
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};
        String[] result = obj.solution(orders, course);
        assertArrayEquals(new String[]{"ACD", "AD", "ADE", "CD", "XYZ"}, result);
    }

    @Test
    void test3() {
        메뉴_리뉴얼 obj = new 메뉴_리뉴얼();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] result = obj.solution(orders, course);
        assertArrayEquals(new String[]{"WX", "XY"}, result);
    }
}
