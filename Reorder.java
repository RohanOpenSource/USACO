import java.io.*;
import java.util.*;

public class Reorder{
    private static int N;
    private static int[] a;
    private static int[] b;
    private static int[] bi;
    private static int[] visited;
    private static int longest = 0;
    private static int total = 0;
    public static void main(String[] args){
        Kattio io = new Kattio();
        N = io.nextInt();
        a = new int[N];
        b = new int[N];
        bi = new int[N+1];
        visited = new int[N];
        for(int i=0; i<N; i++){
            a[i] = io.nextInt();
        }
        for(int i=0; i<N; i++){
            b[i] = io.nextInt();
            bi[b[i]] = i;
        }

        for(int i=0; i<N; i++){
            if(a[i] != b[i] && visited[i]==0){
                int l = count(i);
                if(l > longest) longest = l;
                total++;
            }
        }
        longest++;
        if(longest == 1) longest = -1;
        io.print(total + " " + longest);
        io.close();
    }

    private static int count(int start){
        int count = 0;
        int i = start;
        visited[i] = 1;
        i = bi[a[i]];
        while (i != start){
            visited[i] = 1;
            i = bi[a[i]];
            count++;
        }
        return count;
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
}