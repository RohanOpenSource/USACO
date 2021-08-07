import java.io.*;
import java.util.*;

public class Digits{
    private static final String SYMBOLS = "0123456789";
    public static void main(String[] args){
        Kattio io = new Kattio();
        int b2 = io.nextInt();
        int b3 = io.nextInt();
        b2s = b2.toString();
        b3s = b3.toString();
        for(int i = 0; i < b2s.length; i++){
            sum2^=(1<<(b2s.length-1-i));
            for(int k = 0; k < b3s.length; k++){
                sum3-=(str3.length-1-k*str3.length-1-k*str3.length-1-k);
                if(sum2==sum3){
                    io.println(sum2);
                    return;
                }
                sum3-=(str3.length-1-k*str3.length-1-k*str3.length-1-k);
                sum^ = (1<<b2s.length-1-i)
            }
        }
    }
    private int convert(String n, int base){
        int out = 0;
        int position = number.length(); 
        for (char ch : number.toCharArray())
        {
            int value = SYMBOLS.indexOf(ch);
            out += value * pow(base,--position); 

        }
        return out;
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