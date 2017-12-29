package chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac Sattolo.java
 *  Execution:    java Sattolo < list.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/11model/cards.txt
 *  
 *  Reads in a list of strings and prints a uniformly random cycle
 *  using Sattolo's algorithm under the assumption that Math.random()
 *  generates independent and uniformly distributed numbers between
 *  0 and 1.
 *
 *  %  echo 0 1 2 3 4 | java Sattolo
 *  1
 *  2
 *  4
 *  0
 *  3
 *
 ******************************************************************************/

/**
 *  The {@code Sattolo} class provides a client for reading a sequence 
 *  of <em>n</em> strings and computing a <em>unifomly random cycle</em>
 *  of length <em>n</em> using Sattolo's algorithm.
 *  This algorithm guarantees to produce a unifomly random cycle under
 *  the assumption that {@code Math.random()} generates independent and
 *  uniformly distributed numbers between 0 and 1.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/11model">Section 1.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Shuffle 
{ 
	public static class Sattolo 
	{

    // this class should not be instantiated
		private Sattolo() { }

    /**
     * Rearranges an array of objects to be a uniformly random cycle
     * (under the assumption that {@code Math.random()} generates independent
     * and uniformly distributed numbers between 0 and 1).
     * @param a the array to be rearranged
     * @see StdRandom
     */
		public static void cycle(Object[] a) {
			int n = a.length;
			for (int i = n; i > 1; i--) {
				// choose index uniformly in [0, i-1)
				int r = (int) (Math.random() * (i-1));
				Object swap = a[r];
				a[r] = a[i-1];
				a[i-1] = swap;
			}
		}
	    public static void main(String[] args) 
	    {

	    	// read in the data
	    	String[] b = StdIn.readAllStrings();
	    	FY.cycle(b);
	    	for (int i = 0; i < b.length; i++)
	    		StdOut.print(b[i]+'\t');
	    	
	    	StdOut.println();
	    	
	    	String[] a = {"0","1","2","3","4","5","6","7","8","9"};
	    	Sattolo.cycle(a);
	    	for (int i = 0; i < a.length; i++)
	    		StdOut.print(a[i]+'\t');

	    }
	}
		
	public static class FY
	{
		public static void cycle(Object[] a)
		{
			int n=a.length;
			for (int i = n; i > 1; i--)
			{
				int r = (int) (Math.random()*i);
				// choose index uniformly in [0, i)
				Object swap=a[r];
				a[r] = a[i-1];
				a[i-1] = swap;
			}
		}
	}

		/**
		 * Reads in a sequence of strings from standard input, shuffles
		 * them, and prints out the results.
		 *
		 * @param args the command-line arguments
		 */

}