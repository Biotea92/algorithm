package org.example.leetcode;

import org.example.leetcode.RemoveNthNodeFromEndofList.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndofListTest {

    @Test
    void test1() {
//        Input: head = [1,2,3,4,5], n = 2
//        Output: [1,2,3,5]
        // given
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        int n = 2;

        // when
        ListNode result = new RemoveNthNodeFromEndofList().removeNthFromEnd(node1, n);
    }

    @Test
    void test2() {
//        Input: head = [1,2], n = 1
//        Output: [1]
        // given
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        int n = 1;

        // when
        ListNode result = new RemoveNthNodeFromEndofList().removeNthFromEnd(node1, n);
    }

    @Test
    void test3() {
//        Input: head = [1], n = 1
//        Output: [] // null
        ListNode node1 = new ListNode(1);
        int n = 1;

        // when
        ListNode result = new RemoveNthNodeFromEndofList().removeNthFromEnd(node1, n);
    }
}
