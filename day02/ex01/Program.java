// package day02.ex01;

import java.io.FileInputStream;
// import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.stream.Collectors;

import javax.lang.model.util.ElementScanner6;


import java.io.*;
import java.util.*;// java Program inputA.txt inputB.txt


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Program {
    public static Integer count_the_words(String the_string, List <String> line)
    {
        int i = 0;
        int freq = 0;
        while(i < line.size())
        {
            if (the_string.equals(line.get(i)))
                freq++;
            i++;
        }
        // return 1;
        return freq;
    }

    public static void countSim(String file0, String file1)
    {
        List <String> list1 = null;
        List <String> list2 = null;
        for (int i = 0; i< 2 ; i++)
        {
            String filename = ((i==0) ? file0 : file1);
            try (BufferedReader reader = new BufferedReader(new FileReader(filename), 10000000)) {
                String line;
                line = reader.readLine();
                if (i == 0)
                    list1 = Arrays.asList(line.split("\\s+"));
                else
                    list2 = Arrays.asList(line.split("\\s+"));
            }
                    catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        List<String> common_list = new ArrayList<String>();
        common_list.addAll(list1);
        common_list.addAll(list2);
        // System.out.println("*********************");
        // for(String model : common_list) {
        //     System.out.println(model);
        // }
        Set<String> targetSet = new HashSet<>(common_list);
        Vector<Integer> vector1= new Vector<Integer>(targetSet.size(), 0);
        Vector<Integer> vector2= new Vector<Integer>(targetSet.size(), 0);



        for (int i = 0; i < targetSet.size() ; i++)
        {
            // System.out.println("begin" + targetSet.size());
            String the_word = targetSet.toArray(new String[targetSet.size()])[i];
            System.out.println(the_word);
            
            vector1.addElement(count_the_words(the_word, list1));
            vector2.addElement(count_the_words(the_word, list2));
        }
        double simularity;
        int numerator;
        double denominator;
        double denominator1 = 0;
        double denominator2 = 0;

        numerator = 0;
        for (int i=0; i< targetSet.size();i++){
            numerator += (int) vector1.get(i) * (int) vector2.get(i);
        }

        for (int i=0; i< targetSet.size();i++){
            denominator1 += (int)vector1.get(i) * (int) vector1.get(i);
        }
        for (int i=0; i< targetSet.size();i++){
            denominator2 += (int)vector2.get(i) * (int) vector2.get(i);
        }
        denominator = Math.sqrt(denominator1) * Math.sqrt(denominator2);

        simularity = numerator / denominator;


        System.out.println(simularity);


    }
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Не достаточно аргументов!");
            return;
        }
        // FileInputStream file0 = new FileInputStream(args[0]);
        // FileInputStream file1 = new FileInputStream(args[1]);
        countSim(args[0], args[1]);
 

    }
}
