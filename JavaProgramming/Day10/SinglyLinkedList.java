import java.util.Scanner;


class SllNode {
    Integer data;
    SllNode next;
    public SllNode(Integer data)
    {
        this.data = data;
    }
}
public class SinglyLinkedList {
    private SllNode head;
    private SllNode tail;
    Integer size;
    SinglyLinkedList()
    {
        size = 0;
    }

    public Integer getSize()
    {
        return size;
    }

    public void addFirst(int val)
    {
        SllNode n = new SllNode(val);
        if (head==null) {
            head = n;
            tail = n;
        }
        else{
            n.next = head;
            head = n;
        }
        size++;
    }

    public void addLast(int val)
    {
        SllNode n = new SllNode(val);
        if (head==null) {
            head = n;
            tail = n;
        }
        else{
            n.next = null;
            tail.next = n;
            tail = n;
        }
        size++;
    }

     public void addAtPosition(Integer pos,Integer val) throws Exception
    {
        if(pos<=0 || pos>(getSize()+1))
            throw new Exception("postion exceed the list size"); //or return false;
        if(pos==1)
        {
            addFirst(val);
        }
        else if(pos==(getSize()+1))
        {
            addLast(val);
        }
        else
        {
            SllNode n = new SllNode(val);
            SllNode itr = head;
            Integer count=1;
            SllNode prev =null;
            while(itr!=null)
            {
                if(count==pos)
                {
                    break;
                }
                count++;
                prev = itr;
                itr = itr.next;
            }
            n.next = itr;
            prev.next = n;
            size++;
        }
    }

    public Integer removeFirst()
    {
        Integer temp = Integer.MIN_VALUE;
        if(head!=null)
        {
            temp = head.data;
            head = head.next;
            size--;
        }
        else if(head==null)
        {
            tail = null;
        }
        return temp;
    }

    public Integer removeLast()
    {
        Integer temp = Integer.MIN_VALUE;
        if(head!=null)
        {
            SllNode itr = head;
            SllNode prev =null;
            while(itr != tail) // or we can use itr != tail or itr!=null && itr.next!=null
            {
                prev = itr;
                itr = itr.next;
            }
            temp = itr.data;
            prev.next =null;
            tail = prev;
            size--;
        }
        return temp;
    }

    public Integer removeAtPos(Integer pos) throws Exception
    {
        if(pos<=0 || pos>getSize())
            throw new Exception("postion cannot be negative or exceed the list size");
        Integer temp  = Integer.MIN_VALUE;
        if(pos==1)
        {
            return removeFirst();
        }    
        else if(pos == getSize())
        {
            return removeLast();
        }
        else{
            SllNode itr = head;
            Integer count=1;
            SllNode prev =null;
            while(itr!=null)
            {
                if(count==pos)
                {
                    break;
                }
                count++;
                prev = itr;
                itr = itr.next;
            }
            temp = itr.data;
            prev.next = itr.next;
            size--;
        }
        return temp;
    }

    public void traverse()
    {
        if(head!=null)
        {
            SllNode itr = head;
            while(itr!=null) // or itr != tail
            {
                System.out.print(itr.data+" ");
                itr = itr.next;
            }
            System.out.println();
        }

    }

    public void reverse()
    {
        if(head!=null)
        head = iterativeReverse(head);
    }
    private SllNode iterativeReverse(SllNode head2) {
        SllNode prevnode = null;
        SllNode currnode = head2;
        SllNode nextnode = null;
        while(currnode!=null)
        {
            nextnode = currnode.next;
            currnode.next = prevnode;
            prevnode = currnode;
            currnode = nextnode;
        }
        tail = head2;
        head2 = prevnode;
        return head2;
    }

    public Boolean isPresent(Integer val)
    {
        if(head!=null)
        {
            SllNode currentNode = head;
            while(currentNode!=null)
            {
                if(currentNode.data == val)
                {
                    return true;
                }
             currentNode=currentNode.next;
            }
        }
        return false;
    }

