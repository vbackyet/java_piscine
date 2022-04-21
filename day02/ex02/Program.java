import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

// java Program --current-folder=C:/MAIN

public class Program {
    public static void main(String[] args)
    {
        if((args.length != 1) || !(args[0].startsWith("--current-folder=")))
            {
                System.out.println("Not valid args");
                System.exit(-1);
            }
        Scanner terminal = new Scanner(System.in);

        final String CUUR_FOLDER = args[0].replace("--current-folder=", "");
        while(1)
        {
            String[] commands = terminal.nextLine().split("\\s+");
            if (command.length == 0)
                continue;
            else if (commands[0].equals("ls") && (commands.length == 1))
                ft_equals();
            else if (commands[0].equals("mv") && (commands.length == 3))
                ft_mv();
            else if (commands[0].equals("cd") && (commands.length == 2))
                ft_cd();
            else if (commands[0].equals("exit"))
                break;
            else 
                System.err.prinln("КОманда не найдена");
        }


    }
    
}
