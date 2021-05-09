package IO;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;





public class Input {

	static BufferedReader br;
	static PrintWriter out;
	static {
		try {
			br = new BufferedReader(new FileReader("in.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			out = new PrintWriter(new FileWriter("out.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 static StringTokenizer st;

 static String next() throws IOException {
     while (st == null || !st.hasMoreTokens())
         st = new StringTokenizer(br.readLine().trim());
     return st.nextToken();
 }

 static long readLong() throws IOException {
     return Long.parseLong(next());
 }

 public static int readInt() throws IOException {
     return Integer.parseInt(next());
 }

 static double readDouble() throws IOException {
     return Double.parseDouble(next());
 }

 static char readCharacter() throws IOException {
     return next().charAt(0);
 }

 static String readLine() throws IOException {
     return br.readLine().trim();
 }
}

//class Graph {
//private int V; // No. of vertices
//private LinkedList<Integer> adj[]; // Adjacency Lists

//// Constructor
//Graph(int v) {
//V = v;
//adj = new LinkedList[v];
//for (int i = 0; i < v; ++i)
//adj[i] = new LinkedList();
//}

//// Function to add an edge into the graph
//void addEdge(int v, int w) {
//adj[v].add(w);
//}
//}