import java.util.Scanner;



public class Program{
	public static int[] getCountOfLine(String myText)
	{
		int[] counts = new int[65535];
		char[] Text = myText.toCharArray();
		int i = 0;
		while (i++ < myText.length())
		{
			counts[Text[i]]++;
		}
		return counts;
	}
	public static char[] getTopTen(int[] counts)
	{
		char[] myTen = new char[10];
		int i = 0;
	
		int max = 0;
		while (i++ < 65535)
		{
			for (int j = 0; j < 65535; j++)
			{
				
			}

		}
		return myTen;
	}
	public static void printTheHist(char[] myTen)
	{

	}
	
	public static void main(String[] args)
	{

		Scanner inner = new Scanner(System.in);
		String myText = inner.nextLine();
		
		
		int[] counts = getCountOfLine(myText);		
		char[] myTen = getTopTen(counts);

		printTheHist(myTen);



	}
}