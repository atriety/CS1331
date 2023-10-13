

public class FizzBuzz {
    public static void main (String[] args) {
        String myOutput = "";
        for(int i = 1;  i <= 20; i++) {        
            if (i % 3 == 0) {
                myOutput = "Fizz";
                    if (i % 5 == 0) {
                        myOutput = myOutput + "Buzz";
                    }
            } else if (i % 5 == 0) {
                myOutput = "Buzz";
            } else {
                myOutput = String.valueOf(i);
            }
            System.out.println(myOutput);
        }
    }
}