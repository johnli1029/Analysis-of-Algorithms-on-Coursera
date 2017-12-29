package chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings implements Iterable<String>
{
	private String[] a;
	private int n;
	private int first;
	private int last;
	
	public ResizingArrayQueueOfStrings()
	{
		a=new String[2];
		n=0;
		first=last=0;
	}
	
	public boolean isEmpty()
	{
		return n==0;
	}
	
	public int size()
	{
		return n;
	}
	
	private void resize(int capacity)
	{
		assert capacity >= n;
		
		String[] temp = new String[capacity];
		for(int i = 0; i < n; ++i)
		{
			temp[i]=a[(first+i)%a.length];
		}
		a=temp;
		first=0;
		last=n;
	}
	
	public void enqueue(String str)
	{
		if(n==a.length)	resize(2*a.length);
		a[last++]=str;
		if(last==a.length)	last=0;
		n++;
	}
	
	public String dequeue()
	{
		if (isEmpty())	throw new NoSuchElementException("Queue underflow");
		
		String out=a[first];
		a[first++]=null;
		if(first==a.length)	first=0;
		n--;
		if(n > 0 && n/4 <= a.length/4)	resize(a.length/2);
		return out;
	}
	
	public String peek()
	{
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return a[first];
	}
	
    public Iterator<String> iterator() 
    {
        return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<String>
    {
    	private int i=0;
    	
    	public boolean hasNext()
    	{
    		return i<n;
    	}
    	
    	public void remove()     
    	{ 
    		throw new UnsupportedOperationException();  
    	}
    	
    	public String next()
    	{
    		if(!hasNext()) throw new NoSuchElementException();
    		String str=a[(first+i)%a.length];
    		return str;
    	}
    }
    
    public static void main(String[] args) {
    	ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (!str.equals("-")) queue.enqueue(str);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
    
}
