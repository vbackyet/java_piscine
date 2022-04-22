




public class Program

{

    public static int get_counter(String[] args)
    {
        if (args.length == 1)
        {
            if (args[0].startsWith("--count="))
            {
                int counter = Integer. parseInt(args[0].replace("--count=", ""));
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

        Runnable egg = () -> {for (int i = 0 ; i < counter; i++){ System.out.println("EGG!");}};
        Runnable hen = () -> {for (int i = 0 ; i < counter; i++){ System.out.println("HEN!");}};

        Thread egg_thread = new Thread(egg);
        Thread hen_thread = new Thread(hen);

        egg_thread.start();
        hen_thread.start();

        egg_thread.join();
		hen_thread.join();


        for (int i = 0 ; i < counter; i++){
            System.out.println("Human!");
        }
        
    }
}