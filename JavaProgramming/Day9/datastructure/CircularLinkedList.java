import java.util.Scanner;

class Node {
    Integer data;
    Node next;

    Node(Integer data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private Integer size;

    CircularLinkedList() {
        size = 0;
    }

    public Integer getSize() {
        return size;
    }

    public void addFirst(int val) {
        Node n = new Node(val);
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
        Node n = new Node(val);
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
                return temp;
            }
            head = head.next;
            tail.next = head;
            size--;
        }
        return temp;
    }

    public Integer removeLast() {
        Integer temp = Integer.MIN_VALUE;
        if (head != null) {
            Node itr = head;
            Node prev = null;
            while (itr != tail) // or we can use itr != tail
            {
                prev = itr;
                itr = itr.next;
            }
            temp = itr.data;
            tail = prev;
            tail.next = head;
            size--;
        }
        return temp;
    }

    public boolean addAtPostion(Integer pos, Integer val) throws Exception {
        if (pos < 0 || pos > getSize())
            throw new Exception("postion exceed the list values"); // or return false;
        if (pos == 0) {
            addFirst(val);
        } else if (pos == getSize()) {
            addLast(val);
        } else {
            // Node n = new Node(val);
            // Node itr = head;
            // Integer i = 0;
            // Node prev = null;
            // while (itr != tail && i != pos) {
            //     prev = itr;
            //     itr = itr.next;
            //     i++;
            // }
            // n.next = itr;
            // prev.next = n;
            // size++;
            return true;
        }
        return false;
    }

    public void reverse() {
        head = iterativeReverse(head);
    }

    private Node iterativeReverse(Node head2) {
        Node prevnode = null;
        Node currnode = head2;
        Node nextnode = null;
        while (currnode != tail) {
            nextnode = currnode.next;
            currnode.next = prevnode;
            prevnode = currnode;
            currnode = nextnode;
        }
        nextnode = currnode.next;
        currnode.next = prevnode;
        prevnode = currnode;
        currnode = nextnode;
        tail = head2;
        head2 = prevnode;
        return head2;
    }

    public void traverse() {
        if (head != null) {
            Node itr = head;
            while (itr != tail) // or itr == tail
            {
                System.out.print(itr.data + " ");
                itr = itr.next;
            }
            System.out.print(itr.data + " ");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        CircularLinkedList cllist = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        Integer input;
        // cllist.addFirst(2);
        // cllist.addFirst(3);
        // cllist.addFirst(4);
        // cllist.addFirst(5);
        // cllist.addFirst(6);
        // System.out.println(cllist.getSize());
        // try {
        //     cllist.traverse();
        //     System.out.println(cllist.getSize());
        //     cllist.addAtPostion(0, 7);
        //     cllist.addAtPostion(cllist.getSize(), 1);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // cllist.traverse();
        // System.out.println(cllist.getSize());
        do {
            System.out.println("1 for InsertBegin");
            System.out.println("2 for InsertEnd");
            System.out.println("3 for InsertAtParticularPosition");
            System.out.println("4 for DeleteAtBegin");
            System.out.println("5 for DeleteAtEnd");
            System.out.println("6 for TraverseTheList");
            System.out.println("7 for Reverse the List");
            System.out.println("8 for To Exit");
            input = sc.nextInt();
            switch (input) {
                case 1: {
                    System.out.println("Enter the value to be inserted");
                    Integer val = sc.nextInt();
                    cllist.addFirst(val);
                    break;
                }
                case 2: {
                    System.out.println("Enter the value to be inserted");
                    Integer val = sc.nextInt();
                    cllist.addLast(val);
                    break;
                }
                case 3: {
                    System.out.println("Enter the value to be inserted");
                    Integer val = sc.nextInt();
                    System.out.println("Enter the position to be Inserted");
                    Integer pos = sc.nextInt();
                    try {
                        cllist.addAtPostion(pos, val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 4: {
                    System.out.println(cllist.removeFirst());
                    break;
                }
                case 5: {
                    System.out.println(cllist.removeLast());
                    break;
                }
                case 6: {
                    cllist.traverse();
                    break;
                }
                case 7: {
                    cllist.reverse();
                    break;
                }
                case 8: {
                    break;
                }
                default: {
                    break;
                }
            }
        } while (input != 8);
    }
}