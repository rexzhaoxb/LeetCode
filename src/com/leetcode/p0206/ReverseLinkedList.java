package com.leetcode.p0206;

// 206. 反转链表

import com.leetcode.common.ListNode;

import java.util.Stack;

public class ReverseLinkedList {

    // 用一个栈来辅助反转, O(n)
//    public static ListNode reverseList(ListNode head) {
//        if (head == null) return null;
//        Stack<Integer> stack = new Stack<>();
//        ListNode node = head;
//        do {
//            stack.push(node.val);
//            node = node.next;
//        } while (node != null);
//
//        node = head;
//        while (!stack.isEmpty()) {
//            node.val = stack.pop();
//            node = node.next;
//        }
//        return head;
//    }

    // 一次循环, O(n)
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node1 = null, node2 = head, node3 = head.next;
        while (node3 != null) {
            node2.next = node1;

            node1 = node2;
            node2 = node3;
            node3 = node3.next;
        }
        node2.next = node1;

        return node2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(head);
        System.out.println(reverseList(head));
    }
}
