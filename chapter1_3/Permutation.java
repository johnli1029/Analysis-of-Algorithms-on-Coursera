package chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation 
{
	private int n;
	private int[] a;
	private int[] b;
	
	public Permutation(int length)
	{
		n = length;
		b = new int[length];
	}
	
	public void takein(int[] target)
	{
		a = target;
	}
	
	private void fillin(int lo, int hi)
	{
		for(int i = lo+1; i <= hi; ++i)
		{
			b[i]++;
			assert(b[i] != 0 && b[i] != 1);
		}
		
	}
	
	public boolean possible()
	{
		if(n != a.length)	return false;
		int probe = 1;
		int max = a[0];
		fillin(-1,max);
		b[max]--;
		while(probe < n)
		{
			int num = a[probe];
			b[num]--;
			if(num > a[probe-1])
			{
				if(num <= max)	
				{
					return false;
				}
				else 
				{
					fillin(max,num);
					max = num;
				}
			}
			else if(num < a[probe-1])
			{
				for(int i = num; i <= a[probe-1]; ++i)
				{
					if(b[i] != 0)					
					{
						return false;
					}
				}
			}
			else					
			{
				return false;
			}
			StdOut.println(num);
			probe++;
		}
		return true;
	}
	
	
	public static void main(String[] args)
	{
		StdOut.println("Input the length:");
		int length = StdIn.readInt();
		int[]target={2,5,6,7,4,8,9,3,1,0};
		Permutation per = new Permutation(length);
		per.takein(target);
		StdOut.print(per.possible());
	}
}
