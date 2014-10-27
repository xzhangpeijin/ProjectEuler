package Completed;
import java.util.HashSet;


public class Problem29 
{
	public Problem29()
	{
		HashSet<Double> result = new HashSet<Double>();
		for(int x = 2; x <= 100; x++)
			for(int y = 2; y <= 100; y++)
				result.add(Math.pow(x,y));
		System.out.println(result.size());

	}
	
	public static void main(String[] args) 
	{
		new Problem29();
	}
}
