package Completed;
import java.util.ArrayList;


public class Problem24 
{
	public Problem24()
	{
		ArrayList<String> numbers = new ArrayList<String>();
		for(int a = 0; a < 10; a++)
		{
			for(int b = 0; b < 10; b++)
			{
				if(b != a)
				{
					for(int c = 0; c < 10; c++)
					{
						if(c != a && c != b)
						{
							for(int d = 0; d < 10; d++)
							{
								if(d != a && d != b && d != c)
								{
									for(int e = 0; e < 10; e++)
									{
										if(e != a && e != b && e!= c && e != d)
										{
											for(int f = 0; f < 10; f++)
											{
												if(f != a && f != b && f != c && f != d && f != e)
												{
													for(int g = 0; g < 10; g++)
													{
														if(g != a && g != b && g != c && g != d && g != e && g != f)
														{
															for(int h = 0; h < 10; h++)
															{
																if(h != a && h != b && h != c && h != d && h != e && h != f && h != g)
																{
																	for(int i = 0; i < 10; i++)
																	{
																		if(i != a && i != b && i != c && i != d && i != e && i != f && i != g && i != h)
																		{
																			for(int j = 0; j < 10; j++)
																			{
																				if(j != a && j != b && j != c && j != d && j != e && j != f && j != g && j != h && j != i)
																				{
																					numbers.add(String.valueOf(a) + String.valueOf(b) + String.valueOf(c) + String.valueOf(d) + String.valueOf(e) + String.valueOf(f) + String.valueOf(g) + String.valueOf(h) + String.valueOf(i) + String.valueOf(j));
																					if(numbers.size() > 1000000)
																					{
																						a = 10; 
																						b = 10;
																						c = 10;
																						d = 10;
																						e = 10;
																						f = 10;
																						g = 10;
																						h = 10;
																						i = 10; 
																						j = 10;
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(numbers.get(999999));
	}
}
