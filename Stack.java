import java.io.*;
import java.util.*;

public class Stack{
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio();
        int n = io.nextInt();
        int k = io.nextInt();
        int[] arr = new int[n+1];
        int[] ps = new int[n+1];
        int total = 0;
        for(int i = 0; i < k; i++){
            int low = io.nextInt();
            int high = io.nextInt();
            arr[low-1]++;
            arr[high]--;
        }
        for(int i = 0; i < n; i++){
            total+=arr[i];
            ps[i] = total;
        }
        Arrays.sort(ps);
        int ans = ps[ps.length/2];
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
