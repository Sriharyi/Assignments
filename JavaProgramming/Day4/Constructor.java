public class Constructor {
    Integer n;
    Constructor(){
        System.out.println("This is from default constructor");
    }
    Constructor(Integer n){
        this();
        this.n = n;
        System.out.println("This is from the parameterized constructor");
    }
    Constructor(Constructor copy){
        this(copy.n);
        System.out.println("This is from the copy constructor");
    }
    public static void main(String[] args) {
        Constructor c1 = new Constructor(5);
        Constructor c2 = new Constructor(c1);
        System.out.println(c2.n+" "+c1.n);
    }
}