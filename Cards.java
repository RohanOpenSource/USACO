import java.io.*;
import java.util.*;

public class Cards{
    private static int[] e;
    private static int[] b;
    private static int N;
    private static int ans;
    public static void main(String[] args){
        Kattio io = new Kattio();
        N = io.nextInt();
        e = new int[N];
        b = new int[N];
        boolean[] visited = new boolean[2 * N];
        for (int i = 0; i < N; i++) {
            e[i] = io.nextInt();
            visited[e[i] - 1] = true;
        }
        int j = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (!visited[i]) {
                b[j] = i + 1;
                j++;
            }
        }
        Arrays.sort(e);
        Arrays.sort(b);
        int bi = 0;
        int ei = 0;
        while(bi<N && ei<N){
            if(b[bi] > e[ei]){
                ei++;
                bi++;
                ans++;
            }
            else{
                bi++;
            }
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