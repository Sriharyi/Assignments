class Node{
    Integer data;
    Node next;
    Node prev;
    Node ()
    {

    }
    Node(Integer data)
    {
        this.data =data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;
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
        Node n = new Node(val);
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
        Node n = new Node(val);
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

    public Integer removeFirst()
    {
        Integer temp = Integer.MIN_VALUE;
        if(head!=null)
        {
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
            }
            tail = tail.prev;
            tail.next = null;
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
            Node n = new Node(val);
            Node itr = head;
            Integer i=0;
            Node prev =null;
            while(itr!=null&& i!=pos)
            {
                prev = itr;
                itr = itr.next;
                i++;
            }
            itr.prev = n;
            n.next = itr;
            prev.next = n;
            n.prev = prev;
            size++;
            return true;
        }
        return false;
    }

    public void reverse()
    {
      head = iterativeReverse(head);
    }
    private Node iterativeReverse(Node head2) {
        Node prevnode = null;
        Node currnode = head2;
        Node nextnode = null;
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
    
    public void traverse()
    {
        if(head!=null)
        {
            Node itr = head;
            while(itr!=null) // or itr == tail
            {
                System.out.print(itr.data+" ");
                itr = itr.next;
            }
            System.out.println();
        }

    }

    public void swapElement(Integer firstpos,Integer secondpos)
    {
        Node firstElement=head,secondElement=head;
        for(int i=0;i<firstpos;i++)
        {
            firstElement=firstElement.next;
        }
        for(int i=0;i<secondpos;i++)
        {
            secondElement = secondElement.next;
        }
        Node temp = new Node(firstElement.data);
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

        




        // Node temp = firstElement.next;
        // firstElement.next = secondElement.next;
        // secondElement.next = temp;
        // temp = firstElement.prev;
        // firstElement.prev = secondElement.prev;
        // secondElement.prev = temp; 
    }

}
