package usaco_problems;

import java.io.IOException;

public class FencePainting {
	public static void main(String[] args) throws IOException{
		Kattio reader = new Kattio("paint");
		int a = reader.nextInt();
		int b = reader.nextInt();
		int c = reader.nextInt();
		int d = reader.nextInt();
		
		int output;
		int intersection = Utils.min(b, d) - Utils.max(a, c);
		if(intersection > 0) output = ((b - a) + (d - c)) - intersection;
		else output = 0;
		
		reader.println(output);
		reader.close();
	}
}
