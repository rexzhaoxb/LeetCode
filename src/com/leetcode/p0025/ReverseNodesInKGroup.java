package com.leetcode.p0025;

import com.leetcode.common.ListNode;

// 25. K 个一组翻转链表
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) return head;
        ListNode lastGroup = new ListNode(-1, head), newHead = head, node = lastGroup;

        while (lastGroup.next != null) {

            // 缓存组内第一个元素
            ListNode firstItemInGroup = lastGroup.next;
            // 先找到这一组中最后一个元素
            for (int i = 0; i < k; i++) {
                node = node.next;
                if (node == null) return newHead;
            }
            lastGroup.next = node;
            if (newHead == head) newHead = node;
            // 本组第一个元素将成为与下组的链接
            lastGroup = firstItemInGroup;
            // 再从头开始逐个做反转操作
            ListNode node1 = null, node2 = firstItemInGroup, node3 = node2.next;
            for (int i = 0; i < k; i++) {
                if (i > 0) {
                    node2.next = node1;
                }
                node1 = node2;
                node2 = node3;
                if (i == k - 1) {
                    firstItemInGroup.next = node3;
                } else {
                    node3 = node3.next;
                }
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(head);
        System.out.println(reverseKGroup(head, 2));
        System.out.println(reverseKGroup(head, 3));
        System.out.println(reverseKGroup(head, 4));
        System.out.println(reverseKGroup(head, 5));
        System.out.println(reverseKGroup(head, 6));
    }
}
