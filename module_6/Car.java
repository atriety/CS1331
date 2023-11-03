public class Car implements Groomable {
    private String make;
    private String model;
    private int year;
    private int charge;
    private boolean powered;
    private int speed;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void start () {
        if (charge > 0) {
            powered = true;
            System.out.println("ding!");
        }
    }

    public void groom() {
        if(speed == 0) {
            System.out.println("Soap wax rinse and a little tree air freshener");
        }
    }
}
