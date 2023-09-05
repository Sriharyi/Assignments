class Rectangle extends Shape{
    Float length;
    Float breadth;
    Rectangle(){
        super("Rectangle");
    }
    Rectangle(Float length,Float breadth){
        super("Rectangle");
        this.length = length;
        this.breadth =breadth;
    }
    public void areaofRectangle()
    {
        System.out.println("area of Rectangle"+area(this.length,this.breadth));
    }
    public void areaofRectangle(Float length,Float breadth)
    {
        System.out.println("area of Rectangle"+area(length,breadth));
    }
}