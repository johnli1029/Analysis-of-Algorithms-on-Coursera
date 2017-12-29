package chapter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class FindDuplicate 
{
	public static void main(String[] args)
	{
		for(int j = 2; j <= 8; j++)
		{
			final int N = (int) Math.pow(10, j);
			// creating
			Stopwatch timer = new Stopwatch();
			int[] a = new int[N+2];
			int ans = StdRandom.uniform(N+1);
			for(int i = 0; i <= N+1; i++)
			{
				if(i <= ans)	a[i] = i;
				else	a[i] = i-1;
			}
			
			timer.reset();
			for(int n=0; n < 100000000; n++)
			{
				// processing
				int lo = 0;
				int hi = N-1;
				int mid = 0;
				while(lo <= hi)
				{
					mid = lo +(hi-lo)/2;
					if(a[mid] == mid)	lo = mid+1;
					else if(a[mid] == mid-1)	hi = mid-1;
					else	throw new RuntimeException("There must be something wrong.");
				}
			}
			StdOut.println("Processing time: "+ timer.elapsedTime() + " s");
		}
	}
}
