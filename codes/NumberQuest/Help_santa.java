import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 23 | [ Wednesday ]
 * Time: 18 : 04 : 59 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class Help_santa {

    public void solve() throws Exception {

        in.getInt();

        String str = in.getLine();
        str = str.replaceAll("\\s", ""); 
        char[] c = str.toCharArray();

        Arrays.sort(c);

        char last = c[0];
        
        out.print(Character.toString(c[0]) + " " ) ;
        for(int i = 1 ; i< c.length-1; i++) {
            if(last!= c[i]) {
                if(i == c.length-1) {
                    out.print(c[i]);
                } else {
                out.print(Character.toString(c[i]) + " " ) ;
                last = c[i];
                }
            }
        }
       
    } // End

    public Help_santa() throws Exception {
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
            new Help_santa();
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
