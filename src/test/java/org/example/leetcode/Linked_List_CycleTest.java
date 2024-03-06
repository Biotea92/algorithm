package org.example.leetcode;

import org.example.leetcode.Linked_List_Cycle.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Linked_List_CycleTest {

    @Test
    void test1() {
//        Input: head = [3,2,0,-4], pos = 1
//        Output: true
//        Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

        // given
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        // when
        boolean result = new Linked_List_Cycle().hasCycle(head);

        // then
        assertTrue(result);
    }

    @Test
    void test2() {
//        Input: head = [1,2], pos = 0
//        Output: true
//        Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

        // given
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;

        // when
        boolean result = new Linked_List_Cycle().hasCycle(head);

        // then
        assertTrue(result);
    }

    @Test
    void test3() {
//        Input: head = [1], pos = -1
//        Output: false
//        Explanation: There is no cycle in the linked list.

        // given
        ListNode head = new ListNode(1);

        // when
        boolean result = new Linked_List_Cycle().hasCycle(head);

        // then
        assertFalse(result);
    }

}
