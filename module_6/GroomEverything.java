
public class GroomEverything {
    public static void main(String[] args) {
        Groomable[] groomer = {
            new Wolf(17.01, 3),
            new Poodle("richie", 9, "Lux brand", "Rich brand"),
            new Wolf(16,5),
            new Car("Yuhina", "Spark", 2037)
        };

        for (Groomable g : groomer) {
            g.groom();
        }
    }
}
