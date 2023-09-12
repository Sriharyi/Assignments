class StackNode {
    
    Integer data;
    StackNode next;
    StackNode(Integer data)
    {
        this.data = data;
        this.next = null;
    }
}
public class Stack{
    private StackNode vstack;
    private Integer size;
    Stack()
    {
        size = 0;
    }
    public void push(int val)
    {
        StackNode temp = new StackNode(val);
        if(vstack == null)
        {
            vstack = temp;
        }
        else
        {
            temp.next = vstack;
            vstack = temp;
        }
        size++;
    }

    public Integer pop() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("Stack is Empty");
        }
        Integer temp = vstack.data;
        vstack = vstack.next;
        size--;
        return temp;
    }


    public Integer peek() throws Exception
    {
        if(isEmpty())
        {
            throw new Exception("Stack is Empty");
        }
        return vstack.data;
    }

    public void reverse()
    {
        vstack = iterativeReverse(vstack);
    }

    private StackNode iterativeReverse(StackNode vstack2) {
        StackNode prevnode = null;
        StackNode currnode = vstack2;
        StackNode nextnode = null;
        while(currnode!=null)
        {
            nextnode = currnode.next;
            currnode.next = prevnode;
            prevnode = currnode;
            currnode = nextnode;
        }
        vstack2 = prevnode;
        return vstack2;
    }
    public Integer getSize(){
        return size;
    }

    public boolean isEmpty() {
        if(vstack == null && size==0)
            return true;
        return false;
    }
    @Override
    public String toString() {
        return "Stack [vstack=" + vstack + ", size=" + size + "]";
    }

   
}
