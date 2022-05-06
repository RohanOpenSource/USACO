import java.io.*;
import java.util.*;

public class UFF{
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio();
        int n = io.nextInt();
        int k = io.nextInt();
        Pair[] pairs = new Pair[k];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        HashMap<Integer, HashSet<Integer>> h = new HashMap<Integer, HashSet<Integer>>();
        for(int i = 0; i < k; i++){
            int a = io.nextInt();
            int b = io.nextInt();
            if(!h.containsKey(a)){
                h.put(a, new HashSet<Integer>());
            }
            if(!h.containsKey(b)){
                h.put(b, new HashSet<Integer>());
            }
            h.get(a).add(b);
            h.get(b).add(a);
            if(!pq.contains(a)){
                pq.add(a);
            }
            if(!pq.contains(b)){
                pq.add(b);
            }
        }
        HashSet<Integer> curr = new HashSet<Integer>();
        int ans = 0;
        while(!pq.isEmpty()){
            int c = pq.poll();
            for(int item:curr){
                if(h.get(item).contains(c)){
                    ans++;
                    curr.clear();
                    break;
                }
            }
            curr.add(c);
        }
        io.println(ans+1);
		io.close();
    }

    public static class Pair implements Comparable<Pair>{
        int low;
        int high;
        public Pair(int low, int high){
            this.low = low;
            this.high = high;
        }
        @Override public int compareTo(Pair o){
            return Integer.compare(low, o.low);
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
