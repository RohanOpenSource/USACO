import java.io.*;
import java.util.*;

public class Disco{
    private static int R;
    private static int C;
    private static boolean[][] grid;
    private static int ans;
    public static void main(String[] args){
        Kattio io = new Kattio();
        R = io.nextInt();
        C = io.nextInt();
        grid = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = io.next();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j) == 'R';
            }
        }
        if(grid[0][0])floodfill(0, 0, true);
        else floodfill(0, 0, false);
        io.println(ans-1);
        io.close();
    }

    private static void floodfill(int r, int c, boolean color){
        if(r==(R-1) && c==(C-1)){
            ans++;
            return;
        }

        for(int i = r+1; i < R; i++){
            for(int j = c+1; j < C; j++){
                if(grid[i][j]!=color)floodfill(i, j, !color);
            }
        }
        return;
        

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