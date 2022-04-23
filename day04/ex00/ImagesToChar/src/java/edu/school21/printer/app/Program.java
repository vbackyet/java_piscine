package edu.school21.printer.app;

import edu.school21.printer.logic.ParseImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;


public class Program
{
	static char white;
	static char black;
	static String path;
	public static void pars_the_args(String[] args)
	{
		if (args.length != 3)
		{
			System.err.println("Что то не так с аргументами!");
			System.exit(-1);
		}
		else
		{
			try
			{
				white = args[0].toCharArray()[0];
				black = args[1].toCharArray()[0];
				path = args[2];
			}
			catch (Exception e)
			{
				System.err.println("Что то не так с аргументами!");
				System.exit(-1);
			}
		}
	}
	public static void main(String[] args) throws IOException
	{
		try{
			
		pars_the_args(args);
		File file = new File(path);
		BufferedImage image = ImageIO.read(file);
		ParseImage myImage = new ParseImage(image, white, black);
		myImage.draw_the_picture();
		}
		catch (IOException e)
		{
			System.err.println("Не удалось открыть файл!");
			System.exit(-1);	
		}
	}

}