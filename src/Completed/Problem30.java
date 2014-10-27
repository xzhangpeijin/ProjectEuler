package Completed;
import java.util.HashSet;


public class Problem30 
{
	public Problem30()
	{
		int total = 0;
		for(int x = 1000; x < 300000; x++)
		{
			int sum = 0;
			int temp = x;
			while(temp > 0)
			{
				sum += Math.pow(temp % 10, 5);
				temp /= 10;
			}
			if(sum == x)
				total += x;
		}
		System.out.println(total);

	}
	
	public static void main(String[] args) 
	{
		new Problem30();
	}
}
