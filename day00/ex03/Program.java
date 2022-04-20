import java.util.Scanner;



public class Program{
	static public void print_several_times(int minim)
	{
		// String total_equals = " ";
		System.out.print(" ");
		for (int i = 0; i < minim; i++)
		{
			System.out.print("=");
			// total_equals+= "=";
		}
		// return (total_equals);
	}
	static public long power(int curr_week, long tens)
	{
		if (curr_week == 0)
			tens = 1;
		while (curr_week-- > 1)
		{
			tens *= 10;
		}
		return tens;
	}
	static public void show_the_marks(int curr_week, long all_marks)
	{
		int i = 1;
		int minim;
		long powered;
		while (1 < curr_week--)
		{
			powered = power(curr_week - 1, 10);
			// System.out.println("powered :   "+ powered + " curr week " + curr_week);
			minim = (int) (all_marks / powered);
			// System.out.println(minim + "my minim " + powered + "  " + all_marks);
			System.out.print("Week " + i );
			print_several_times(minim);
			System.out.println(">");
			all_marks = all_marks % powered;
			i++;
			
		}
	}
	static public long put_the_marks(long all_marks, int curr_min)
	{
		all_marks = all_marks * 10 + curr_min;
		return (all_marks);
	}
	static public int find_the_min(Scanner inner)
	{
		int the_min_dig = inner.nextInt();
		int i = 0;
		int min = the_min_dig;
		while ( i++ < 4)
		{
			if (min > the_min_dig){
				min = the_min_dig;
			}
			the_min_dig = inner.nextInt();		
		}
		if (min > the_min_dig){
			min = the_min_dig;
		}
		return (min);
	}
	public static void main(String[] args)
	{
		int curr_week = 1;
		long all_marks = 0;
		int curr_min;
		Scanner inner = new Scanner(System.in);
		String week = inner.nextLine();
		while((curr_week <= 18) & !(week.equals("42")))
		{
			if (week.equals("Week " + curr_week))
				{	
					curr_min = find_the_min(inner);
					all_marks = put_the_marks(all_marks, curr_min);
					curr_week++;
				}
			else
			{
				System.out.println("IllegalArgument");
				System.exit(-1);
			}
			inner.nextLine();
			week = inner.nextLine();
		}
		show_the_marks(curr_week, all_marks);

		
		
	}
}