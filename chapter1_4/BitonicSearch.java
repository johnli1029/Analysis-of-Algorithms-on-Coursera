package chapter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class BitonicSearch 
{
	public static boolean BinarySearchplus(int[] a, int lo, int hi, int target)
	{
		while(lo <= hi)
		{
			int mid = lo + (hi-lo)/2;
			if(a[mid] < target)		lo = mid+1;
			else if(a[mid] > target)	hi = mid-1;
			else	return true;
		}
		return false;
	}
	
	public static boolean antiBinarySearchplus(int[] a, int lo, int hi, int target)
	{
		while(lo <= hi)
		{
			int mid = lo + (hi-lo)/2;
			if(a[mid] > target)		lo = mid+1;
			else if(a[mid] < target)	hi = mid-1;
			else	return true;
		}
		return false;
	}
	
	public static void main(String args[])
	{
		double last = 0;
		for(int time = 2; time < 9; time++)
		{
			int N = (int) Math.pow(10, time);
			int[] a = BitonicMax.bitonic(N);
			int max = BitonicMax.max(a, 0, a.length-1);
			int target = StdRandom.uniform(a[max]);
			Stopwatch timer = new Stopwatch();
			for(int n=0; n < 50000000; n++)
			{
				BinarySearchplus(a,0,max,target);
				antiBinarySearchplus(a,max+1,a.length-1,target);
			}
			double thistime = timer.elapsedTime();
			StdOut.println("Processing time = " + thistime + " s" + "\t" + (thistime-last));
			last = thistime;
		}
	}
}
