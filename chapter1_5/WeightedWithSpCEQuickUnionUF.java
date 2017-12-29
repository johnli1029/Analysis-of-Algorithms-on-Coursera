package chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class WeightedWithSpCEQuickUnionUF
{
	private int[] a;
	private int num;
	private int[] size;
	private int[] biggest;
	
	public WeightedWithSpCEQuickUnionUF(int N)
	{
		num = N;
		a = new int[N];
		size = new int[N];
		biggest = new int[N];
		for(int i = 0; i < N; i++)
		{
			a[i] = i;
			size[i] = 1;
			biggest[i] = i;
		}
	}
	
	public int count()
	{
		return num;
	}
	
    private void validate(int p) 
    {
        int n = a.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));  
        }
    }
	public void union(int p, int q)
	{
		int rootp = find(p);
		int rootq = find(q);
		if(rootp == rootq)	return;
		if(rootp != rootq)
		{
			if(size[rootp] > size[rootq])
			{
				a[rootq] = a[rootp];
				size[rootp] += size[rootq];
			}
			else
			{
				a[rootp] = a[rootq];
				size[rootq] += size[rootp];
			}
			int biggestp = findb(rootp);
			int biggestq = findb(rootq);
			biggest[biggestp]=biggest[biggestq]=Math.max(biggest[biggestp], biggest[biggestq]);
		}
		num--;
	}
	
	public int find(int p)
	{
		validate(p);
		while(p != a[p])
		{
			p = a[p];
		}
		return p;
	}
	
	public int findb(int p)
	{
		validate(p);
		while(p != biggest[p])
		{
			p = biggest[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q)
	{
		return find(p) == find(q);
	}
	
	 public static void main(String[] args) 
	 {
	        int n = StdIn.readInt();
	        WeightedWithSpCEQuickUnionUF uf = new WeightedWithSpCEQuickUnionUF(n);
	        Stopwatch timer = new Stopwatch();
	        while (!StdIn.isEmpty()) 
	        {
	            int p = StdIn.readInt();
	            int q = StdIn.readInt();
	            if (uf.connected(p, q)) 
	            {	
	            	continue;
	            }
	            uf.union(p, q);
	            StdOut.println(p + " " + q);
	        }
	        StdOut.println("Processing time = " + timer.elapsedTime() + " s");
	        StdOut.println("The Canonic Element in the subset containing 1 is " + uf.findb(3) + " .");
	        StdOut.println(uf.count() + " components");
	 }
	 
	 
}
