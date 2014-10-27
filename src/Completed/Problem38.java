package Completed;
import java.util.ArrayList;


public class Problem38
{
	public Problem38()
	{
		for(int x = 9000; x < 10000; x++)
		{
			String a = String.valueOf(x) + String.valueOf(2 * x);
			if(isPandigital(Integer.valueOf(a)))
				System.out.println(a);
		}
	}
	
	public boolean isPandigital(int a)
	{
		ArrayList<Integer> digits = new ArrayList<Integer>();
		for(int x = 1; x < 10; x++)
			digits.add(x);
		while(a > 0)
		{
			digits.remove(new Integer(a % 10));
			a /= 10;
		}
		if(digits.size() > 0)
			return false;
		return true;
	}
	
	public static void main(String[] args)
	{
		new Problem38();
	}
}
