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

    public Integer removeFirst()
    {
        Integer temp = Integer.MIN_VALUE;
        if(head!=null)
        {
            if(head.next==null){
                head = null;
                tail = null;
                return temp;
            }
            temp = head.data;
            head = head.next;
            head.prev =tail;
            tail.next = head;
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
            tail.next = head;
            head.prev = tail;
            size--;
        }
        return temp;
    }

    public boolean addAtPostion(Integer pos,Integer val) throws Exception
    {
        if(pos<0 && pos>getSize())
            throw new Exception("postion exceed the list values"); //or return false;
        if(pos==0)
        {
            addFirst(val);
        }
        else if(pos==getSize())
        {
            addLast(val);
        }
        else
        {
            CircularDNode n = new CircularDNode(val);
            CircularDNode itr = head;
            Integer i=0;
            while(itr!=null&& i!=pos)
            {
                itr = itr.next;
                i++;
            }
            CircularDNode prev = itr.prev;

            n.next = itr;
            n.prev = prev;
            prev.next = n;
            itr.prev = n;
            size++;
            return true;
        }
        return false;
    }

    public void reverse()
    {
      head = iterativeReverse(head);
    }
    private CircularDNode iterativeReverse(CircularDNode head2) {
        CircularDNode prevnode = null;
        CircularDNode currnode = head2;
        CircularDNode nextnode = null;
        while(currnode!=tail)
        {
            nextnode = currnode.next;
            currnode.next = prevnode;
            prevnode = currnode;
            currnode = nextnode;
        }
            nextnode = currnode.next;
            currnode.next = prevnode;
            prevnode = currnode;
            currnode = nextnode;
        return prevnode;
        
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

    public void swapElement(Integer firstpos,Integer secondpos)
    {
        CircularDNode firstElement=head,secondElement=head;
        for(int i=0;i<firstpos;i++)
        {
            firstElement=firstElement.next;
        }
        for(int i=0;i<secondpos;i++)
        {
            secondElement = secondElement.next;
        }
        CircularDNode temp = new CircularDNode(firstElement.data);
        temp.next = firstElement.next;
        temp.prev = firstElement.prev;

        firstElement.next = secondElement.next;
        firstElement.prev = secondElement.prev;
        if(firstElement.next!=null)
            firstElement.next.prev = firstElement;
        if(firstElement.prev!=null)
            firstElement.prev.next =firstElement;

        secondElement.next = temp.next;
        secondElement.prev = temp.prev;

        if(secondElement.next!=null)
            secondElement.next.prev = secondElement;
        if(secondElement.prev!=null)
            secondElement.prev.next = secondElement;
    }
    public Integer findPosition(int value)
    {
        Integer pos = 0;
        if(head!=null)
        {
            CircularDNode currCircularDNode  = head;
            while(currCircularDNode!=null)
            {
                if(currCircularDNode.data == value)
                {
                    break;
                }
                pos++;
                currCircularDNode = currCircularDNode.next;
            }
        }
        return pos;
    }

    public void swapElementbyValue(Integer value1,Integer value2)
    {
        int pos1 = findPosition(value1);
        int pos2 = findPosition(value2);
        swapElement(pos1, pos2);
    }
    static CircularDoublyLinkedList cllist;
    public static void main(String[] args) {
        cllist  = new CircularDoublyLinkedList();
        cllist.CDllOperation();
    }
    Scanner sc = new Scanner(System.in);
    Integer input;
    private void CDllOperation() {
        System.out.println("1 for InsertBegin");
        System.out.println("2 for InsertEnd");
        System.out.println("3 for InsertAtParticularPosition");
        System.out.println("4 for DeleteAtBegin");
        System.out.println("5 for DeleteAtEnd");
        System.out.println("6 for TraverseTheList");
        System.out.println("7 for FindthePositionofElement");
        System.out.println("8 for swaptheelement-from onepos to anotherpos");
        System.out.println("9 for swaptheelement-by using two values");
        System.out.println("10 for To Exit");
        input = sc.nextInt();
        switch(input)
        {
            case 1:
            {
                 System.out.println("Enter the value to be inserted");
                 Integer val  = sc.nextInt();
                 cllist.addFirst(val);
                 CDllOperation();
                 break;
            }
            case 2:
            {
                 System.out.println("Enter the value to be inserted");
                 Integer val  = sc.nextInt();
                 cllist.addLast(val);
                 CDllOperation();
                 break;
            }
            case 3:
            {
                    System.out.println("Enter the value to be inserted");
                    Integer val  = sc.nextInt();
                    System.out.println("Enter the position to be Inserted");
                    Integer pos = sc.nextInt();
                    try {
                        cllist.addAtPostion(pos, val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    CDllOperation();
            }
            case 4:
            {
                    System.out.println(cllist.removeFirst());
                    CDllOperation();
                    break;
            }
            case 5:
            {
                    System.out.println(cllist.removeLast());
                    CDllOperation();
                    break;
            }
            case 6:
            {
                    cllist.traverse();
                    cllist.reverse();
                    cllist.traverse();
                    CDllOperation();
                    break;
            }
            case 7:
            {
                System.out.println("Enter the value");
                 Integer val  = sc.nextInt();
                 System.out.println(cllist.findPosition(val));
                 CDllOperation();
                 break;
            }
            case 8:
            {
                System.out.println("Enter the position 1");
                Integer pos1 = sc.nextInt();
                System.out.println("Enter the position 2");
                Integer pos2 = sc.nextInt();
                cllist.swapElement(pos1, pos2);
                CDllOperation();
                break;
            }
            case 9:
            {
                System.out.println("Enter the value 1");
                Integer val1 = sc.nextInt();
                System.out.println("Enter the value 2");
                Integer val2 = sc.nextInt();
                cllist.swapElementbyValue(val1, val2);
                CDllOperation();
                break;
            }
            case 10:
            {
                break;
            }
            default:
            {
                CDllOperation();
            }
        }
    }
}
