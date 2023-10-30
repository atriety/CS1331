public class FlyClient {
    public static void main(String[] args) {
        Fly fly1 = new Fly();
        System.out.println(fly1.getMass());
        System.out.println(fly1.getSpeed());
        Fly fly2 = new Fly(0);
        System.out.println(fly2.getMass());
        System.out.println(fly2.toString());
        System.out.println(fly2.isDead());
        fly2.grow(22);
        System.out.println(fly2.getMass());
        System.out.println(fly2.getSpeed());

    }
}