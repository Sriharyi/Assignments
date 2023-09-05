class Inheritance
{
    public static void main(String... args)
    {
        Rectangle r1 = new Rectangle(4f,5f);
        Circle c1 = new Circle(5f);
        r1.areaofRectangle();
        c1.areaofCircle();
       System.out.println(r1.getName());
       System.out.println(c1.getName());
    }
}