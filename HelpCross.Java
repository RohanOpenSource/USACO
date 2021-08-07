import java.io.*;
import java.util.*;

public class HelpCross{
    private static Pair[] cows;
    private static int[] chickens;
    private static boolean[] paired;
    private static int C;
    private static int N;
    private static int ans;
    public static void main(String[] args){
        Kattio io = new Kattio();
        C = io.nextInt();
        N = io.nextInt();
        chickens = new int[C];
        cows = new Pair[N];
        paired = new boolean[N];
        for(int i = 0; i < C; i++){
            chickens[i] = io.nextInt();
        }
        for(int i = 0; i < N; i++){
            int a = io.nextInt();
            int b = io.nextInt();
            cows[i] = new Pair(a, b);
        }
        Arrays.sort(chickens);
        Arrays.sort(cows);
        for(int i = 0; i < C; i++){
            int curr = chickens[i];
            for(int j = 0; j < N; j++){
                if(!paired[j] && cows[j].start<curr && cows[j].end>curr){
                    paired[j] = true;
                    ans++;
                    break;
                }
            }
                
        }
        io.println(ans);
        io.close();
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