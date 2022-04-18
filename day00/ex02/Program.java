
//It is clear that the sequence of search queries is infinite. It is impossible to store these queries and count them later.

// But there is a solution—process the flow of queries. 
//Why should we waste our resources for all queries if we are only interested in a specific feature of this query sequence? 
//Let's assume that each query is any natural number other than 0 and 1.
// A query is related to coffee preparation only if the sum of digits of the number (query) is a prime number.

// So, we need to implement a program that will count the number of elements for a specified set of numbers whose sum of digits is a prime number. 
//To keep it simple, let's assume that this potentially infinite sequence of queries is still limited, and the last sequence element is number 42.

// This task guarantees that input data is absolutely correct.


import java.util.Scanner;

public class Program {
    public static int my_sum(int num)
    {
        int sum = 0;

        while (num > 0)
            {
            sum += num % 10;
            num /= 10;
            }
        return (sum);
    }
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
    static public boolean is_prime(int num)
    {

        boolean answer = true;
        int i = 1;

        while(i++ < koren(num)+1)
        {

            if (num%i == 0)
            {
                answer = false;
                break;
            }            
        }
        return (answer);
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int steps = 0;
        System.out.print("------>: ");
        int num = in.nextInt();
        while (num != 42)
        {
            if (is_prime(my_sum(num)))
                steps += 1;
            System.out.print("------>: ");
            num = in.nextInt();
        }
        in.close();
        System.out.println("Count of coffee-request – " + steps);

    }
    
}


// вопрос - почему у меня в ону линию тоже считывается??