package chapter1_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac VisualAccumulator.java
 *  Execution:  none
 *  Dependencies: StdDraw.java
 *
 *  Visual accumulator mutable data type.
 *
 ******************************************************************************/


public class VisualAccumulator {
    private double total;
    private int n;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    public void addDataValue(double value) {
        n++;
        total += value;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, value);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(n, mean());
    }

    public double mean() {
        return total / n;
    }

    public String toString() {
        return "Mean (" + n + " values): " + String.format("%8.5f", mean());
    }
    
    public static void main(String[] args)
    {
        VisualAccumulator stats = new VisualAccumulator(5,20);
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            stats.addDataValue(x);
        }

        StdOut.printf(stats.toString());
    }
}
