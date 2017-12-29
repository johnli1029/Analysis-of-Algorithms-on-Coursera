package chapter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class LocalMinMatrix 
{	
	public static void main(String[] args)
	{
		final int N = 30000;
		double[][] a = new double[N][N];
		Stopwatch timer = new Stopwatch();
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				a[i][j] = StdRandom.uniform(-100.0, 100.0);
			}
		}
		StdOut.println("Generating time: "+ timer.elapsedTime() + " s");
		/*for(int i=0;i<N;i++)
		{				
			StdOut.print(i+": ");
			for(int j=0;j<N;j++)
			{
				StdOut.print(a[i][j]+"\t");
			}
			StdOut.println();
		}
		*/
		
		Stopwatch timerr = new Stopwatch();
		int xlo = 0;	//纵向上限
		int ylo = 0;	//横向左限
		int xhi = N-1;	//纵向下限
		int yhi = N-1;	//横向右限
		int count = 0;
		
		while (xhi-xlo > 1 && yhi-ylo > 1)
		{
			int xmid = xlo + (-xlo + xhi)/2;	//	
			int ymid = ylo + (-ylo + yhi)/2;	//
			int j1 = 0;
			int j2 = 0;
			double xmin = a[xmid][xlo];
			double ymin = a[ymid][ylo];
			
			for(int i = ylo; i <= yhi; i++)
			{
				if(a[xmid][i] < xmin) 
				{
					xmin=a[xmid][i];
					j1=i;
				}
			}
			if(xmin < a[xmid-1][j1] && xmin < a[xmid+1][j1])	count = count+1;
			if(a[xmid-1][j1] < a[xmid+1][j1] )	xhi = xmid;
			else xlo = xmid;
			
			
			for(int i = xlo; i <= xhi; i++)
			{
				if(a[i][ymid] < ymin) 
				{
					ymin=a[i][ymid];
					j2=i;
				}
			}
			if(ymin < a[j2][ymid-1] && ymin < a[j2][ymid+1])	count = count+1;
			if(a[j2][ymid-1] < a[j2][ymid+1] )	yhi = ymid;
			else ylo = ymid;
		}
		
		StdOut.println("Processing time: "+ timerr.elapsedTime() + " s");
		StdOut.println("Count: "+count);
	}
}
