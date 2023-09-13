import java.util.Scanner;

public class EgClass {
    Scanner sc = new Scanner(System.in);
    Integer input;
    private SingleLinkedList list = new SingleLinkedList();
    private Stack stack = new Stack();
    private CircularDoublyLinkedList cllist = new CircularDoublyLinkedList();
    public static void main(String[] args) throws Exception {
        
        EgClass eg = new EgClass();
        String operation;
        operation = eg.chooseOperation();
        if(!operation.equals("Exit"))
            eg.doOperation(operation);
    }
    private String chooseOperation() {
        System.out.println("1 for Singlelinkedlist");
        System.out.println("2 for Circularlinkedlist");
        System.out.println("3 for Doublylinkedlist");
        System.out.println("4 for CircularDoublylinkedlist");
        System.out.println("5 for Stack");
        System.out.println("6 for Queue");
        System.out.println("7 for BinaryTree");
        System.out.println("8 for Exit");
        input = sc.nextInt();
          switch(input){
                case 1:return "Singlelinkedlist";
                case 2:return "Circularlinkedlist";
                case 3:return "Doublylinkedlist";
                case 4:return "CircularDoublylinkedlist";
                case 5:return "Stack";
                case 6:return "Queue";
                case 7:return "BinaryTree";
                case 8:return "Exit";
                default:{
                    chooseOperation();
                    return "Exit";
                }
            }

    }
    private  void doOperation(String opp) {
        switch(opp)
        {
            case "Singlelinkedlist": SllOperation();  break;
            case "Circularlinkedlist":CllOperation(); break;
            case "Doublylinkedlist": DllOperation(); break;
            case "CircularDoublylinkedlist": CDllOperation(); break;
            case "Stack": StackOperation();  break;
            case "Queue":QueueOperation(); break;
            case "BinaryTree":BinaryTreeOperation(); break;
        }
        chooseOperation();
    }
    private void BinaryTreeOperation() {
    }
    private void QueueOperation() {
    }
    private void StackOperation() {
        System.out.println("1 for push");
        System.out.println("2 for pop");
        System.out.println("3 for peek");
        System.out.println("4 for reverse");
        System.out.println("5 for getSize");
        System.out.println("6 for isEmpty");
        System.out.println("7 for To Exit");
        input = sc.nextInt();
        switch(input){
            case 1:{
                    System.out.println("Enter the value to be inserted");
                    Integer val  = sc.nextInt();
                    stack.push(val);
                    StackOperation();
                    break;
            }
                case 2:{
                    try {
                        System.out.println(stack.pop());
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally{
                        StackOperation();
                    }
                    break;
                }

                case 3:{
                    try {
                        System.out.println(stack.peek());
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    finally{
                        StackOperation();
                    }
                    break;
                }
                 case 4:{
                    stack.reverse();
                    StackOperation();
                    break;
                    }
                case 5:{
                    System.out.println(stack.getSize());
                    StackOperation();
                    break;
                    }
                 case 6:{
                    System.out.println(stack.isEmpty());
                    StackOperation();
                    break;
                }
                case 7:break;
                default: System.out.println("Please select the correct opsition");
                StackOperation();
        }
    }
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
    private void DllOperation() {
    }
    private void CllOperation() {
    }
    private void SllOperation() {
        System.out.println("1 for InsertBegin");
        System.out.println("2 for InsertEnd");
        System.out.println("3 for InsertAtParticularPosition");
        System.out.println("4 for DeleteAtBegin");
        System.out.println("5 for DeleteAtEnd");
        System.out.println("6 for DeleteAtParticularPositon");
        System.out.println("7 for reverseTheList");
        System.out.println("8 for TraverseTheList");
        System.out.println("9 for isElementPresent");
        System.out.println("10 for FindthePositionofElement");
        System.out.println("11 for DeletetheElementUsingKeyValue");
        System.out.println("12 for movetheelement-fromonepostoanotherpos");
        System.out.println("13 for To Exit");
        input = sc.nextInt();
        switch(input){
            case 1:{
                    System.out.println("Enter the value to be inserted");
                    Integer val  = sc.nextInt();
                    list.InsertBegin(val);
                    SllOperation();
                    break;
            }
                case 2:{
                    System.out.println("Enter the value to be inserted");
                    Integer val  = sc.nextInt();
                    list.InsertEnd(val);
                    SllOperation();
                    break;
                }

                case 3:{
                    System.out.println("Enter the value to be inserted");
                    Integer val  = sc.nextInt();
                    System.out.println("Enter the position to be Inserted");
                    Integer pos = sc.nextInt();
                    try{
                        list.InsertAtPosition(pos, val);
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                        System.out.println("postion cannot exceed the list size and connot be negative value");
                    }finally{
                        SllOperation();
                    }
                    break;
                }
                 case 4:{
                    System.out.println(list.DeleteAtBegin());
                    SllOperation();
                    break;
                    }
                case 5:{
                    System.out.println(list.DeleteAtEnd());
                    SllOperation();
                    break;
                    }
                 case 6:{
                    System.out.println("Enter the position to be Deleted");
                    Integer pos = sc.nextInt();
                    try{
                        list.DeleteAtPosition(pos);
                    }catch(Exception e)
                    {
                         System.out.println("postion cannot exceed the list size and connot be negative value");
                        e.printStackTrace();
                    }finally{
                        SllOperation();
                    }
                    break;
                }
                case 7:{
                    list.reverse();
                    SllOperation();
                    break;
                    }
                case 8:
                    {
                        list.traverse();
                        SllOperation();
                        break;
                }
                case 9:
                {
                    System.out.println("Enter the Element");
                    Integer val = sc.nextInt();
                    System.out.println(list.isPresent(val));
                    SllOperation();
                    break;
                }
                case 10:
                {
                    System.out.println("Enter the Element");
                    Integer val = sc.nextInt();
                    if(list.isPresent(val))
                        System.out.println(list.findelement(val));
                    else 
                        System.out.println("Element not found");
                    SllOperation();
                    break;
                }
                case 11:
                {
                    System.out.println("Enter the Element");
                    Integer val = sc.nextInt();
                    if(list.isPresent(val))
                    {
                        Integer pos = list.findelement(val);
                        try {
                            list.DeleteAtPosition(pos);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else 
                    {
                        System.out.println("Element not found");
                    }
                    SllOperation();
                    break;
                }
                case 12:
                {
                    System.out.println("Enter the oldPosition");
                    Integer oldpos = sc.nextInt();
                    System.out.println("Enter the newPosition");
                    Integer newpos = sc.nextInt();
                    try {
                        list.movetheelement(oldpos, newpos);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally
                    {
                        SllOperation();
                    }
                    break;
                }
                case 13:break;
                default: System.out.println("Please select the correct opsition");
                SllOperation();
        }
         
    }
   
}
































































// // for queue
//         // QueueList que = new QueueList();
//         // que.addLast(1);
//         // que.addLast(2);
//         // que.addLast(3);
//         // que.traverse();
//         // que.removeFirst();
//         // que.traverse();
//         // que.reverse();
//         // que.traverse();
//         // que.addLast(6);
//         // que.traverse();



//         //for curcular linked list
//         // CircularLinkedList list = new CircularLinkedList();
//         // list.addFirst(1);
//         // list.addFirst(2);
//         // list.addLast(3);
//         // list.addLast(4);
//         // list.traverse();
//         // list.addAtPostion(2, 7);
//         // list.traverse();
//         // list.reverse();
//         // list.traverse();
//         // list.removeFirst();
//         // list.traverse();
//         // list.removeLast();
//         // list.traverse();


//         //for single linked list
//         // SingleLinkedList list = new SingleLinkedList();
//         // list.addFirst(1);
//         // list.addFirst(2);
//         // list.addLast(3);
//         // list.addLast(4);
//         // list.traverse();
//         // list.addAtPostion(2, 7);
//         // list.traverse();
//         // list.reverse();
//         // list.traverse();
//         // list.removeFirst();
//         // list.traverse();
//         // list.removeLast();
//         // list.traverse();




//         //For stack
//         Stack s = new Stack();
//         s.push(4);
//         s.push(6);
//         s.push(8);
//         s.push(1);
//         s.push(2);
//         s.push(3);
//         s.push(3);
//         s.push(6);
//         s.push(8);
//         System.out.println(s.peek());
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         System.out.println(s.pop());
//         System.out.println(s.pop());
        
//         System.out.println(s.peek());
//         System.out.println(s.getSize());
//         System.out.println(s.isEmpty());
//         s.reverse();
//         System.out.println(s.peek());
//         System.out.println(s.pop());
//         System.out.println(s.peek());