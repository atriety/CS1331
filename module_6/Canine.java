public abstract class Canine {
    protected double size;

    public Canine(double size) {
        this.size = size;
    }

    public void bark() {
        System.out.println("Woof Woof");
    }
    //any subclass must override leaves the subclass to define
    //compiler will force the programmer to override the abstract method in any subclasses
    public abstract void groom();
}
