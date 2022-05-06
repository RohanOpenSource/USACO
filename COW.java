import java.io.*;
import java.util.*;

public class COW{
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio();
        int n = io.nextInt();
        String word = io.next();
        char[] arr = new char[n];
        for (int i = 0; i < word.length(); i++) {
            arr[i] = word.charAt(i);
        }
        long c = 0, o = 0, w = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 'C') c++;
            else if(arr[i] == 'O') o+=c;
            else if(arr[i] == 'W') w+=o;
        }
        io.println(w);
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
