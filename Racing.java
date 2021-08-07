import java.io.*;
import java.util.*;

public class Racing{
    public static void main(String[] args){
        Kattio io = new Kattio();
        int M = io.nextInt();
        int T = io.nextInt();
        int U = io.nextInt();
        int F = io.nextInt();
        int D = io.nextInt();
        String[] path = new String[T];
        for(int i = 0; i < T; i++){
            path[i] = io.next();
        }
        int total = 0;
        for(int i = 0; i < T; i++){
            if(total>M){
                io.println(i);
                break;
            }
            if(path[i].equals("u") || path[i].equals("d")) total += (U+D);
            else total +=(2*F);
        }
        io.close();
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