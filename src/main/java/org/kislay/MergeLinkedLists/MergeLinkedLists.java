package org.kislay.MergeLinkedLists;

class MergeLinkedLists {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode currPointer = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currPointer.next = list1;
                list1 = list1.next;
            } else {
                currPointer.next = list2;
                list2 = list2.next;
            }
            currPointer = currPointer.next;
        }
        if (list1 != null) {
            currPointer.next = list1;
        } else {
            currPointer.next = list2;
        }
        return dummy.next;
  }

    public static void main(String[] args) {
        MergeLinkedLists mergeLinkedLists = new MergeLinkedLists();
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node1.next = node3;
        node3.next = node5;
        ListNode node2 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        node2.next = node4;
        node4.next = node6;


        ListNode node = mergeLinkedLists.mergeTwoLists(node1, node2);
        System.out.println(1);
    }

}
