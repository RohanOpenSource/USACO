import java.io;
import java.util;
import java.Arrays;

public class PastureWalk{
    private int ans = 0;
    static ArrayList[] graph;
    public static void main(String[] args){
        Kattio io = new Kattio();
        int N = io.nextInt();
        int Q = io.nextInt();
        graph = new ArrayList[N];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            int l = io.nextInt();
            graph[a].add(new Edge(b, l));
            graph[b].add(new Edge(a, l));
        }
        DepthFirstSeach(graph[0]);
        io.println(visited[0]);
    }

    private void DepthFirstSeach(int curr, int d, int g){
        if(curr == g){
            return;
        }
        for(int i = 0; i < graph[curr]; i++){
            if(!visited[i]){
                visited[i] = true;
                DepthFirstSeach(curr, d+i, g);
            }
        }
        
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
}

class Edge {
    int first, second;

    public Edge(int first, int second) {
        this.first = first;
        this.second = second;
    }
}