public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species;
    
    private static final String DEFAULT_SPECIES = "Rare Pepe"; 
    public static final int DEFAULT_AGE = 5;
    public static final double DEFAULT_TOUNGUESPEED = 5.0;

    public Frog(String name){
        this.name = name;
        age = DEFAULT_AGE;
        tongueSpeed = DEFAULT_TOUNGUESPEED;
        species = DEFAULT_SPECIES;
        if (age > 1 && age < 7){
            isFroglet = true;
        } else {
            isFroglet = false;
        }
    }

    public Frog(String name, double initTongueSpeed) {
        this(name);
        this.tongueSpeed = initTongueSpeed;
    }

    public Frog(String name, double initToungeSpeed, double ageInYears){
        this(name, initToungeSpeed);
        this.age = (int)ageInYears * 12;
    }
    
    public Frog(String name, double initToungeSpeed, int initAge){
        this(name, initToungeSpeed);
        this.age = initAge;

    }

    public void eat(Fly fly) {
        if(fly.isDead()) {
        //do nothing
        } else {
            if (tongueSpeed > fly.getSpeed()) {
                if(fly.getMass()*0.5 >= age) {
                    grow(1);
                }
                fly.setMass(0);
            } else {
                //need to use fly object to differentiate from Frog class method
                fly.grow(1);
            }
        }
    }

    public void grow(int growMonths) {
        double tongueSpeedAmt = 0;
        int oldAge = age;
        age = age + growMonths;

        if (age <= 12) {
            tongueSpeedAmt =  growMonths; 
        } else if (age > 12 && oldAge < 12) {
            tongueSpeedAmt = 12 - oldAge;
        } else if (age >= 30) {
            tongueSpeedAmt = 30 - age;
        }

        tongueSpeed = tongueSpeedAmt + tongueSpeed;
        if (tongueSpeed < 5) {
            tongueSpeed = 5;
        }
        if (age > 1 && age < 7){
            isFroglet = true;
        } else {
            isFroglet = false;
        }

    }

    public void grow() {
        grow(1);
    }

    public String toString() {
        if (isFroglet == true) {
            return "My name is " + name +  " and I\'m a rare froglet! I\'m " + age + " months old and my tongue has a speed of " + tongueSpeed + ".";
        } else {
            return "My name is " + name +  " and I\'m a rare frog. I\'m " + age + " months old and my tongue has a speed of " + tongueSpeed + ".";

        }
    }

    public static void setSpecies(String newSpecies) {
        Frog.species = newSpecies;
    }
}