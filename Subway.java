import java.io.*;
import java.util.*;

public class Subway{
    private static int N;
    private static int M;
    private static Kattio io;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    public static void main(String[] args){
        boolean printed = false;
        io = new Kattio();
        N = io.nextInt();
        M = io.nextInt();
        graph = new ArrayList[N];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            graph[a].add(b);
            graph[b].add(a); 
        }
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            int start = i;
            visited[start] = true;
            dfs(start);
            if(!visited[0]){
                io.println(i+1);
                printed = true;
            }
        }
        if(!printed)
        io.println(0);
        io.close();

    }
    
public static void dfs(int n) {
        if (n == 0)
            return;

        for (int i : graph[n]) {
            if (visited[i])
                continue;
            visited[i] = true;
            dfs(i);
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