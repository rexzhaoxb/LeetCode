package com.leetcode.p0024;

// 24. 两两交换链表中的节点

import com.leetcode.common.ListNode;

public class SwapNodesInPairs {

    // 引入一个 god 指针，就可以直接循环了，O(n)
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = head.next;
        ListNode godNode = new ListNode(-1, head);
        while (godNode.next != null && godNode.next.next != null) {
            ListNode n1 = godNode.next, n2 = godNode.next.next;
            godNode.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            godNode = n1;
        }

        return ret;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new SwapNodesInPairs.ListNode(5);

        System.out.println(head);
        System.out.println(swapPairs(head));
    }
}
