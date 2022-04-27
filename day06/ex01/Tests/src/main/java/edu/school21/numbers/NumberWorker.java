package edu.school21.numbers;

public class NumberWorker {
	public int koren(int num)
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
	public boolean isPrime(int number)
	{
		if (number < 2){
			throw new IllegalNumberException();}
		if (number == 2)
			return true;
        boolean answer = true;
        int i = 1;

        while(i++ < koren(number)+1)
        {
            if (number%i == 0)
            {
                answer = false;
                break;
            }            
        }
		return answer;
	}
	public int digitsSum(int number)
	{
		int sum = 0;
        while (number > 0) {
            int tmp = number % 10;
            sum += tmp;
            number /= 10;
        }
        return sum;
	}
}

class IllegalNumberException extends RuntimeException{
	
}
