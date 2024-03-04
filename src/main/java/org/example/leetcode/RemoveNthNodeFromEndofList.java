package org.example.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class RemoveNthNodeFromEndofList {

//    Given the head of a linked list, remove the nth node from the end of the list and return its head

//    The number of nodes in the list is sz.
//    1 <= sz <= 30
//    0 <= Node.val <= 100
//    1 <= n <= sz
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpNode = head;
        List<Integer> tmpList = new LinkedList<>();
        while (tmpNode != null) {
            tmpList.add(tmpNode.val);
            tmpNode = tmpNode.next;
        }
        int size = tmpList.size();
        tmpList.remove(size - n);
        if (tmpList.isEmpty())
            return new ListNode();
        for (int i = 0; i < tmpList.size(); i++) {
            if (i == 0) {
                head = new ListNode(tmpList.get(0));
                tmpNode = head;
            } else {
                Integer val = tmpList.get(i);
                tmpNode.next = new ListNode(val);
                tmpNode = tmpNode.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + Objects.hashCode(next);
            return result;
        }
    }
}
