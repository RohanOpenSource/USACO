import java.io.*;
import java.util.*;

public class Pageant{
    static int[][] spots;
    static int[][] input;
    static int[][] visited;
    static int R;
    static int C;
    public static void main(String[] args){
        Kattio io = new Kattio();
        R = io.nextInt();
        C = io.nextInt();
        input = new int[R][C];
        spots = new int[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                input[i][j] = io.nextInt(); 
            }
        }
        floodfill(0, 0); 
        int ans=10000000;
        for(i in spots[0]){
            for(j in spots[1]){
                if(Math.abs(spots[i][j], spots[])+Math.abs(spots[]))
            }
        }
        io.println(ans)

    }
    private static void floodfill(int r, int c){
        if (input[r][c]!='X' || visited[r][c]) return;
        visited[r][c] = true;
        if (r>0) label(r-1,c,ch);
        if (c>0) label(r,c-1,ch);
        if (r<N-1) label(r+1,c,ch);
        if (c<M-1) label(r,c+1,ch);
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