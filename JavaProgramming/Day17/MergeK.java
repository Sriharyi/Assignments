
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeK {
    // public ListNode mergeKLists(ListNode[] lists) {
    //     ListNode head=null;
    //     for(ListNode i:lists) // O(n) because the lists array has N No of sorted list 
    //     {
    //         head=mergetwoLists(head,i);
    //     }
    //     return head;
    // }
    

    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists,0,lists.length-1);
    }
    public ListNode partition(ListNode[] lists,int low,int high)
    {
        if(low==high) return lists[low];
        if(low<high)
        {
           int mid = low + (high - low)/2;
           ListNode l1 =  partition(lists,low,mid);
           ListNode l2 =  partition(lists,mid+1,high);
           return mergetwoLists(l1,l2);
        }
        return null;
    }
    public ListNode mergetwoLists(ListNode list1,ListNode list2)
    {
        ListNode head=null;
        ListNode tail = null;
        if(list1==null)return list2;
        if(list2==null)return list1;
        if(list1.val<=list2.val)
        {
            head=list1;
            tail=list1;
            list1=list1.next;
        }
        else{
            head=tail=list2;
            list2=list2.next;
        }
        while(list1!=null && list2!=null) // here we iterate the list1 and list2 which takes O(2n) tc  
        {                                   //so the total tc will be O(n^2);
            if(list1.val<=list2.val)
            {
                tail.next=list1;
                // tail = list1;
                list1=list1.next;
            }
            else{
                tail.next=list2;
                // tail = list2;
                list2=list2.next;
            }
            tail=tail.next;
        }
        if(list1==null)
            tail.next=list2;
        if(list2==null)
            tail.next=list1;
        return head;
    }
}