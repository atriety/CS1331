public class InsectClient {
    public static void main(String[] args) {
        System.out.println(Insect.produceRandomFact());
        Insect bug1 = new Insect(13, 31, 0);
        System.out.println(bug1.getX());
        System.out.println(bug1.getY());
        System.out.println(bug1.getWeight());
        Insect bug2 = new Insect(31);
        System.out.println(bug2.getX());
        System.out.println(bug2.getY());
        System.out.println(bug2.getWeight());
        System.out.println(bug1);
    }
}
