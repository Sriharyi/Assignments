import java.util.Scanner;

class CircularDNode{
    Integer data;
    CircularDNode next;
    CircularDNode prev;
    CircularDNode ()
    {

    }
    CircularDNode(Integer data)
    {
        this.data =data;
        this.next = null;
        this.prev = null;
    }
}

public class CircularDoublyLinkedList {
    private CircularDNode head;
    private CircularDNode tail;
    private Integer size;
    CircularDoublyLinkedList()
    {
        size = 0;
    }
    public Integer getSize()
    {
        return size;
    }
    public void addFirst(int val)
    {
        CircularDNode n = new CircularDNode(val);
        if (head==null) {
            head = n;
            tail = n;
        }
        else{
            head.prev =n;
            n.next = head;
            n.prev = tail;
            tail.next = n;
            head = n;
        }
        size++;
    }

    public void addLast(int val)
    {
        CircularDNode n = new CircularDNode(val);
        if(head == null)
        {
            head = n;
            tail = n;
        }
        else
        {
            n.prev = tail;
            n.next = head;
            head.prev = n;
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public void addAtPosition(Integer pos,Integer val) throws Exception
    {
        if(pos<1 || (pos>getSize()+1))
            throw new Exception("postion exceed the list values"); //or return false;
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
            CircularDNode n = new CircularDNode(val);
            CircularDNode itr = head;
            Integer count=1;
            while(itr!=tail)
            {
                if(count==pos)
                    break;
                count++;
                itr = itr.next;
            }
            if(itr==tail && count==pos)
            {
                addLast(val);
            }

            CircularDNode prev = itr.prev;
            n.next = itr;
            n.prev = prev;
            prev.next = n;
            itr.prev = n;
            size++;
        }
    }
    public Integer removeFirst()
    {
        Integer temp = Integer.MIN_VALUE;
        if(head!=null)
        {
            if(head.next==null){
                temp=head.data;
                head = null;
                tail = null;
            }
            else{
                
                temp = head.data;
                head = head.next;
                head.prev =tail;
                tail.next = head;
            }
            size--;
        }
        return temp;
    }

    public Integer removeLast()
    {
        Integer temp = Integer.MIN_VALUE;
        if(head!=null)
        {
            if(tail.prev==null){
                temp=tail.data;
                tail = null;
                head = null;
                
            }
            else{
                temp = tail.data;
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
            }
            size--;
        }
        return temp;
    }

     public Integer removeAtPos(Integer pos) throws Exception
    {
        if(pos<1 || pos>getSize())
            throw new Exception("postion exceed the list values"); //or return false;

        Integer temp = Integer.MIN_VALUE;
        if(pos==1)
        {
           return removeFirst();
        }
        else if(pos==getSize())
        {
            return removeLast();
        }
        else
        {
            CircularDNode itr = head;
            Integer count=1;
            while(itr!=tail)
            {
                if(count==pos)
                    break;
                count++;
                itr = itr.next;
            }
            if(itr==tail && count==pos)
            {
               removeLast();
            }

            CircularDNode prevNode = itr.prev;
            CircularDNode nextNode = itr.next;
            temp = itr.data;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
        return temp;
    }
    

    public void reverse()
    {
      head = iterativeReverse(head);
    }
    private CircularDNode iterativeReverse(CircularDNode head2) {
        CircularDNode currNode = head2;
        CircularDNode temp = null;
         while(currNode!=tail)
         {
             temp = currNode.prev;
             currNode.prev = currNode.next;
             currNode.next = temp;
             currNode = currNode.prev;
         }
             temp = currNode.prev;
             currNode.prev = currNode.next;
             currNode.next = temp;
             currNode = currNode.prev;
        tail = head;
         if (temp != null) {
             head2 = temp.prev;
         }
         return head2;
    }
    
    public void traverse()
    {
        if(head!=null)
        {
            CircularDNode itr = head;
            while(itr!=tail) // or itr == tail
            {
                System.out.print(itr.data+" ");
                itr = itr.next;
            }
             System.out.print(itr.data+" ");
            System.out.println();
        }

    }
    public Boolean isPresent(Integer val)
    {
        if(head!=null)
        {
            CircularDNode currentNode = head;
            while(currentNode!=tail)
            {
                if(currentNode.data == val)
                {
                    return true;
                }
             currentNode=currentNode.next;
            }
            if(currentNode==tail)
            {
                if(currentNode.data == val)
                    return true;
            }
        }
        return false;
    }
    public Integer findPosition(int value)
    {
        Integer pos = 1;
        if(isPresent(value))
        {
            CircularDNode currCircularDNode  = head;
            while(currCircularDNode!=tail)
            {
                if(currCircularDNode.data == value)
                {
                    break;
                }
                pos++;
                currCircularDNode = currCircularDNode.next;
            }
            if(currCircularDNode==tail){
                if(currCircularDNode.data == value)
                        return pos;
            }
        }
        else{
            pos =-1;
        }
        return pos;
    }
    public void swapElementbyPos(Integer firstpos,Integer secondpos) throws Exception
    {
        if(firstpos<1 || firstpos>getSize())
        {
            throw new Exception("size cannot be negative or exceed the list the size");
        }

        if(secondpos<1 || secondpos>getSize())
        {
            throw new Exception("size cannot be negative or exceed the list the size");
        }
        if(head==null || head.next == null || firstpos==secondpos)
        {
            return ;
        }
        
        CircularDNode firstElement=head,secondElement=head;
        for(int i=1;i<firstpos;i++)
        {
            firstElement=firstElement.next;
        }

        for(int i=1;i<secondpos;i++)
        {
            secondElement = secondElement.next;
        }

         if(firstElement==head)
        {
            head = secondElement;
        }else if(secondElement==head)
        {
            head = firstElement;
        }

        if(firstElement==tail)
        {
            tail=secondElement;
        }
        else if(secondElement == tail)
        {
            tail=firstElement;
        }
       
        
        CircularDNode temp = firstElement.next;
        firstElement.next = secondElement.next;
        secondElement.next = temp;

        if(firstElement.next!=null)
            firstElement.next.prev = firstElement;
        if(secondElement.next!=null)
            secondElement.next.prev = secondElement;
        
        temp = firstElement.prev;
        firstElement.prev = secondElement.prev;
        secondElement.prev = temp;

        if(firstElement.prev != null)
        {
            firstElement.prev.next = firstElement;
        }
        if(secondElement.prev != null)
        {
            secondElement.prev.next = secondElement;
        }
    }
    public void swapElementbyValue(Integer value1,Integer value2) throws Exception
    {
        int pos1 = findPosition(value1);
        int pos2 = findPosition(value2);
        try {
            swapElementbyPos(pos1, pos2);
        } catch (Exception e) {
            throw new Exception("values not found");
        }
    }
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
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
                System.out.println("the list Elements are :");
                list.addFirst(1);
                list.addFirst(2);
                list.addFirst(3);
                list.addFirst(4);
                list.addFirst(5);
                list.traverse();
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
                            list.swapElementbyPos(pos1, pos2);
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
                        try {
                            list.swapElementbyValue(val1, val2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
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