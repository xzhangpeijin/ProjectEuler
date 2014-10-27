package Completed;

public class Problem34
{
	public Problem34()
	{
		int total = 0;
		for(int x = 10; x < 1000000; x++)
		{
			int temp = x;
			int sum = 0;
			while(temp > 0)
			{
				sum += factorial(temp % 10);
				temp /= 10;
			}
			if(sum == x)
				total += x;
		}
		System.out.println(total);
	}
	
	public int factorial(int a)
	{
		if(a == 0 || a == 1)
			return 1;
		else
			return a * factorial(a - 1);
	}
	
	public static void main(String[] args)
	{
		new Problem34();
	}
}
