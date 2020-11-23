package com.leetcode.p0142;

import com.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

// 142. 环形链表 II
public class LinkedListCycle2 {
    // 参考网上的做法，这种方法很巧妙，完全是靠数学思维想出来的：steps_fast = steps_slow * 2
    // 快慢指针第一次相遇后，慢指针接着一步一步走，快指针从头开始一步一步走，第二次相遇点就是圈结束的位置，next就是圈开始的点。
    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode node = detectCycle(head);
        if (node != null) {
            System.out.println(node.getVal());
        } else {
            System.out.println("null");
        }
    }
}
