import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 21 | [ Monday ]
 * Time: 22 : 04 : 47 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class Self_Destructing_Strings {

    public void solve() throws Exception {
       
        char[] c = in.getString().toCharArray();

        if(c.length % 2 != 0) {
            out.println("-1");
            return;
        } 

        Stack<Character> s = new Stack<>();

        int i = 1;
        s.add(c[0]); 
        int count = 0 ;
        boolean cc = false;
        while( i != c.length ) {

            if(s.isEmpty()) {
                s.push(c[i]);
                cc = false;
                continue;
            }

            if(c[i] == s.peek()) {

                if(i+1<c.length-1) {
                if(c[i] != c[i+1]) {
                    i += 2;
                    continue;
                    }
                }

                s.push(c[i]);
                if(cc) {
                    count++;
                }
            } else {
                s.pop();
                cc = true;
            }

            i++;
            
        }

        if(s.size() > 1) {
            out.println(s.size()/2);
        } else {

            out.println(count);
        }

    } // End

    public Self_Destructing_Strings() throws Exception {
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
            new Self_Destructing_Strings();
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
