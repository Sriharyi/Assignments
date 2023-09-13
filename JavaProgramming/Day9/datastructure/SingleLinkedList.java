class Node{
    Integer data;
    Node next;
    public Object left;
    Node(Integer data)
    {
        this.data =data;
        this.next = null;
    }
}

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private Integer size;
    SingleLinkedList()
    {
        size = 0;
    }
    public Integer getSize()
    {
        return size;
    }
    public void InsertBegin(int val)
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
        size++;
    }

    public void InsertEnd(int val)
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
        size++;
    }

     public void InsertAtPosition(Integer pos,Integer val) throws Exception
    {
        if(pos<0 || pos>getSize())
            throw new Exception("postion exceed the list size"); //or return false;
        if(pos==0)
        {
            InsertBegin(val);
        }
        else if(pos==getSize())
        {
            InsertEnd(val);
        }
        else
        {
            Node n = new Node(val);
            Node itr = head;
            Integer i=0;
            Node prev =null;
            while(itr!=null && i!=pos)
            {
                prev = itr;
                itr = itr.next;
                i++;
            }
            n.next = itr;
            prev.next = n;
            size++;
        }
    }


    public Integer DeleteAtBegin()
    {
        Integer temp = Integer.MIN_VALUE;
        if(head!=null)
        {
            temp = head.data;
            head = head.next;
            size--;
        }
        return temp;
    }

    public Integer DeleteAtEnd()
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
            size--;
        }
        return temp;
    }

    public Integer DeleteAtPosition(Integer pos) throws Exception
    {
        if(pos<0 || pos>(getSize()-1))
            throw new Exception("postion exceed the list size");
        Integer temp  = Integer.MIN_VALUE;
        if(pos==0)
        {
            return DeleteAtBegin();
        }    
        else if(pos == getSize()-1)
        {
           return DeleteAtEnd();
        }
        else{
            Node itr = head;
            Integer i=0;
            Node prev =null;
            while(itr!=null && i!=pos)
            {
                prev = itr;
                itr = itr.next;
                i++;
            }
            temp = itr.data;
            prev.next = itr.next;
            size--;
        }
        return temp;
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

    public Boolean isPresent(int val)
    {
        if(head!=null)
        {
            Node itr = head;
            while(itr!=null) 
            {
                
                if(itr.data == val)
                    return true;
                itr = itr.next;
            }
        }
        return false;
    }


    public Integer findelement(int val)
    {
        Integer pos = -1;
        if(head!=null)
        {
            Node itr = head;
            while(itr!=null) 
            {
                pos++;
                if(itr.data == val)
                    return pos;
                itr = itr.next;
            }
        }
        if(pos==getSize()) pos = -1;
        return pos;
    }
    public void movetheelement(Integer oldpos,Integer newpos) throws Exception
    {
        Integer temp = DeleteAtPosition(oldpos);
        InsertAtPosition(newpos, temp);
    }

}
