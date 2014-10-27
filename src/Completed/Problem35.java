package Completed;
import java.util.*;

public class Problem35
{
	ArrayList<Integer> primes = genPrimes(100);
	
	public Problem35()
	{
		int num = 0;
		for(int x = 0; x < primes.size(); x++)
		{
			if(isRotatePrime(primes.get(x)))
				num++;
		}
		System.out.println(num);
	}
	
	public boolean isRotatePrime(int a)
	{
		int temp = a, num = a;
		while(temp > 0)
		{
			if(!primes.contains(num))
				return false;
			temp /= 10;
			num = (int) (num / 10 + (num % 10) * Math.pow(10, String.valueOf(num).length() - 1));
		}
		return true;
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
		new Problem35();
	}
}
