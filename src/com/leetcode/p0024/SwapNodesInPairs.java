package com.leetcode.p0024;

// 24. 两两交换链表中的节点

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
        SwapNodesInPairs.ListNode head = new SwapNodesInPairs.ListNode(1);
        head.next = new SwapNodesInPairs.ListNode(2);
        head.next.next = new SwapNodesInPairs.ListNode(3);
        head.next.next.next = new SwapNodesInPairs.ListNode(4);
//        head.next.next.next.next = new SwapNodesInPairs.ListNode(5);

        System.out.println(head);
        System.out.println(swapPairs(head));
    }

    public static class ListNode {
        int val;
        SwapNodesInPairs.ListNode next;
        ListNode() {}
        ListNode(int x) {
            val = x;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            SwapNodesInPairs.ListNode current = this;
            StringBuilder sb = new StringBuilder();

            sb.append(String.valueOf(current.val));

            while (current.next != null) {
                current = current.next;
                sb.append(" -> ");
                sb.append(String.valueOf(current.val));
            }

            sb.append(" -> NULL");

            return sb.toString();
        }
    }
}
