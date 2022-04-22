//package day03.ex01;
// class 	PrintTheWord_{
// 	public synchronized void SayEgg(String word)
// 	{
// 		try
// 		{
// 		notify();
// 		System.out.println(word);
// 		wait();
// 		}
// 		            catch (InterruptedException e) {

// 			}
// 	}
// }

class PrintTheWord_ {
    public boolean flag = false;
    public synchronized void sayHen() {
        while (!flag) {
            try { 
				wait(); 
			}
            catch (InterruptedException e) {

			}
        }
        flag = false;
        System.out.println("Hen");
        notify();
    }
    public synchronized void sayEgg() {
        while (flag) {
            try { 
				wait();
			 }
            catch (InterruptedException e) {

			}
        }
        flag = true;
        System.out.println("Egg");
        notify();
    }
}



public class Program

{

    public static int get_counter(String[] args)
    {
        if (args.length == 1)
        {
            if (args[0].startsWith("--count="))
            {
                int counter = Integer.parseInt(args[0].replace("--count=", ""));
                return counter;
            }
        }
        System.err.println("Неправильный аргумент!");
        System.exit(-1);
        return 0;
    }

    public static void main(String[] args) throws InterruptedException
    {
		int counter = get_counter(args);
		PrintTheWord_ printer1 = new PrintTheWord_();
		// printer1.SayEgg("Egg");
		
        Thread egg_thread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				for (int i = 0; i < counter; i++)
					printer1.SayEgg("Egg");
			}
		});


		Thread hen_thread = new Thread(new Runnable() 
		{
			@Override
			public void run()
			{
				
				for (int i = 0; i < counter; i++)
						printer1.SayEgg("GHG");
				
			}
		});

        egg_thread.start();
        hen_thread.start();

        egg_thread.join();
		hen_thread.join();
        
    }
}