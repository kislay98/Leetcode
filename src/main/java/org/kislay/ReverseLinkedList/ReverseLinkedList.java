package org.kislay.ReverseLinkedList;

class ReverseLinkedList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prevPtr = head, currPtr = head.next;;
        prevPtr.next = null;
        while (currPtr != null) {
            ListNode temp = currPtr;
            currPtr = currPtr.next;
            temp.next = prevPtr;
            prevPtr = temp;
        }
        return prevPtr;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseLinkedList.reverseList(node1);
    }

}
