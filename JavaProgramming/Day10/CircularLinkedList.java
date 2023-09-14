import java.util.Scanner;

class CllNode{
    Integer data;
    CllNode next;
    CllNode(Integer data)
    {
        this.data = data;
    }
}

public class CircularLinkedList{
    private CllNode head;
    private  CllNode tail;
    private Integer size;
    public CircularLinkedList()
    {
        size = 0;
    }

    public Integer getSize()
    {
        return size;
    }

    public void addFirst(int val) {
        CllNode n = new CllNode(val);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head = n;
            tail.next = n;
        }
        size++;
    }

    public void addLast(int val) {
        CllNode n = new CllNode(val);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
            n.next = head;
        }
        size++;
    }


    public Integer removeFirst() {
        Integer temp = Integer.MIN_VALUE;
        if (head != null) {
            temp = head.data;
            if (head == tail) {
                tail = null;
                head = null;
            }
            else{
                head = head.next;
                tail.next = head;
            }
            size--;
        }
        return temp;
    }

        public Integer removeLast() {
        Integer temp = Integer.MIN_VALUE;
        if (head != null) {
            CllNode itr = head;
            CllNode prev = null;
            while (itr != tail)
            {
                prev = itr;
                itr = itr.next;
            }
            temp = itr.data;
            itr.next = null;
            tail = prev;
            tail.next = head;
            size--;
        }
        return temp;
    }
        public Integer removeAtPos(Integer pos) throws Exception {
            Integer temp = Integer.MIN_VALUE;
            if(head!=null)
            {
                if (pos <= 0 || pos > getSize())
                    throw new Exception("postion exceed the list values"); 
                if(pos==1){
                    temp = removeFirst();
                }
                else if(pos == getSize())
                {
                    temp = removeLast();
                }
                else{
                    CllNode currNode = head;
                    Integer count = 1;
                    CllNode previousNode = null;
                    while(currNode!=tail)
                    {
                        if(count==pos)
                        {
                            break;
                        }
                        count++;
                        previousNode=currNode;
                        currNode=currNode.next;
                    }
                    previousNode.next = currNode.next;
                    currNode.next = null;
                    temp = currNode.data;
                    size--;
                }
            }
            return temp;
        }
        
        public void traverse() {
        if (head != null) {
            CllNode itr = head;
            while (itr != tail)
            {
                System.out.print(itr.data + " ");
                itr = itr.next;
            }
            System.out.print(itr.data + " ");
            System.out.println();
        }

    }

        public void addAtPosition(Integer pos, Integer val) throws Exception {
        if (pos <= 0 || pos > (getSize()+1))
            throw new Exception("postion exceed the list values"); // or return false;
        if (pos == 1) {
            addFirst(val);
        } else if (pos == (getSize()+1)) {
            addLast(val);
        } else {
            CllNode newNode = new CllNode(val);
            CllNode iterator = head;
            CllNode previosNode = null;
            Integer count=1;
            while(iterator!=tail)
            {
                if(count==pos)
                {
                    break;
                }
                count++;
                previosNode = iterator;
                iterator=iterator.next;
            }
            newNode.next = iterator;
            previosNode.next = newNode;
            size++;
        }
    }

    public void reverse() {
        head = iterativeReverse(head);
    }

    private CllNode iterativeReverse(CllNode head2) {
        CllNode prevnode = tail;
        CllNode currnode = head2;
        CllNode nextnode = null;
        while (currnode != tail) {
            nextnode = currnode.next;
            currnode.next = prevnode;
            prevnode = currnode;
            currnode = nextnode;
        }
        currnode.next = prevnode;
        tail = head2;
        head2 = currnode;
        return head2;
    }

    public Boolean isPresent(Integer val)
    {
        if(head != null)
        {
            CllNode iterator = head;
            while(iterator!=tail)
            {
                if(iterator.data == val)
                {
                    return true;
                }
                iterator=iterator.next;
            }
            if(iterator.data == val)
            {
                return true;
            }
        }
        return false;
    }

    public Integer findPosition(Integer val)
    {
        Integer pos = 1;
        if(isPresent(val))
        {
            CllNode iterator = head;
            while(iterator!=tail)
            {
                if(iterator.data == val)
                {
                    return pos;
                }
                pos++;
                iterator=iterator.next;
            }
            if(iterator.data == val)
            {
                return pos;
            }
        }
        else
        {
            pos = -1;
        }
        return pos;
    }

    public void swapElementbyPos(Integer position1,Integer position2) throws Exception
    {
        if(position1<=0 || position1>getSize())
            throw new Exception("postion cannot be negative or exceed the list values");
        if(position2<=0 || position2>getSize())
            throw new Exception("postion cannot be negative or exceed the list values");
        if(head==null || head.next==null ||position1==position2)
        {
            return;
        }
        CllNode firstElement,secondElement,firstElementPrev,secondElementPrev;
        Integer count1,count2;
        firstElement = head;
        secondElement = head;
        firstElementPrev =null;
        secondElementPrev=null;
        count1=1;
        count2=1;
        while(firstElement!=tail)
        {
            if(count1==position1)
                break;
            count1++;
            firstElementPrev = firstElement;
            firstElement = firstElement.next;
        }
        if(firstElement==tail)
        {
            if(count1!=position1)
                return;
                
        }
         while(secondElement!=tail)
        {
            if(count2==position2)
                break;
            count2++;
            secondElementPrev = secondElement;
            secondElement = secondElement.next;
        }
        if(secondElement==tail)
        {
             if(count2!=position2)  
                return ;    
        }

        if(firstElement==head)
        {
            head=secondElement;
            
        }
        else if(secondElement==head)
        {
            head = firstElement;
        }

        if(firstElement==tail)
        {
            tail = secondElement;
        }
        else if(secondElement==tail)
        {
            tail = firstElement;
        }

        if(firstElementPrev!=null)
        {
            firstElementPrev.next = secondElement;
        }
        
        if(secondElementPrev!=null)
        {
            secondElementPrev.next = firstElement;
        }

        CllNode temp = firstElement.next;
        firstElement.next = secondElement.next;
        secondElement.next = temp;
    }


    public void swapElementbyValue(Integer val1,Integer val2) throws Exception
    {
        Integer pos1 = findPosition(val1);
        Integer pos2 = findPosition(val2);
        try {
            swapElementbyPos(pos1, pos2);
        } catch (Exception e) {
            throw new Exception("values not found");
        }
    }


    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
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
