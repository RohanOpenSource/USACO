import java.io.*;
import java.util.*;

public class SocialDistancing{
	static int N, M;
	static Pair[] intervals;
	public static void main(String[] args){
		Kattio io = new Kattio();
		N = io.nextInt(); 
        M = io.nextInt(); 
        intervals = new Pair[M];
		for(int i = 0; i<M; i++){
			int a = io.nextInt(); 
            int b = io.nextInt();
			intervals[i] = new Pair(a, b);
		}
		Arrays.sort(intervals);

		long ans = 0, r = (long)1000000000;
		while(ans < r){
			long mid = (ans + r + 1) / 2;
			if(solve(mid)){
				ans = mid;
			}
			else{
				r = mid-1;
			}
		}

		io.println(ans);
		io.close();
	}

	private static boolean solve(long ms){
		long pos = intervals[0].start; 
		int j = 0;
		for(int i = 1; i<N; i++){
			if(pos+ms > intervals[j].start){
				while(intervals[j].start < pos+ms && intervals[j].start < pos+ms){
					j++;
					if(j == M) return false;
			    }
            pos = Math.max(intervals[j], pos+ms);
			}
			else{
				pos += ms;
			}
		}
		return true;
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