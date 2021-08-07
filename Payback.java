import java.io.*;
import java.util.*;

public class Payback{
    public static void main(String[] args){
        Kattio io = new Kattio();
        int N = io.nextInt();
        int[] cows = new int[N];
        for(int i = 0; i < N; i++){
            cows[i] = io.nextInt();
        } 
        int j = -1;
        int m = 0;
        int count = 0;
        int total = 0;
        for(int i = 0; i < N; i++){
            if(cows[i] < 0){
                if(j==-1)j = i;
                m -= cows[i];
            }
            else {
                total+=cows[i];
            }
            if(total>=m){
                total -= m;
                 m=0;
                if(j!=-1)count += ((i-j)*2);
                j = -1;
            }
        }
        io.println(count+N);
        io.close();
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