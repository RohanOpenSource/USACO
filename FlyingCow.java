import java.io.*;
import java.util.*;

public class FlyingCow{
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio();
        int n = io.nextInt();

        boolean[] v = new boolean[n + 1];
        Queue<Integer> xs = new LinkedList<Integer>();
        Queue<Integer> times = new LinkedList<Integer>();

        xs.add(1);
        times.add(0);
        v[1] = true;
        int ans = 0;
        while(!xs.isEmpty()) {
            int x = xs.poll();
            int t = times.poll();

            if(x == n) {
                ans = t;
                break;
            }

            if(3*x <= n) {
                v[3*x] = true;
                xs.add(3*x);
                times.add(t+1);
            }

            if(x < n) {
                v[x + 1] = true;
                xs.add(x+1);
                times.add(t+1);
            }

            if(x > 1) {
                v[x - 1] = true;
                xs.add(x-1);
                times.add(t+1);
            }
        }
        io.println(ans);
        io.close();
    }
	static class Kattio extends PrintWriter {
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
}
