import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 04 | [ Monday ]
 * Time: 20 : 34 : 49 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class B_Fair_Division {

    public void solve() throws Exception {
        
        int n = in.getInt();
       
        int o = 0;
        int t = 0;

        for(int i = 0 ; i < n; i++ ) {
            
            int val = in.getInt();

            if(val == 1 ) { 
                o++;
            } else {
                t++;
            }
        }

        int sum = o+(t*2);

        if(sum%2 != 0) {
            out.println("NO");
        } else  if(o%2 == 0 && t%2 == 0) {
            out.println("YES");
        } else if(o%2 ==1) {
            out.println("YES");
        } else {
            out.println("NO");
        }


    } // End

    public B_Fair_Division() throws Exception {
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
            new B_Fair_Division();
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
