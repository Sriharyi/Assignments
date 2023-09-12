class Node{
    Integer data;
    Node next;
    Node(Integer data)
    {
        this.data =data;

    }
}

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private Integer size;

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
            n.next = head;
            head = n;
        }
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
            tail.next = n;
            tail = n;
        }
    }

    public Integer removeFirst()
    {
        Integer temp = Integer.MIN_VALUE;
        if(head!=null)
        {
            temp = head.data;
            head = head.next;
        }
        return temp;
    }

    public Integer removeLast()
    {
        Integer temp = Integer.MIN_VALUE;
        if(head!=null)
        {
            Node itr = head;
            Node prev =null;
            while(itr!=null && itr.next!=null) // or we can use itr != tail
            {
                prev = itr;
                itr = itr.next;
            }
            temp = itr.data;
            prev.next =null;
            tail = prev;
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
            n.next = itr;
            prev.next = n;
            return true;
        }
        return false;
    }

    public void reverse()
    {
      head = recursiveReverse(head);
    }
    private Node recursiveReverse(Node head2) {
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

    // public void movetheelement()
    // {

    // }

}
