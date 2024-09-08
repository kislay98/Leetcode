package org.kislay.CycleInLinkedList;

class CycleInLinkedList {



  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public boolean hasCycle(ListNode head) {
      if (head == null) return false;
      ListNode tortoise = head;
      ListNode hare = head;
      while (hare != null && tortoise != null) {
          tortoise = tortoise.next;
          hare = hare.next;
          if (hare == null) {
              return false;
          }
          hare = hare.next;
          if (hare == tortoise) return true;
      }
      return false;
    }

}
