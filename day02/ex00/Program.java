package day02.ex00;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;





public class Program {

	public static void main(String[] args) throws IOException {
		// читаем сигнатуры
		FileReader prochital = new FileReader(System.getProperty("user.dir") + "/day02/ex00/signatures.txt");
		
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/day02/ex00/signatures.txt");
		int i;
		// читаем из консоли
		Scanner inner = new Scanner(System.in);
		String address = inner.nextLine();
		//  проверка 
		inner.close();

		// парсим 


		// сохраняем


		while((i=fileInputStream.read())!= -1){
			System.out.print((char)i);
		}
		fileInputStream.close();
	}
 }