    public Integer findPosition(Integer val)
    {
        Integer pos = 1;
        if(isPresent(val))
        {

            SllNode currentNode = head;
            while(currentNode!=null)
            {
                if(currentNode.data == val)
                {
                    break;
                }
                pos++;
                currentNode=currentNode.next;
            }
            // if(currentNode==null)
            // {
            //     pos = -1;
            // }
        }else{
                pos = -1;
            }
            return pos;
    }










    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        try (Scanner sc = new Scanner(System.in)) {
            Integer input;
                System.out.println("1 for InsertBegin");
                System.out.println("2 for InsertEnd");
                System.out.println("3 for InsertAtParticularPosition");
                System.out.println("4 for DeleteAtBegin");
                System.out.println("5 for DeleteAtEnd");
                System.out.println("6 for DeleteAtParticularPosition");
                System.out.println("7 for TraverseTheList");
                System.out.println("8 for Reverse the List");
                System.out.println("9 for ListSize");
                System.out.println("10 for SearchElement");
                System.out.println("11 for SwapTheElementbyPosition");
                System.out.println("12 for SwapTheElementbyValue");
                System.out.println("13 for ToExit");
            do {
                System.out.println("Choose the operation?");
                input = sc.nextInt();
                switch(input) {
                    case 1: {
                        System.out.println("Enter the value to be inserted");
                        Integer val = sc.nextInt();
                        list.addFirst(val);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the value to be inserted");
                        Integer val = sc.nextInt();
                        list.addLast(val);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter the position");
                        Integer position = sc.nextInt();
                        System.out.println("Enter the value");
                        Integer value = sc.nextInt();
                        try {
                            list.addAtPosition(position, value);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 4: {
                        System.out.println(list.removeFirst());
                        break;
                    }
                    case 5: {
                        System.out.println(list.removeLast());
                        break;
                    }
                    case 6:{
                        System.out.println("Enter the postion to be deleted");
                        Integer pos = sc.nextInt();
                        try {
                            System.out.println(list.removeAtPos(pos));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 7: {
                        list.traverse();
                        break;
                    }
                    case 8: {
                        list.reverse();
                        break;
                    }
                    case 9: {
                        System.out.println(list.getSize());
                        break;
                    }
                    case 10:
                    {
                        System.out.println("Enter the value to search");
                        Integer val = sc.nextInt();
                        System.out.println(list.findPosition(val));
                        break;
                    }
                    case 11:
                    {
                        System.out.println("Enter the postion1");
                        Integer pos1 = sc.nextInt();
                        System.out.println("Enter the postion2");
                        Integer pos2 = sc.nextInt();
                        try {
                            // list.swapElementbyPos(pos1, pos2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 12:
                    {

                        System.out.println("Enter the value1");
                        Integer val1 = sc.nextInt();
                        System.out.println("Enter the value2");
                        Integer val2 = sc.nextInt();
                        break;
                    }
                    case 13:
                    {
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } while (input != 13);
        }
    }
}












// class Node{
//     Integer data;
//     Node next;
//     public Object left;
//     Node(Integer data)
//     {
//         this.data =data;
//         this.next = null;
//     }
// }

// public class SingleLinkedList {
//     private Node head;
//     private Node tail;
//     private Integer size;
//     SingleLinkedList()
//     {
//         size = 0;
//     }
//     public Integer getSize()
//     {
//         return size;
//     }
    // public void InsertBegin(int val)
    // {
    //     Node n = new Node(val);
    //     if (head==null) {
    //         head = n;
    //         tail = n;
    //     }
    //     else{
    //         n.next = head;
    //         head = n;
    //     }
    //     size++;
    // }

//     public void InsertEnd(int val)
//     {
//         Node n = new Node(val);
//         if(head == null)
//         {
//             head = n;
//             tail = n;
//         }
//         else
//         {
//             tail.next = n;
//             tail = n;
//         }
//         size++;
//     }

//      public void InsertAtPosition(Integer pos,Integer val) throws Exception
//     {
//         if(pos<0 || pos>getSize())
//             throw new Exception("postion exceed the list size"); //or return false;
//         if(pos==0)
//         {
//             InsertBegin(val);
//         }
//         else if(pos==getSize())
//         {
//             InsertEnd(val);
//         }
//         else
//         {
//             Node n = new Node(val);
//             Node itr = head;
//             Integer i=0;
//             Node prev =null;
//             while(itr!=null && i!=pos)
//             {
//                 prev = itr;
//                 itr = itr.next;
//                 i++;
//             }
//             n.next = itr;
//             prev.next = n;
//             size++;
//         }
//     }


    // public Integer DeleteAtBegin()
    // {
    //     Integer temp = Integer.MIN_VALUE;
    //     if(head!=null)
    //     {
    //         temp = head.data;
    //         head = head.next;
    //         size--;
    //     }
    //     return temp;
    // }

    // public Integer DeleteAtEnd()
    // {
    //     Integer temp = Integer.MIN_VALUE;
    //     if(head!=null)
    //     {
    //         Node itr = head;
    //         Node prev =null;
    //         while(itr!=null && itr.next!=null) // or we can use itr != tail
    //         {
    //             prev = itr;
    //             itr = itr.next;
    //         }
    //         temp = itr.data;
    //         prev.next =null;
    //         tail = prev;
    //         size--;
    //     }
    //     return temp;
    // }

    // public Integer DeleteAtPosition(Integer pos) throws Exception
    // {
    //     if(pos<0 || pos>(getSize()-1))
    //         throw new Exception("postion exceed the list size");
    //     Integer temp  = Integer.MIN_VALUE;
    //     if(pos==0)
    //     {
    //         return DeleteAtBegin();
    //     }    
    //     else if(pos == getSize()-1)
    //     {
    //        return DeleteAtEnd();
    //     }
    //     else{
    //         Node itr = head;
    //         Integer i=0;
    //         Node prev =null;
    //         while(itr!=null && i!=pos)
    //         {
    //             prev = itr;
    //             itr = itr.next;
    //             i++;
    //         }
    //         temp = itr.data;
    //         prev.next = itr.next;
    //         size--;
    //     }
    //     return temp;
    // }
//     public void reverse()
//     {
//       head = iterativeReverse(head);
//     }
//     private Node iterativeReverse(Node head2) {
//         Node prevnode = null;
//         Node currnode = head2;
//         Node nextnode = null;
//         while(currnode!=null)
//         {
//             nextnode = currnode.next;
//             currnode.next = prevnode;
//             prevnode = currnode;
//             currnode = nextnode;
//         }
//         tail = head2;
//         head2 = prevnode;
//         return head2;
//     }

//     public void traverse()
//     {
//         if(head!=null)
//         {
//             Node itr = head;
//             while(itr!=null) // or itr == tail
//             {
//                 System.out.print(itr.data+" ");
//                 itr = itr.next;
//             }
//             System.out.println();
//         }

//     }

//     public Boolean isPresent(int val)
//     {
//         if(head!=null)
//         {
//             Node itr = head;
//             while(itr!=null) 
//             {
                
//                 if(itr.data == val)
//                     return true;
//                 itr = itr.next;
//             }
//         }
//         return false;
//     }


//     public Integer findelement(int val)
//     {
//         Integer pos = -1;
//         if(head!=null)
//         {
//             Node itr = head;
//             while(itr!=null) 
//             {
//                 pos++;
//                 if(itr.data == val)
//                     return pos;
//                 itr = itr.next;
//             }
//         }
//         if(pos==getSize()) pos = -1;
//         return pos;
//     }
//     public void movetheelement(Integer oldpos,Integer newpos) throws Exception
//     {
//         Integer temp = DeleteAtPosition(oldpos);
//         InsertAtPosition(newpos, temp);
//     }

// }