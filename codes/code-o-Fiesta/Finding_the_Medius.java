import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 26 | [ Saturday ]
 * Time: 15 : 32 : 46 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class Finding_the_Medius {


    public void solve() throws Exception {

        int n = in.getInt();
        int[] a = in.getIntArray(n);
        int k = in.getInt();

        int start = 0 ;
        int end = k ;

        while (end <= n) {

            int[] nn = Arrays.copyOfRange(a, start, end);
            Arrays.sort(nn);
            int mid =  (nn.length) >>> 1;
            

            if((start + end )%2 == 0) {
                out.print( (float) ( nn[mid] + nn[mid - 1 ] )/2 + " ");
            } else {
               

                out.print(nn[mid] + " ");
            }

            start++;
            end++;

        }


    } // End

    public Finding_the_Medius() throws Exception {
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
            new Finding_the_Medius();
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
