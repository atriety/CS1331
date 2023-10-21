public class Insect {
    //instance variables
    private double weight;
    private int x;
    private int y;
    

    //static constants/variables
    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    public static final double DIST_WEIGHT_LOSS_FACTOR = .0001;
    private static int population = 0;
    private static final String[] FACTS = {
        "The two main groups of insects are winged and wingless",
        "There are more than q million insect species",
        "Insects are cold-blooded",
        "Spiders are not considered insects"
    };
    

    //constructor 
    //overloading construction changing the paramenters required to instatiate an object
    public Insect(double initWeight) {
            this(initWeight, DEFAULT_X, DEFAULT_Y);    
        // when chaining don't need anymore because the more specific class handles that
        // weight = initWeight;
        //     x = DEFAULT_X;
        //     y = DEFAULT_Y;
        //     population++;
    }


    public Insect(double initWeight, int initX, int initY) {
            weight = initWeight;
            x = initX;
            y = initY;
            population++;
    }

    //methods
    public double getWeight() {
        return weight;
    }
    //must be used with an instance of the class if there is not a static 
    public int getX() {
        return x;
    }

    public void setX(int newX) {
        if (isLegalX(newX)) {
            x = newX;
        }
    }

    public int getY() {
        return y;
    }
    //setter methods by default have a void return type because they are used to modify a variable 
    /// not to return a variable
    // input is the value to assign to the variable, variable type must be the same as the variable being changed
    
    public void setY(int newY) {
        if (isLegalY(newY)) {
            y = newY;
        }
    }

    public static boolean isLegalX(int newX){
        return (newX >= 0 ? true:false);
    }

    public static boolean isLegalY(int newY){
        return (newY >= 0 ? true:false);
    }
    //if there's not static this method does not need a instance to be ran
    public static int getPopulation() {
        return population;
    }

    public void eat(double amount) {
        System.out.println("Nibble Nibble");
        weight = weight + amount;
    } 

    public void move(int newX, int newY) {
        double distance = calculateDistance(x, y, newX, newY);
        if (distance > 0) {
            x = newX;
            y = newY;
            weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
            System.out.printf("Moved %.2f units\n", distance);
        }
        else {
            System.out.println("Staying put");
        }
    }
    private static double calculateDistance(double x1, double y1,
                                            double x2, double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1)*(x2 - x1)); 
    }

    public static String produceRandomFact() {
        int index = (int)(Math.random() * ((FACTS.length - 1) + 1));
        return FACTS[index];
    }

    public String toString() {
        return "weight: " + weight + "x:" + x + "y:" + y;
    }

    public static void main(String[] args) {
        System.out.println("Insect Population: " + population);
        Insect bug1 = new Insect(10, 100, 90);
        System.out.println("Insect Population: " + population);
        Insect bug2 = new Insect(9.5, -300,400);
        System.out.println("Insect Population: " + population);

        bug1.move(1,10);
        bug2.move(-300,400);

        System.out.println(produceRandomFact());

    }
}