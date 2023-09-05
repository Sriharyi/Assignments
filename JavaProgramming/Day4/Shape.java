class Shape{
    private String name;
    Shape()
    {
        this("Unknown");
    }
    Shape(String name)
    {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public Float area(Float length,Float breadth)
    {
        return length * breadth;
    }
}