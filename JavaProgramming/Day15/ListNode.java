
//  Definition for singly-linked list.

import java.util.LinkedList;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {

    public ListNode insert(ListNode head,ListNode tail,int val)
    {
        ListNode newNode =  new ListNode(val);
        if(head==null)
        {
            head = newNode;
            tail = newNode;
            return head;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
            return tail;
        }
    }
    public void reorderList(ListNode head) {
        ListNode tail=null;
        LinkedList<Integer> list = new LinkedList<>();
        ListNode temp = head;
        while(temp!=null)
        {
            list.addLast(temp.val);
            temp = temp.next;
        }
        if(head != null)
            head.next = null;
        else
            return;
        tail = head;
        if(!list.isEmpty())
        {
            int frontval = list.removeFirst();
            if(!list.isEmpty())
            {
              int backval = list.removeLast();
              tail = insert(head,tail,backval);
            }
        }
        while(!list.isEmpty())
        {
            int frontval = list.removeFirst();
           tail =  insert(head,tail,frontval);
            if(!list.isEmpty())
            {
                int backval = list.removeLast();
                tail = insert(head,tail,backval);
            }
        }
         while(head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        Solution s = new Solution();
        s.reorderList(head);
        System.out.println();
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}