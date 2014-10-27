package Completed;
import java.util.ArrayList;


public class Problem32
{
	public Problem32()
	{
		ArrayList<Integer> init = new ArrayList<Integer>();
		for(int x = 1; x < 10; x++)
			init.add(x);
		ArrayList<Integer> perms = allPerms(init, 0);
		int sum = 0;
		for(int x = 0; x < perms.size(); x++)
		{
			int temp = perms.get(x);
			if(panProduct(temp))
			{
				sum += temp;
			}
		}
		System.out.println(sum);
	}
	
	public boolean panProduct(int a)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int temp = a;
		while(a > 0)
		{
			nums.add(a % 10);
			a /= 10;
		}
		ArrayList<Integer> remain = new ArrayList<Integer>();
		for(int x = 1; x < 10; x++)
			if(!nums.contains(x))
				remain.add(x);
		
		
		ArrayList<Integer> nextperms = allPerms(remain, 1);
		
		for(int x = 0; x < nextperms.size(); x++)
			if(allProd(nextperms.get(x)).contains(temp))
				return true;
		return false;
	}
	
	public ArrayList<Integer> allProd(int temp)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int x = 1; x < 5; x++)
		{
			int a = (int) (temp / Math.pow(10, x));
			int b = (int) (temp % Math.pow(10, x));
			result.add(a * b);
		}
		return result;
	}
	
	public ArrayList<Integer> allPerms(ArrayList<Integer> temp, int x)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int a = 0; a < temp.size(); a++)
		{	
			for(int b = 0; b < temp.size(); b++)
			{	
				if(a != b)
				{	
					for(int c = 0; c < temp.size(); c++)
					{	
						if(a != c && b != c)
						{	
							for(int d = 0; d < temp.size(); d++)
							{
								if(a != d && b != d && c != d)
								{
									if(x == 0)
										result.add(1000 * temp.get(a) + 100 * temp.get(b) + 10 * temp.get(c) + temp.get(d));
									else if(x == 1)
									{
										for(int e = 0; e < temp.size(); e++)
											if(a != e && b != e && c != e && d != e)
												result.add(10000 * temp.get(a) + 1000 * temp.get(b) + 100 * temp.get(c) + 10 * temp.get(d) + temp.get(e));
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	
	
	public static void main(String[] args)
	{
		new Problem32();
	}
}
