package chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF 
{
	private int[] a;
	private int num;
	
	public QuickFindUF(int N)
	{
		num = N;
		a = new int[N];
		for(int i = 0; i < N; i++)
		{
			a[i] = i;
		}
	}
	
	public int count()
	{
		return num;
	}
	
	public void union(int p, int q)
	{
		int valuep = a[p];
		int valueq = a[q];
		if(valuep != valueq)
		{
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] == valuep)
				{
					a[i] = valueq;
				}
				
			}
			num--;
		}
	}
	
	public int find(int p)
	{
		return a[p];
	}
	
	public boolean connected(int p, int q)
	{
		return a[p] == a[q];
	}
	
	 public static void main(String[] args) 
	 {
	        int n = StdIn.readInt();
	        QuickFindUF uf = new QuickFindUF(n);
	        while (!StdIn.isEmpty()) 
	        {
	            int p = StdIn.readInt();
	            int q = StdIn.readInt();
	            if (uf.connected(p, q)) continue;
	            uf.union(p, q);
	            StdOut.println(p + " " + q);
	        }
	        StdOut.println(uf.count() + " components");
	 }
	 
}
