package org.kislay.MiddleOfLinkedList;

class MiddleOfLinkedList {

      class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode middleNode(ListNode head) {
          ListNode rabbit = head;
          ListNode hare = head;

          if (rabbit == null) {
              return null;
          }

          while (rabbit.next != null) {
              rabbit = rabbit.next;
              hare = hare.next;
              if (rabbit.next == null) {
                  break;
              }
              rabbit = rabbit.next;
          }
          return hare;
    }
}
