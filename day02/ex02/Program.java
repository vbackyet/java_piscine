import java.util.Scanner;
import java.io.*;
import java.io.IOException;

public class Program {
	public static String CUUR_FOLDER = null;
	public static Integer bytes = 0;
	public static boolean flag = true;
	private static long getFolderSize(File folder)
    {
        long length = 0;
		if (folder.isFile() && flag) {
			
			return folder.length();
		}
		else
			flag = false;
        File[] files = folder.listFiles();
 
        int count = files.length;
        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            }
            else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }
	public static void ft_ls() 
	{
		File file = new File(CUUR_FOLDER);
		File[] fileList = file.listFiles();

		for(File str : fileList) {
		  flag = true;
		  bytes = 0;
		  System.out.print(str.getName().toString() + " ");
		  Integer final_bytes = (int) (getFolderSize(str)/ 1024);
		  String str_final = final_bytes.toString();
		  System.out.println(str_final + " KB");
		  }

	}

	public static void ft_cd(String cd_path) throws IOException
	{
        File file = new File(CUUR_FOLDER + "/" + cd_path);
        if (file.isDirectory()) {
			CUUR_FOLDER = file.getCanonicalPath();
        } else
		{
            System.out.println("Что то не так с папкой ");
		}
	}

	public static void ft_mv(String what, String where) throws IOException  
	{

        File what1 = new File(CUUR_FOLDER + "/" + what);
        File where1 = new File(CUUR_FOLDER + "/" + where);

		if (where1.isFile())
		{
			if (!(what1.renameTo(where1)))
				System.out.println("Не удалось поменять место файла:((");
		}
		else
		{
			if (!(what1.renameTo(new File(where1.getCanonicalPath() + "/" + what1.getName()))))
				System.out.println("Не удалось поменять место папки:((");
		}
	}
    public static void main(String[] args)
    {
        if((args.length != 1) || !(args[0].startsWith("--current-folder=")))
            {
                System.out.println("Not valid args");
                System.exit(-1);
            }
        Scanner terminal = new Scanner(System.in);

        CUUR_FOLDER = args[0].replace("--current-folder=", "");
		File file_check = new File(CUUR_FOLDER);
		if (!(file_check.isDirectory())) {
            System.err.println("Что то не так с папкой ");
			System.exit(-1);
		}
        while(true)
		{
		
				System.out.println("\n" + CUUR_FOLDER );
				String[] commands = terminal.nextLine().split("\\s+");
				if (commands.length == 0)
					continue;
				else if (commands[0].equals("ls") && (commands.length == 1))
					ft_ls();
				else if (commands[0].equals("mv") && (commands.length == 3))
				    
					try {
						ft_mv(commands[1], commands[2]);
					} catch (IOException e) {
						System.out.println("Не удалось поменять путь");
					}
				else if (commands[0].equals("cd") && (commands.length == 2))
				{					
					try {
						ft_cd(commands[1]);
					} catch (IOException e) {
						System.out.println("Нет такой папки");
					}
						
				}
				else if (commands[0].equals("exit"))
					break;
				else 
					System.err.println("Команда не найдена");
			
        }
		terminal.close();


    }
    
}

// --current-folder=/Users/vbackyet/Desktop/jv_pisc/day02/ex00
