package Completed;
import java.math.BigInteger;


public class Problem48
{
	public Problem48()
	{
		BigInteger sum = new BigInteger("0");
		BigInteger mod = new BigInteger("10000000000");
		for(int x = 1; x <= 1000; x++)
		{
			BigInteger temp = new BigInteger(String.valueOf(x));
			BigInteger value = new BigInteger("1");
			for(int y = 0; y < x; y++)
			{
				value = value.multiply(temp);
				value = value.mod(mod);
			}
			sum = sum.add(value);
			sum = sum.mod(mod);
		}
		System.out.println(sum.toString());
	}
	

	public static void main(String[] args)
	{
		new Problem48();
	}
}
