import java.io.*;
import java.util.*;

public class Dining{
    public static void main(String[] args){
        Kattio io = new Kattio();
        int N = io.nextInt();
        int[] cards = new int[N];
        int r = 0;
        int l = 0;
        for(int i = 0; i < N; i++){
            cards[i] = io.nextInt();
            if(cards[i]==1) r++;
        }
        int ans = 1000000;
        for(int i = 0; i < N; i++){
            if(cards[i]==1) r--;
            else l++;
            ans = Math.min(ans, l+r);
        }
        if(ans == 1) ans = 0;
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