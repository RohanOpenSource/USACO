import java.io.*;
import java.util.*;

public class Bowls{
    public static void main(String[] args){
        Kattio io = new Kattio();
        int n = 20;
        boolean[] bowls = new boolean[n];
        for(int i = 0; i < n; i++){
            bowls[i] = (io.nextInt()==0);
        }
        int ans = Integer.MAX_VALUE;
        for (int mask = 0; mask < (1 << n); mask++) {
            boolean[] temp = bowls.clone();
            int count = 0;
            boolean cando = true;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) > 0){
                    temp[i] = !temp[i];
                    if(i != 0){
                        temp[i-1] = !temp[i-1];
                    }
                    if(i != n-1){
                        temp[i+1] = !temp[i+1];
                    }
                    count++;
                }
            }
            for(int i = 0; i < n; i++){
                if(!temp[i]){
                    cando = false;
                }
            }
            if(cando){
                ans = Math.min(ans, count);
            }

        }
        io.println(ans);
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