package main;
import preprocessor.*;
import render.*;
import printer.*;

   
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class Program {
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Printer printer = context.getBean("printerWithPrefix", Printer.class);
		printer.print("Hello!") ;
	}
}
