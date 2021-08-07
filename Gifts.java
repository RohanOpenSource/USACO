import java.io.*;
import java.util.*;

public class Gifts{
    public static void main(String[] args){
        Kattio io = new Kattio();
        int N = io.nextInt();
        int B = io.nextInt();
        int ans = 0;
        Pair[] G = new Pair[N];
        for(int i = 0; i < N; i++){
            int a = io.nextInt();
            int b = io.nextInt();
            G[i] = new Pair(a, b);
        }
        Arrays.sort(G);
        int total = 0;
        for(int i = 0; i < N; i++){
            total += (G[i].start + G[i].end);
            if(total > B){
                ans = i;
                for(int j = 0; j <= i; j++){
                    if(i >=1 && total-(G[j].start/2) > B){
                        ans = i+1;
                        break;
                    }
                }
                for(int j = i+1; j < N; j  ++){
                    if(i >=1 && total-(G[j].start/2)+G[j.end] > B){
                        ans = i+1;
                        break;
                    }
                }
                break;
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
        if ((p.start + p.end) == (start + end))
            return 0;
        return (p.start + p.end) < (start + end) ? 1 : -1;
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