class MyClass{
   interface InterfaceA
   {
    void displayInA();
   } 
}
public class NestedIntefaceDemo implements MyClass.InterfaceA{
    public void displayInA()
    {
        System.out.println("hello in A");
    }
    public static void main(String... args)
    {
        // MyClass.InterfaceA a = new MyClass(); it is not working
        MyClass.InterfaceA a = new NestedIntefaceDemo();
        a.displayInA();
        System.out.println("hello");
    }
}

// it is also working
// public class NestedIntefaceDemo extends MyClass{
//     public static void main(String... args)
//     {
//         System.out.println("hello");
//     }
// }