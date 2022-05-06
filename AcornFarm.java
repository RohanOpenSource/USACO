import java.io.*;
import java.util.*;

public class AcornFarm{
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio();
        int n = io.nextInt();
		int a = io.nextInt(); //useless
		Event[] events = new Event[n];
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		TreeMap<Integer, Integer> map2 = new TreeMap<Integer, Integer>();
	
        for(int i = 0; i < n; i++){
			int x = io.nextInt();
			int y = io.nextInt();
			int z = io.nextInt();
			events[i] = new Event(x, y, z);
		}
		Arrays.sort(events);

		for(int i=0; i<n; i++){
			map1.put(events[i].id, 0);
		}
		map2.put(0, map1.size());

		int ans = 0;
		for(int i = 0; i < n; i++){
			Event e = events[i];
			int oldMax = map2.lastKey();
			int curr = map1.get(e.id);
			int newVal = curr+e.change;
			map1.put(e.id, newVal);

			int val = map2.get(curr);
			if(val == 1) {
				map2.remove(curr);
			} else {
				map2.put(curr, val-1);
			}

			Integer oldVal = map2.get(newVal);
			if(oldVal == null) map2.put(newVal, 1);
			else map2.put(newVal, oldVal+1);
			int newMax = map2.lastKey();

			if((newMax == newVal && oldMax != curr) || (oldMax == curr && newMax != newVal)){
				ans++;
			}
			
		}
		io.println(ans+1);
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

	static class Event implements Comparable<Event>{
		int day;
		int id;
		int change;
		public Event(int day, int id, int change){
			this.day = day;
			this.id = id;
			this.change = change;
		}
		@Override
		public int compareTo(Event other) {
			return Integer.compare(day, other.day);
		}
	}
}
