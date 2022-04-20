// package ex00;

import java.io.FileInputStream;
// import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class FileReader {

    public Map<String, String> TheMap = new HashMap<>();
    public void FillTheMap(String my_line)
    {
        String[] str = new String(my_line).split(", ");
        TheMap.put(str[0], str[1]);
    }

    public FileReader(String my_path) throws FileNotFoundException
    {
        Scanner input = new Scanner(System.in);
        File file = new File(my_path);
        input = new Scanner(file);


        while (input.hasNextLine()) 
        {
            String line = input.nextLine();
            FillTheMap(line);
            System.out.println(line);
        }

        input.close();

    // } catch (Exception ex) {
    //     ex.printStackTrace();
    }
    public Map<String, String> getTheMap()
    {
        return TheMap;
    }
    public static void main(String[] args) throws IOException {
		// читаем сигнатуры
		FileReader prochital = new FileReader(System.getProperty("user.dir") + "/signatures.txt");
        Map<String, String> MyMap = prochital.getTheMap();

    }
    
}


