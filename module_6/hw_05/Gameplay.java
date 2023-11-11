public class Gameplay {
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut susPerson = new RedAstronaut("Suspicious Person", 100, "expert");

        // //1
        liam.sabotage(bob);
        // System.out.println(bob.toString());

        // //2
        liam.freeze(susPerson);
        // System.out.println(susPerson.toString());


        // //3
        liam.freeze(albert);
        // System.out.println(liam.toString());
        // System.out.println(albert.toString());

        //4
        albert.emergencyMeeting();
        
        //5
        susPerson.emergencyMeeting();
        // System.out.println(bob.toString());
        // System.out.println(heath.toString());

        //6
        bob.emergencyMeeting();
        // System.out.println(susPerson.isFrozen());

        //7
        heath.completeTask();
        // System.out.println(heath.getNumTask());

        //8
        heath.completeTask();

        //9
        heath.completeTask();
        // System.out.println("Nothing happened");

        //10
        liam.freeze(angel);
        // System.out.println(liam.getSusLevel());
        // System.out.println(angel.isFrozen()+ " angel frozen status");

        //11
        liam.sabotage(bob);
        // System.out.println(bob.getSusLevel());
        liam.sabotage(bob);
        // System.out.println(bob.getSusLevel());

        //12
        liam.freeze(bob);
        // System.out.println("is bob frozen? " +bob.isFrozen());

        //13
        // System.out.println("is albert frozen? " + albert.isFrozen());
        // System.out.println("is susPerson frozen? " + susPerson.isFrozen());

        angel.emergencyMeeting();
        // System.out.println("is liam frozen? " + liam.isFrozen());
        //14
        // for (int i = 0; i < 5; i++) {
        //     liam.sabotage(heath);
        //     System.out.println(heath.getSusLevel());
        // }

        // //15
        // liam.freeze(heath);



        
    }
}
