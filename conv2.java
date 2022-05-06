import java.io.*;
import java.util.*;


public class conv2{
	public static void main(String[] args) throws Exception {
        Kattio io = new Kattio();
		int n = io.nextInt();
		cow[] cows = new cow[n];
		
		for (int i=0; i<n; i++) {
			int s = io.nextInt();
			int t = io.nextInt();
			cows[i] = new cow(s,t,i);
		}
		Arrays.sort(cows);

		PriorityQueue<cow> waiting = new PriorityQueue<cow>(10, new Comparator<cow>() {public int compare(cow a, cow b) {return a.priority-b.priority;}});
		
		int curT = 0, ans = 0;
		int curCow = 0;
		
		while (curCow < n || waiting.size() > 0) {
			
			if (curCow < n && cows[curCow].start <= curT) {
				waiting.offer(cows[curCow++]);
			}

			else if (waiting.size() == 0) {
				cow cur = cows[curCow++];
				curT = cur.start + cur.time;
			}			
			
			else {
				cow cur = waiting.poll();
				ans = Math.max(ans, curT-cur.start);
				curT += cur.time;	
			}
		}
        
        io.println(ans);
        io.close();
	}


    static class cow implements Comparable<cow> {
	
	    public int start;
	    public int time;
	    public int priority;
	
	    public cow(int s, int t, int p) {
		    start = s;
		    time = t;
		    priority = p;
	    }
	
	    public int compareTo(cow other) {
		    return this.start - other.start;
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
