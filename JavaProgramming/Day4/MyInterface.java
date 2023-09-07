interface InterfaceA{
    void methodinA();
    interface InterfaceB{
        void methodinB();
    }
}

class MyInterface implements InterfaceA.InterfaceB{
  
     public void methodinB()
    {
        System.out.println("helloB");
    }
    public static void main(String... args)
    {
        InterfaceA.InterfaceB b = new MyInterface();
        b.methodinB();
    }
}