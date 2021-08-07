import java.io.*;
import java.util.*;

public class Perimeter {
	static Point[] bales;
	static int[][] field;
    static int perimiter;
	
	public static void main(String[] args) {
        Kattio io = new Kattio();
        bales = new Point[io.nextInt()];
        int n = 100;

        field = new int[n + 4][n + 4];
       

        for (int i = 0; i < bales.length; i++) {
            int x = io.nextInt();
            int y = io.nextInt();
            field[x + 2][y + 2] = 1;
            bales[i] = new Point(x + 2, y + 2);
        }
        floodfill(1, 1);
        io.println(perimiter);
        io.close();
	}

    private static void floodfill(int x, int y){
        if(field[x][y] == 2 || x<=0 || x>=99 || y<=0 || y>=99){
            return;
        }
        if(field[x][y] == 1){
            perimiter++;
            field[x][y] = 2;
            return;
        }
        field[x][y] = 2;
        floodfill(x-1, y);
        floodfill(x+1, y);
        floodfill(x, y-1);
        floodfill(x, y+1);
    }
}
class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y; 
        }

        public int dist(int x2, int y2) {
            return (x2 - x) * (x2 - x) + (y2 - y) * (y2 - y);
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
