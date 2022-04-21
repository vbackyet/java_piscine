// package ex00;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
// import java.lang.parseInt;

public class MyFileReader {

    public Map<String, String> TheMap = new HashMap<>();

	public static void toFile(String theType) {
        String path = System.getenv("PWD") + "/result.txt";
        try (FileOutputStream fileOutputStream = new FileOutputStream(path, true)) {
            fileOutputStream.write(theType.getBytes());
        } catch (IOException e) {
            System.out.println("Puk puk");
        }
    }
	public String String_to_ten(String my_str)
	{
		String new_string = "";
		String[] signatures = my_str.split(" ");
		for (int i = 0 ; i < signatures.length ; i++)
		{
			new_string += Integer.parseInt(signatures[i], 16);
			new_string += " ";
		}
		return new_string;
	}
    public void FillTheMap(String my_line)
    {
        String[] str = new String(my_line).split(", ");
		String ten = String_to_ten(str[1]);
        TheMap.put(str[0], ten);
    }

    public MyFileReader(String my_path) throws FileNotFoundException
    {
        // Scanner input = new Scanner(System.in);
        File file = new File(my_path);
        Scanner input = new Scanner(file);


        while (input.hasNextLine()) 
        {
            String line = input.nextLine();
            FillTheMap(line);
        }

        input.close();

    // } catch (Exception ex) {
    //     ex.printStackTrace();
    }
    public Map<String, String> getTheMap()
    {
        return TheMap;
    }
	public static String readLine(FileInputStream path) throws IOException 
	{
		String first_line = "";
		int counter = 0;
		Integer i;
		while ((i = path.read()) != -1) {
			first_line += i.toString();
			first_line += " ";
			counter++;
			if (counter > 20)
				return first_line;
		}
		return "OUT";
	}
	
	public static boolean FoundFile(String path, Map<String, String> MyMap)
	{
		String file_string;
		try{
		FileInputStream file = new FileInputStream(System.getenv("PWD") + "/" + path);
		if ((file_string = readLine(file)) != "OUT") {
			System.out.println(file_string);
			for (Map.Entry<String, String> pair : MyMap.entrySet()){
				if (file_string.startsWith(pair.getValue()))
				{
					toFile(pair.getKey() + "\n");
					return true;
				}
			}
			
		}
		}
		catch (Exception e) {

			System.out.println("Что то не так с файлом(");
			return false;
		}

		return false;


	}
    public static void main(String[] args) throws IOException 
	{

		MyFileReader prochital = new MyFileReader(System.getenv("PWD") + "/signatures.txt");
        Map<String, String> MyMap = prochital.getTheMap();
		Scanner terminal = new Scanner(System.in);
        String path;
        boolean answer;
        while (terminal.hasNextLine()) {
            path = terminal.nextLine();
            if (path.equals("42"))
                break;
			answer = FoundFile(path, MyMap);
			if (answer)
				System.out.println("PROCESSED");
			else
				System.out.println("UNDEFINED");
        }
		terminal.close();


    
	}
}


