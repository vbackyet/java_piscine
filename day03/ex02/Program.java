import java.util.ArrayList;
import java.util.Arrays;


class SpecialThread extends Thread {
	public int totalSum = 0;

	public int getSum() {
		return totalSum;
    }

    SpecialThread (int[] my_array,int interval, int start, int thread_num) {
		for (int i = 0; i < interval; i++)
		{
			totalSum += my_array[i];

		}
		System.out.println("Thread " + thread_num
				+ ": from " + (start)
				+ " to " + (start + interval - 1)
				+ " sum is " + totalSum);
		}
	}



public class Program

{
	public static int start = 0;


    public static int get_counter(String[] args, int prov)
    {
        if (args.length == 2)
        {
            if (args[1].startsWith("--threadsCount="))
            {
                int counter = Integer.parseInt(args[1].replace("--threadsCount=", ""));
				if (counter <= prov)
                	return counter;
            }
        }
        System.err.println("Неправильный аргумент!");
        System.exit(-1);
        return 0;
    }

	public static int get_counter_array_size(String[] args)
    {
        if (args.length == 2)
        {
            if (args[0].startsWith("--arraySize="))
            {
                int counter = Integer.parseInt(args[0].replace("--arraySize=", ""));
				if (counter <= 2000000)
                	return counter;
            }
        }
        System.err.println("Неправильный аргумент!");
        System.exit(-1);
        return 0;
    }
	public static int[] creat_masive(int size)
    {
		int[] my_array = new int[size];
	
		for (int i = 0; i < size; i++) {
			// ((int)(Math.random() * 1000);
            my_array[i] = 1;
        }
		
		return my_array;
	}	

	public static int[] cut_my_array(int[] old_array,int start,int interval)
    {

		int[] my_array = new int[interval];
	
		for (int i = 0; i < interval; i++) {

            my_array[i] = old_array[i+start];
			
        }		
		return my_array;
	}

	public static int makeThreads(int interval, int[] my_array, int size, int thread_size)
	{
		
		int sum = 0;
		ArrayList<SpecialThread> myThreads = new ArrayList<>();
		int thread_counter = 0;

        while (thread_counter < thread_size - 1) {

			int end = (start + interval);
            SpecialThread thread = new SpecialThread(cut_my_array(my_array, start, interval), interval, start, thread_counter );
			start += interval;
            myThreads.add(thread);
			thread_counter++;
        }
        SpecialThread thread = new SpecialThread(cut_my_array(my_array, start, size - start), (size - start), start, thread_counter);
        myThreads.add(thread);
        for (SpecialThread th : myThreads)
            th.start();

        for (SpecialThread th : myThreads) {
            try { th.join(); } catch (InterruptedException e) {}}

		for (SpecialThread th : myThreads) {
			 sum += th.getSum();  }
        // }
		return sum;
	}


	 public static void main(String[] args) 
    {
		int counter_array_size = get_counter_array_size(args);
		int counter_threads = get_counter(args, counter_array_size);
		int[] my_array = creat_masive(counter_array_size);
		int interval = counter_array_size / counter_threads;
		
		int sum = makeThreads(interval, my_array, counter_array_size, counter_threads);
		System.out.println("Sum : " +sum);
    }
}