package usaco_problems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MilkPails {
	public static void main(String[] args) throws IOException {
		Kattio reader = new Kattio("pails");
		int x = reader.nextInt();
		int y = reader.nextInt();
		int m = reader.nextInt();
		int maxX = m/x;
		int maxY = m/y;
		int max = 0;
		
		for(int a = 0; a <= maxX; a++) {
			for(int b = 0; b <= maxY; b++) {
				int total = x*a+y*b;
				if(total > max && total <= m) max = total;
			}
		}
		
		reader.println(max);
		reader.close();
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
	public Kattio(String problemName) throws IOException {
		super(new FileWriter(problemName + ".out"));
		r = new BufferedReader(new FileReader(problemName + ".in"));
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
