package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import java.awt.Color;


public class ParseImage {
	public static int[][] image_pict;
	public static int length;
	public static int width;
	public static char white;
	public static char black;
	public static BufferedImage image;
	public void draw_the_picture()
	{
		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j < width; j++)
			{
				if (Color.WHITE.getRGB() == image_pict[j][i])
					System.out.print(white);
				else
					System.out.print(black);

			}
			System.out.println();
		}
	}
	public ParseImage(BufferedImage image_in, char pre_white, char pre_black)
	{
		image = image_in;
		length = image.getHeight();
		width = image.getWidth();
		white = pre_white;
		black = pre_black;
		image_pict = new int[length][width];
		for (int i = 0; i < length; i++)
		{
			for (int j = 0; j < width; j++)
			{
				image_pict[j][i] = image.getRGB(j, i);
				// image.getRGB(i, j);
			}
		}
	}
}
