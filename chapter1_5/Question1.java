package chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Question1 
{
	public static void main(String[] args) 
	 {
			int n = Integer.parseInt(args[0]);
	        WeightedQuickUnionPathCompressionUF uf = new WeightedQuickUnionPathCompressionUF(n);
	        while (uf.count() > 1) 
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
	 }
}
