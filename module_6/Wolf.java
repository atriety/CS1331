import java.util.Arrays;

public class Wolf extends Canine implements Groomable, Comparable {
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

    public void groom() {
        System.out.println("lick");
    }

    public int compareTo(Object anotherWolf) {
        return -(rank - ((Wolf)anotherWolf).rank);
    }

    public String toString() {
        return("Rank:" + rank + " Size:" + size);
    }

    public static void main(String[] args) {
        Wolf alpha = new Wolf(17.1, 1);
        Wolf puppy = new Wolf(9.0, 10);
        System.out.println(alpha.compareTo(puppy));
        alpha.bark();
        Wolf[] pack = {
            new Wolf(12.1, 3),
            new Wolf(12.1, 2),
            new Wolf(19.1, 1),
            new Wolf(13.1, 10),
            new Wolf(14.1, 7),
            new Wolf(17.1, 19),
            new Wolf(8.1, 4)
        };
        System.out.println("Unsorted Pack " + Arrays.toString(pack));
        Arrays.sort(pack);
        System.out.println("Sorted Pack" + Arrays.toString(pack));

    }
}

