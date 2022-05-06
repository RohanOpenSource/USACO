import java.io.*;
import java.util.*;

public class Stork{
	static char[][] letters = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N', 'O'}, {'P', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y'}};


	static void generate(int index) {
		System.out.println(index);
		if(index >= len) {
			StringBuilder sb = new StringBuilder();
			for(char el: name) {
				sb.append(el);
			}
			generatedNames.add(sb.toString());
			return;
		}
		//System.out.println(id[index]);
		for(char letter: letters[id[index]]) {
			name.add(letter);
			generate(index + 1);
			name.remove(name.size() - 1);
		}
	}

	static HashSet generatedNames = new HashSet<String>();
	static ArrayList<Character> name = new ArrayList<Character>();
	static int len, id[];
    public static void main(String[] args) throws IOException{
        Kattio io = new Kattio("q");
        String idStr = "" + io.nextInt();
		id = new int[idStr.length()];
		for(int i=0; i<idStr.length(); i++) {
			id[i] = Character.getNumericValue(idStr.charAt(i)) - 2;
		}
		len = id.length;
		
        ArrayList<String> dict = new ArrayList<String>();

        while(true){
            String next = io.next();
            if(next == null) break;
			dict.add(next);
        }

		generate(0);

		for(String el: dict) {
			if(generatedNames.contains(el)) {
				io.println(el);
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
