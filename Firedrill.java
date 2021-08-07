import java.io.*;
import java.util.*;

public class Firedrill{
    private static int N;
    public static void main(String[] args){
        Kattio io = new Kattio();
        N = io.nextInt();
        boolean[] visited = new boolean[N];
        int i = 0;
        while (true) {
            visited[i] = true;
            int next = (i * 2 + 1) % N;

            if (visited[next]) {
                io.println(i + 1);
                break;
            }
            i = (i * 2 + 1) % N;
        }
        io.close();
    }
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
		public Kattio(String problemName) throws IOException {
			super(new FileWriter(problemName + ".out"));
			r = new BufferedReader(new FileReader(problemName + ".in"));
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
