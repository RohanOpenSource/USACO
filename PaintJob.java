import java.io.*;
import java.util.*;

public class PaintJob{
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio();
        int a = io.nextInt();
		int b = io.nextInt();
		int n = io.nextInt();
		int p = io.nextInt();
		int[] colors = new int[n];

		boolean[] v = new boolean[p+1];
        Queue<Integer> xs = new LinkedList<Integer>();
        Queue<Integer> times = new LinkedList<Integer>();

		xs.add(a);
		times.add(0);
		v[a] = true;

		for(int i = 0; i < n; i++){
			colors[i] = io.nextInt();
		}
		
		int ans = -1;
		while(!xs.isEmpty()){
			int x = xs.poll();
			int t = times.poll();
			if(x==b){
				ans = t;
				break;
			}
			for(int i = 0; i < colors.length; i++){
				int temp = (x*colors[i])%p;
				if(!v[temp]){
					v[temp] = true;
					xs.add(temp);
					times.add(t+1);
				}
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
