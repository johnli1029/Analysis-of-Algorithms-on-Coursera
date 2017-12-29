package chapter1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Josephus 
{
	private int[] a;
	private int n;
	private int m;
	private int probe;
	
	public Josephus(int M, int N)
	{
		n = N;
		m = M-1;
		a = new int[n];
		for(int i = 0; i < n; ++i)
		{
			a[i] = i;
		}
	}
	
	public int pop(int index)
	{
		int temp = a[index];
		for(int i = index; i < n-1; ++i)
		{
			a[i]=a[i+1];
		}
		a[n-1] = -1;
		n--;
		return temp;
	}
	
	public int eliminate()
	{
		int temp;
		int accum;
		probe = 0;
		while(n > 1)
		{
			accum = m % n;
			probe = (probe+accum) % n;
			temp = a[probe];
			for(int i = probe; i < n-1; ++i)
			{
				a[i]=a[i+1];
			}
			a[n-1] = -1;
			n--;
			StdOut.print(temp+" ");
		}
		return a[0];
	}
	
	public static void main(String[] args)
	{
		int m = StdIn.readInt();
		int n = StdIn.readInt();
		Josephus jose = new Josephus(m,n);
		StdOut.print(jose.eliminate());
		StdOut.println();
		
		Queue<Integer> queue = new Queue<Integer>();
		for(int i = 0; i < n; ++i)
		{
			queue.enqueue(i);
		}
		while(!queue.isEmpty())
		{
			for(int i = 0; i < m-1; ++i)
			{
				queue.enqueue(queue.dequeue());
			}
			StdOut.print(queue.dequeue()+" ");
		}
	}

}
