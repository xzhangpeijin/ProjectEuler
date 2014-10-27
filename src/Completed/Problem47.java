package Completed;

import java.util.ArrayList;


public class Problem47 
{
	public ArrayList<Integer> primes = genPrimes(200000);
	
	public Problem47()
	{
		int consec = 0;
		for(int x = 1; x < 1000000; x++)
		{
			if(!primes.contains(x))
			{
				if(numFact(x) == 4)
					consec++;
				else
					consec = 0;
				System.out.println(x);
				if(consec == 4)
				{
					System.out.println(x - 3);
					break;
				}
			}
			else if (consec > 0)
				consec = 0;
		}
	}
	
	public int numFact(int a)
	{
		int index = 0;
		int numprimes = 0;
		while(primes.get(index) <= a / 3)
		{
			if(a % primes.get(index) == 0)
				numprimes++;
			index++;
		}
		return numprimes;
	}
	
	public ArrayList<Integer> genPrimes(int a)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] num = new int[a];
		for(int x = 0; x < a; x++)
			num[x] = x + 1;
		for(int x = 0; x < a; x++)
		{
			if(num[x] != 1)
			{
				result.add(num[x]);
				int sum = num[x];
				while(sum <= a)
				{
					num[sum - 1] = 1;
					sum += result.get(result.size() - 1);
				}
			}
		}	
		return result;
	}
	
	public static void main(String[] args)
	{
		new Problem47();
	}
}
