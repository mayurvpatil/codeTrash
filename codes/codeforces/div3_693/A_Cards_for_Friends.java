import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 04 | [ Monday ]
 * Time: 20 : 09 : 29 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class A_Cards_for_Friends {

    public int  cut(int w, int h ) {

        if(w < 1 ) return 0;
        if(h < 1 ) return 0;

        if( w%2 == 0 && h%2 == 0 ) {
            return 1 + Math.max(cut(w/2, h) , cut(w, h/2));
        } 

        if(w%2 == 0 && h%2!= 0 ) {
            return 1 + cut(w/2,h);
        } 

        if(w%2 != 0 && h%2 == 0 ) {
            return 1 + cut(w/2,h);
        } 
        
        return 0;

    }

    public void solve() throws Exception {
        
        int w = in.getInt();
        int h = in.getInt();
        int n = in.getInt();

        int cuts = cut(w, h);

        if(cuts >=  n) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    } // End

    public A_Cards_for_Friends() throws Exception {
        boolean isMultipleTestCases = true;
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        if (isMultipleTestCases) {
            int t = in.getInt();
            for (int i = 1; i <= t; ++i) {
                solve();
            }
        } else {
            solve();
        }
        out.close();
    }

    public static void main(String[] args) {
        try {
            new A_Cards_for_Friends();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }

    private InputReader in = null;
    private PrintWriter out = null;

    // FastIO reader
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String getLine() throws Exception {
            return reader.readLine();
        }

        public String getString() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int getInt() {
            return Integer.parseInt(getString());
        }

        public long getLong() {
            return Long.parseLong(getString());
        }

        public int[] getIntArray(int n) {
            int[] temp = new int[n];
            for (int i = 0; i < n; i++)
                temp[i] = getInt();
            return temp;
        }

        public long[] getLongArray(int n) {
            long[] temp = new long[n];
            for (int i = 0; i < n; i++)
                temp[i] = getLong();
            return temp;
        }
    }
}
