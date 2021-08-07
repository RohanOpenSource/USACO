import java.io.*;
import java.util.*;

public class MilkTemp{
    private static int[] temp;
    private static int N, X, Y, Z;
    public static void main(String[] args){
        Kattio io = new Kattio();
        N = io.nextInt();
        X = io.nextInt();
        Y = io.nextInt();
        Z = io.nextInt();
        temp = new int[N];
        for(int i = 0; i < N; i+=2){
            int a = io.nexInt();
            int b = io.nextInt();
            temp[i] = a;
            temp[i+1] = b;
        }
    }
}
class Pair implements Comparable<Pair> {
    int start, end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Pair p) {
        if (p.end == end)
            return 0;
        return p.end < end ? 1 : -1;
    }
}
class Kattio extends PrintWriter {
	private BufferedReader r;
	private StringTokenizer st;

	// standard input
	public Kattio() { this(System.in, System.out); }
	public Kattio(InputStream i, OutputStream o) {
		super(o);
		r = new BufferedReader(new InputStreamReader(i));
	}
	// USACO-style file input
	public Kattio(String problemname) throws IOException {
		super(new FileWriter(problemname + ".out"));
		r = new BufferedReader(new FileReader(problemname + ".in"));
	}

	// returns null if no more input
	public String next() {
		try {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return st.nextToken();
		} catch (Exception e) { }
		return null;
	}

	public int nextInt() { return Integer.parseInt(next()); }
	public double nextDouble() { return Double.parseDouble(next()); }
	public long nextLong() { return Long.parseLong(next()); }
}