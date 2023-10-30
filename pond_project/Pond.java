public class Pond {
    public static void main(String[] args) {
        //CreateFrogs
        Frog frogPeepo = new Frog("Peepo");
        Frog frogPepe = new Frog("Pepe", 15, 10);
        Frog frogPeepaw = new Frog("Peepaw", 5, 4.6);
        Frog frogMuto = new Frog("Muto");

        // Create Flys
        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly(5,100);

        Frog.setSpecies("1331 Frogs");

        System.out.println(frogPeepo.toString());

        frogPeepo.eat(fly2);
        System.out.println(fly2.toString());
        frogPeepo.grow(8);
        frogPeepo.eat(fly2);
        System.out.println(fly2.toString());
        System.out.println(frogPeepo.toString());
        System.out.println(frogMuto.toString());

        frogPeepaw.grow(4);
        System.out.println(frogPeepaw.toString());
        System.out.println(frogPepe.toString());


    }
}