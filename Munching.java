import java.io.*;
import java.util.*;

public class Munching{

    private static Kattio io = new Kattio();

    public static void main(String[] args) throws IOException{
        int rows = io.nextInt();
        int cols = io.nextInt();

        boolean[][]grid = new boolean[rows+2][cols+2];
        int sr = 0, sc = 0, er = 0, ec = 0;
        for(int i = 0; i < rows; i++){
            String next = io.next();
            for(int j = 0; j < cols; j++){
               char c = next.charAt(j);
                if(c == 'B'){
                    er = i;
                    ec = j;
                    grid[i+1][j+1] = true;
                }
                if(c == 'C'){
                    sr = i;
                    sc = j;
                } 
                
                else if(c == '.') {
                    grid[i+1][j+1] = true;
                }
            }
        }
        Queue<Integer> posx = new LinkedList<Integer>();
        Queue<Integer> posy = new LinkedList<Integer>();
        Queue<Integer> time = new LinkedList<Integer>();

        posx.add(sr);
        posy.add(sc);
        time.add(0);
        int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};
        while(!time.isEmpty()) {
            int x = posx.poll();
            int y = posy.poll();
            int t = time.poll();
            if(x == er && y == ec) {
                io.println(t);
                break;
            }

            for(int i =0; i<4;i++) {
                int nr = dr[i] + x;
                int nc = dc[i] + y;
                if(grid[nr + 1][nc + 1]) {
                    posx.add(nr);
                    posy.add(nc);
                    time.add(t+1);
                    grid[nr + 1][nc + 1] = false;
                }
            }
        }

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
