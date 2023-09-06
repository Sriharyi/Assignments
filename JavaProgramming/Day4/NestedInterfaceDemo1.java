interface InterfaceA{
    void displayInA();
    class MyClass{
        void displayInMyclass()
        {
            System.out.println("Display in classA");
        }
    }
}
public class NestedInterfaceDemo1 {
    public void displayInA()
    {
        System.out.println("hello in A");
    }
    public static void main(String... args)
    {
        InterfaceA.MyClass a = new InterfaceA.MyClass();
        a.displayInMyclass();
        System.out.println("hello");
    }
}
// it is working
// public class NestedInterfaceDemo1 implements InterfaceA {
//     public void displayInA()
//     {
//         System.out.println("hello in A");
//     }
//     public static void main(String... args)
//     {
//         InterfaceA.MyClass a = new InterfaceA.MyClass();
//         a.displayInMyclass();
//         System.out.println("hello");
//     }
// }



// it is working too
// public class NestedInterfaceDemo1 implements InterfaceA{
//     public void displayInA()
//     {
//         System.out.println("hello in A");
//     }
//     public static void main(String... args)
//     {
//         InterfaceA a = new NestedInterfaceDemo1();
//         a.displayInA();
//         System.out.println("hello");
//     }
// }