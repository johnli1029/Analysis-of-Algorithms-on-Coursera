package chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickUnionPathCompressionUF 
{
	private int[] a;
	private int num;
	
	public QuickUnionPathCompressionUF(int N)
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
		if(p != a[p])
		{
			a[p] = find(a[p]);
		}
		return a[p];
	}
	
	
	 	/*public int find(int p) 
	 	{
        	int root = p;
        	while (root != a[root])
        		root = a[root];
        	while (p != root) {
        		int newp = a[p];
        		a[p] = root;
        		p = newp;
        	}
        	return root;
    	}
    	*/

	 
	
	public boolean connected(int p, int q)
	{
		return find(p) == find(q);
	}
	
	 public static void main(String[] args) 
	 {
	        int n = StdIn.readInt();
	        QuickUnionPathCompressionUF uf = new QuickUnionPathCompressionUF(n);
	        Stopwatch timer = new Stopwatch();
	        while (!StdIn.isEmpty()) 
	        {
	            int p = StdIn.readInt();
	            int q = StdIn.readInt();
	            if (uf.connected(p, q)) continue;
	            uf.union(p, q);
	            StdOut.println(p + " " + q);
	        }
	        StdOut.println("Processing time = " + timer.elapsedTime() + " s");
	        StdOut.println(uf.count() + " components");
	 }
}
