 class Node{
    Integer data;
    Node next;
    Node(Integer data)
    {
        this.data =data;
        this.next = null;
    }
}
 
 public class QueueList{
   private Node front;
   private Node rear;
   private Integer size;
    QueueList()
    {
        size = 0;
    }
    public Integer getSize()
    {
        return size;
    }
    public void addLast(int val)
    {
        Node n = new Node(val);
        if(front == null)
        {
            front = n;
            rear = n;
        }
        else
        {
            rear.next = n;
            rear = n;
        }
        size++;
    }
    public Integer removeFirst()
    {
        Integer temp = Integer.MIN_VALUE;
        if(front!=null)
        {
            temp = front.data;
            front = front.next;
            size--;
        }
        return temp;
    }

    public void reverse()
    {
      front = recursiveReverse(front);
    }
    private Node recursiveReverse(Node front2) {
        Node prevnode = null;
        Node currnode = front2;
        Node nextnode = null;
        while(currnode!=rear)
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
        rear = front2;
        front2 = prevnode;
        return front2;
    }

    public void traverse()
    {
        if(front!=null)
        {
            Node itr = front;
            while(itr!=rear) // or itr == tail
            {
                System.out.print(itr.data+" ");
                itr = itr.next;
            }
            System.out.print(itr.data+" ");
            System.out.println();
        }

    }

            
}
