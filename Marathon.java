import java.io.*;
import java.util.*;

public class Marathon{
    public static void main(String[] args){
        Kattio io = new Kattio();
        int N = io.nextInt();
        Pair[] checkpoints = new Pair[N];
        for(int i = 0; i < N; i++){
            int x = io.nextInt();
            int y = io.nextInt();
            checkpoints[i] = new Pair(x, y);
        }
        int total = 0;
        for(int i = 0; i < N-1; i++){
            total+=dist(checkpoints[i], checkpoints[i+1]);
        }
        int max = 0;
        for(int i = 1; i < N-1; i++) {
            int ns = dist(checkpoints[i], checkpoints[i+1]) + dist(checkpoints[i], checkpoints[i-1]);
            int s = dist(checkpoints[i-1], checkpoints[i+1]);
            max = Math.max(max, ns - s);
        }
        io.println(total - max);
        io.close();
    }
    private static int dist(Pair a, Pair b){
        return (Math.abs(a.x-b.x)+Math.abs(a.y-b.y));
    }
}
class Pair{
    int x, y;

    public Pair(int start, int end) {
        this.x = start;
        this.y = end;
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