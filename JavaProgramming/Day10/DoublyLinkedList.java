import java.util.Scanner;

class DllNode{
    Integer data;
    DllNode next;
    DllNode prev;
    DllNode(Integer data)
    {
        this.data =data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    private DllNode head;
    private DllNode tail;
    private Integer size;
    DoublyLinkedList()
    {
        size = 0;
    }
    public Integer getSize()
    {
        return size;
    }

    public void addFirst(int val)
    {
        DllNode n = new DllNode(val);
        if (head==null) {
            head = n;
            tail = n;
        }
        else{
            head.prev = n;
            n.next = head;
            head = n;
        }
        size++;
    }

    public void addLast(int val)
    {
        DllNode n = new DllNode(val);
        if(head == null)
        {
            head = n;
            tail = n;
        }
        else
        {
            n.prev = tail;
            tail.next = n;
            tail = n;
        }
        size++;
    }

    

    public void addAtPosition(Integer pos,Integer val) throws Exception
    {
        if(pos<=0 || pos>(getSize()+1))
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
            DllNode n = new DllNode(val);
            DllNode itr = head;
            Integer count=1;
            DllNode prev=null;
            while(itr!=null)
            {
                if(count == pos)
                    break;
                count++;
                prev = itr;
                itr = itr.next;
            }
            itr.prev = n;
            n.next = itr;
            prev.next = n;
            n.prev = prev;
            size++;
        }
    }

    public Integer removeFirst()
    {
        Integer temp = Integer.MIN_VALUE;
        if(head!=null)
        {
            if(head.next == null)
            {
                head = null;
                tail = null;
                return temp;
            }
            temp = head.data;
            head = head.next;
            head.prev =null;
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
                tail = null;
                head = null;
                return temp;
            }
            temp = tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return temp;
    }

    public Integer removeAtPos(Integer pos) throws Exception
    {
        if(pos<=0 || pos>(getSize()+1))
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
            DllNode itr = head;
            Integer count=1;
            DllNode prev=null;
            while(itr!=null)
            {
                if(count == pos)
                    break;
                count++;
                itr = itr.next;
            }
            prev = itr.prev;
            prev.next = itr.next;
            itr.next.prev = prev;
            size--;
        }
        return temp;
    }


    public void traverse()
    {
        if(head!=null)
        {
            DllNode itr = head;
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
      head = iterativeReverse(head);
    }
    private DllNode iterativeReverse(DllNode head2) {
       DllNode currNode = head2;
       DllNode temp = null;
        while(currNode!=null)
        {
            temp = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = temp;
            currNode = currNode.prev;
        }
        if (temp != null) {
            head2 = temp.prev;
        }
        return head2;
    }

    public Boolean isPresent(Integer val)
    {
        if(head!=null)
        {
            DllNode currentNode = head;
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

            DllNode currentNode = head;
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


    public void swapElementbyPos(Integer firstpos,Integer secondpos)
    {
        if(head==null || head.next == null || firstpos==secondpos)
        {
            return ;
        }
        DllNode firstElement=head,secondElement=head;
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
            secondElement = tail;
        }
        else if(secondElement == tail)
        {
            firstElement = tail;
        }
        DllNode temp = new DllNode(firstElement.data);
        temp.next = firstElement.next;
        temp.prev = firstElement.prev;

        firstElement.next = secondElement.next;
        firstElement.prev = secondElement.prev;

        firstElement.next.prev = firstElement;
        firstElement.prev.next =firstElement;

        secondElement.next = temp.next;
        secondElement.prev = temp.prev;

        secondElement.next.prev = secondElement;
        secondElement.prev.next = secondElement;
    }
    public static void main(String[] args) {
         DoublyLinkedList list = new DoublyLinkedList();
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
