package chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF 
{
	private int[] a;
	private int num;
	
	public QuickUnionUF(int N)
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
		int rootp = find(p);
		int rootq = find(q);
		if(rootp != rootq)	
		{
			a[rootp] = rootq;
			num--;
		}
	}
	
	public int find(int p)
	{
		while(p != a[p])
		{
			p = a[p];
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
		QuickUnionUF uf = new QuickUnionUF(n);
		while (!StdIn.isEmpty()) 
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q))
				continue;	
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + " components");
	}
}
