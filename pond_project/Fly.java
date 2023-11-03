public class Fly {
    
    private double mass;
    private double speed;
    
    public static final double DEFAULT_MASS = 5;
    public static final double DEFAULT_SPEED = 10;

    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    public Fly(double initMass) {
        this(initMass, DEFAULT_SPEED);
    }
    
    public Fly(double initMass , double initSpeed) {
        mass = initMass;
        speed = initSpeed;

    }

    //methods
    public double getMass() {
        return mass; 
    }

    public double getSpeed() {
        return speed; 
    }

    public void setMass(double newMass) {
        mass = newMass;
    }

    public void setSpeed(double newSpeed) {
        speed = newSpeed;
    }

    public String toString() {
        if (mass == 0) {
            return "I\'m dead but I used to be a fly with a speed of " + speed + ".";
        } else {
            return "I\'m a speedy fly with " + speed + " speed and " + mass + " mass.";
        }
    }

    public boolean isDead() {
        if (mass == 0) {
            return true;
        } else return false;
    }

    public void grow(int growMass) {
        mass = mass + growMass;
        if (mass < 20) {
            speed = speed + growMass;
        }  else {
            speed = speed - ((mass - 20)  * 0.5);
        }
    }

}
