public class Wolf extends Canine {
    //final key word does not allow method overriding useful for highly optimized or 
    // certain methods
    protected final int rank;

    public Wolf(double size, int rank) {
        super(size);
        this.rank = rank;
    }
    
    public int getRank() {
        return rank;
    }

    public void bark() {
        for (int i = 1; i <= 3; i++)
            super.bark();
    }

    public static void main(String[] args) {
        Wolf alpha = new Wolf(17.1, 1);
        alpha.bark();
    }
}