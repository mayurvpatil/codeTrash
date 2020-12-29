import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 16 | [ Wednesday ]
 * Time: 02 : 59 : 36 
 * 
 * CodeChef solution
 */

class Reverse {

    public void solve() throws Exception{

        int n = in.getInt();

        
        String s = "";
        for(int i =0 ; i < n; i++ ) {
            s += in.reader.readLine() + " ";
        }

       // out.println(s);

        String[] ss = s.split(" ");

        int ccount = 90;

        for(int i = ss.length-1; i >= 0; i--) {

            String t = ss[i];

            if(t.isEmpty()) continue;
            t = t.replaceAll("[, ; . ' :]", "");
            t = t.replaceAll("\\s", "");

            if(ccount-t.length() < 2) {
                out.println();
                ccount = 90;
            } 

            out.print(t +  " ");
            ccount -= t.length() + 1;

        }

    } // End

    public Reverse() throws Exception {
        boolean isMultipleTestCases = false;
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        if (isMultipleTestCases) {
            int t = in.getInt();
            for (int i = 1; i <= t; ++i) {
                //out.print("Case #" + i + ": ");
                solve();
            }
        } else {
            solve();
        }
        out.close();
    }

    public static void main(String[] args) {
        try {
            new Reverse();
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


        public String getLine() {
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
            return Integer.parseInt(getLine());
        }

        public long getLong() {
            return Long.parseLong(getLine());
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
