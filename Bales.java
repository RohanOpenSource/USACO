import java.io.*;
import java.util.*;

public class Bales{
    public static void main(String[] args){
        Kattio io = new Kattio();
        int n = io.nextInt();
        Bale[] bales = new Bale[n];
        for(int i = 0; i < n; i++){
            int a = io.nextInt();
            int b = io.nextInt();
            bales[i] = new Bale(b, a);
        }
        Arrays.sort(bales);
        int ans = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int last = Integer.MAX_VALUE;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) >= 1)
                    if(bales[i].l < last){
                        last = bales[i].l;
                        count++;
                    }
                    else break;
            }
            ans = Math.max(count, ans);
        }
        io.println(ans);
        io.close();
    }
    static class Bale implements Comparable<Bale>{
        int l;
        int w;
        public Bale(int l, int w){
            this.l = l;
            this.w = w;
        }
        public int compareTo(Bale p) {
            if (p.w == w)return 0;
            return p.w > w ? 1 : -1;
        }
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