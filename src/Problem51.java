import java.util.ArrayList;


public class Problem51 
{
	public ArrayList<Integer> primes = genPrimes(1000000);
	
	public Problem51()
	{
		for(int x = 0; x < primes.size(); x++)
		{
			if(primes.get(x) > 50000)
			{
				System.out.println(primes.get(x));
			}
		}
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
		new Problem51();
	}
	
}
