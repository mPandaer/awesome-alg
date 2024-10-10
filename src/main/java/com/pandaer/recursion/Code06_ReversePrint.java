package com.pandaer.recursion;

public class Code06_ReversePrint {


    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void print() {
            System.out.print(this.val + " ");
        }
    }

    public void reversePrint(ListNode head) {
        head = reverseNode(head);

        while (head != null) {
            head.print();
            head = head.next;
        }
    }

    public ListNode reverseNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseNode(next);
        // 将head节点摘下来
        head.next = null;
        next.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        new Code06_ReversePrint().reversePrint(head);
    }
}
