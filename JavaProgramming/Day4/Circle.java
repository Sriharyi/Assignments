class Circle extends Shape{
    private Float radius;
    private final Float PI = 3.14f;
    Circle(){
        super("Circle");
    }
    Circle(Float radius)
    {
        super("Circle");
        this.radius = radius;
    }
    public void setRadius(Float radius)
    {
        this.radius = radius;
    }
    public void areaofCircle()
    {
      System.out.println("area of circle"+PI * area(this.radius,this.radius));
    }
    public void areaofCircle(Float radius)
    {
        System.out.println("area of circle"+PI * area(radius,radius));
    }


}