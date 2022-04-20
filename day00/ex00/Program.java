// package ex00;
// Work with integer type.

// Calculate the sum of digits of a six-digit int number 
// (the number value is set directly in the code by explicitly initializating the number variable).

// Example of the program operation for number 479598:




public class Program{
    static public void main(String[] args)
    {
        int six_digit = 123456;
        int sum = 0;

        sum += six_digit % 10;
        six_digit /= 10;

        sum += six_digit % 10;
        six_digit /= 10;

        sum += six_digit % 10;
        six_digit /= 10;

        sum += six_digit % 10;
        six_digit /= 10;

        sum += six_digit % 10;
        six_digit /= 10;

        sum += six_digit % 10;

        System.out.println(sum);
    }
}