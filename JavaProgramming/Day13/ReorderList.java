/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null)
        {
            fast=fast.next;
            if(fast!=null)
            {
                fast=fast.next;
                slow=slow.next;
            }
        }
        slow = reverse(slow);
        head = mergeTwoLists(head,slow);
    }
    public ListNode reverse(ListNode head)
    {
           ListNode prev = null;
           ListNode curr = head;
           ListNode newtnode=null;
           while(curr!=null)
            {
              newtnode = curr.next;
              curr.next = prev;
              prev = curr;
              curr = newtnode;
            }
            return prev; 
    }
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
        ListNode first = list1, second = list2,temp=null;
        while (second.next != null) {
        temp = first.next;
        first.next = second;
        first = temp;

        temp = second.next;
        second.next = first;
        second = temp;
        }
        return list1;
    }
}