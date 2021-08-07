import java.io.*;
import java.util.*;

public class Mount{
    private static int N;
    private static int[] arr;
    private static int ans = 0;
    public static void main(String[] args){
        Kattio io = new Kattio();
        N = io.nextInt();
        arr = new int[N];
        int[] l = new int[N];
        int [] r = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = io.nextInt();
        }
        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1]) {
                l[i] = l[i - 1] + 1;
            }
        }
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                r[i] = r[i + 1] + 1;
            }
        }
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, 1 + l[i] + r[i]);
        }
        io.println(ans);
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