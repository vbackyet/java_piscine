
// Using these statements in Java, you need to determine if the input number is a prime.
// A prime is a number which has no dividers other than the number itself and 1.

// The program accepts the number entered from the keyboard as input and displays the result of checking whether that number is a prime. 
// In addition, the program shall output the number of steps (iterations) required to perform the check.
// In this task, an iteration is a single comparison operation.



import java.util.Scanner;

public class Program{
    static public int koren(int num)
    {
		long start = 1;
		long end = num;
		long ret = 0;
		long mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (mid * mid == num) {
				return ((int) mid);
			} else if (mid * mid < num) {
				start = mid + 1;
				ret = mid;
			} else {
				end = mid - 1;
			}
		}
		return (int) ret;
    }
    static public void is_prime(int num)
    {
        int iterations = 0;
        boolean answer = true;
        int i = 1;

        while(i++ < koren(num)+1)
        {
            iterations +=1;
            if (num%i == 0)
            {
                answer = false;
                break;
            }            
        }
        System.out.println(answer + " " + iterations);
    }
    static public void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        int code = 0;
        if (num < 2)
        {
            System.out.println("theIllegalArgument");
            code = -1;
        }
        else
        {
            is_prime(num);
        }
        in.close();
        System.exit(code);
    }
}