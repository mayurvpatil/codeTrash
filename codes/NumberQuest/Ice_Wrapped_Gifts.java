import static java.lang.System.exit;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors; 
import java.util.stream.Stream;


/**
 * @author mayurvpatil
 *
 * Date: 2020 December 23 | [ Wednesday ]
 * Time: 18 : 34 : 04 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class Ice_Wrapped_Gifts {

    public void solve() throws Exception {

        int n = in.getInt();
        
        String[] re = new String[n];
        String t = n + "";
        
        
        t = String.join("", Collections.nCopies(n*2-1, t));
        int ind = 0;
        re[ind++] = t;

        int aa = n-1;
        String q = aa + "";
        for(int i = 1 ; i<n; i++ ) {
            t = t.substring(0, i) + String.join("", Collections.nCopies(aa*2-1, q)) + t.substring((n*2-1)-i, n*2-1);
            aa--;
            q=aa+"";
            re[ind++] = t;
        }

        String pp = "";

        for(int i = 0; i<n ; i++ ) {
                pp+= re[i].replaceAll("\\B", " ") + "\n";
        }
        for(int i = n-2 ; i>= 0 ; i--) {
            if(i == 0 ){
                pp+= re[i].replaceAll("\\B", " ");
            } else {
                pp+= re[i].replaceAll("\\B", " ") + "\n";
            }
        }
        out.print(pp);
       
       
    } // End

    public Ice_Wrapped_Gifts() throws Exception {
        boolean isMultipleTestCases = false;
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
            new Ice_Wrapped_Gifts();
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
