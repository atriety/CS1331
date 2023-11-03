public class Dog extends Canine {
    protected String name;

    public Dog(String name, double size) {
        //inherits from Canine class
        super(size);
        this.name = name;
    }

    public void fetch() {
        System.out.println("Run");
        System.out.println("Clinch");
        System.out.println("Return");
    }

    public static void main(String[] args) {
        Dog spot = new Dog("Spot", 9.6);
        // spot.bark();
    }
    //have to have abstract methods, allows generic methods
    public void groom() {}
}
