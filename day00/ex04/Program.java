import java.util.Scanner;



public class Program{
	static public void print_several_times(int minim)
	{
		// String total_equals = " ";
		for (int i = 0; i < minim; i++)
		{
			System.out.print(" ");
			// total_equals+= "=";
		}
		// return (total_equals);
	}
	public static char[] insert_the_char(char[] myTen, int index_of_new, int to_insert)
	{
		char[] newTen= new char[10];
		for(int i = 0; i < 10; i++)
		{
			newTen[i] = myTen[i];
		}
		int j = index_of_new;
		newTen[j] = (char )to_insert;
		for(int i = j + 1; i < 10; i++)
		{
			// System.out.println("my i: " + i);
			newTen[i] = myTen[i - 1];
		}
		return newTen;
	}
	public static int ft_count_the_sq(int num)
	{
		int i = 0;
		while (num > 0)
		{
			i++;
			num /= 10;
		}
		return i;
	}
	public static int[] getCountOfLine(String myText)
	{
		int[] counts = new int[65535];
		char[] Text = myText.toCharArray();
		int i = 0;
		while (i < myText.length())
		{
			// System.out.println(i + " " + Text[i] + " " + ((int)Text[i]) + "!!!");
			counts[Text[i]]++;
			i++;
		}
		return counts;
	}
	public static char[] getTopTen(int[] counts)
	{
		char[] myTen = new char[10];
		int i = 0;
	
		while (i < 65535)
		{
			if (counts[i] > 0)
			{
				for (int j = 0; j < 10; j++)
				{
					if (counts[i] > counts[myTen[j]]) 
					{
						myTen = insert_the_char(myTen, j, i);
						// printTheHist(myTen, counts);
						break;
					}
				}
			}
			i++;

		}
		return myTen;
	}
	public static void printTheHist(char[] myTen, int[] count)
	{
		double one_lattice = (double) count[myTen[0]] / 10;
		int[] lattice_hist = new int[10];
		// System.out.println(one_lattice + "   " + (int) (count[myTen[0]] / one_lattice));
		for (int i = 0; i < 10 ; i++)
		{
			lattice_hist[i] = (int) (count[myTen[i]] / one_lattice);
		}
				for (int i = 0; i < 10 ; i++)
		{
			System.out.print(myTen[i] + ":" + count[myTen[i]] + " : " + lattice_hist[i]+ "    ");
		}
		System.out.println();
		int count_the_sq = ft_count_the_sq(count[myTen[0]]) + 1;
		for (int i = 10; i >= -1 ; i--)
		{
			for (int j = 0; j < 10 ; j++)
			{
				if (lattice_hist[j] >= (i))
				{
					if (lattice_hist[j] == (i))
					{
						System.out.print(count[myTen[j]]);
						print_several_times(count_the_sq - ft_count_the_sq(count[myTen[j]]));
					}
					else if (i == -1)
					{
						System.out.print(myTen[j]);
						print_several_times(count_the_sq - 1);
					}
					else
					{
						System.out.print("#");
						print_several_times(count_the_sq - 1);
					}
				}
			}
			System.out.println();
		}


	}
	
	public static void main(String[] args)
	{

		Scanner inner = new Scanner(System.in);
		String myText = inner.nextLine();
		
		
		int[] counts = getCountOfLine(myText);		
		char[] myTen = getTopTen(counts);
		inner.close();
		printTheHist(myTen, counts);



	}
}


// вопрос - почему ++ 