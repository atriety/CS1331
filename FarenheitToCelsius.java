

public class FarenheitToCelsius {
    public static void main (String[] args) {
        int saturdayFarenheit;
        int sundayFarenheit;
        saturdayFarenheit = 78;
        sundayFarenheit = 81;
        double sundayCelsius = (sundayFarenheit - 32) * (5.0/9);
        double saturdayCelsius = (saturdayFarenheit - 32) * (5.0/9);
        System.out.println("Test" + saturdayCelsius);
        System.out.println("Test" + sundayCelsius);
    }
}