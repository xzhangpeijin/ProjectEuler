package Completed;

public class Problem25 
{
	public Problem25()
	{
		System.out.println(genFib(new FibNumber(10000, 1), new FibNumber(10000, 1)));
	}
	
	private int genFib(FibNumber a, FibNumber b)
	{
		int first5, digits;
		digits = b.digits;
		if(a.digits != b.digits)
		{
			first5 = a.first5 / 10 + b.first5;
		}
		else
			first5 = a.first5 + b.first5;
		if(first5 > 99999)
		{
			first5 /= 10;
			digits++;
		}
		if(digits == 1000)
			return 3;
		else
			return genFib(b, new FibNumber(first5, digits)) + 1;
	}
	
	public class FibNumber
	{
		public int first5;
		public int digits;
		
		public FibNumber(int a, int b)
		{
			first5 = a;
			digits = b;
		}
	}
}
