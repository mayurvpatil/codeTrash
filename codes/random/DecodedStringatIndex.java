import static java.lang.System.exit;
import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 21 | [ Monday ]
 * Time: 01 : 59 : 30 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class DecodedStringatIndex {

    public String decodeAtIndex(String s, int K) {

        long size = 0 ;
        for(int i =0 ; i < s.length(); ++i ) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size++;
            }
        }

        for(   int i = s.length()-1 ; i >= 0 ; i--) {

            K %= size;

            char c = s.charAt(i) ;
            
            if(K == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }
            
            if(Character.isDigit(c)) {
                size /= (c - '0');
            } else {
                size--;
            }
        }
        return "NOt found";

    }

    public void solve() throws Exception {
       
        System.out.println(decodeAtIndex("a2345678999999999999999", 1));



    } // End

    public DecodedStringatIndex() throws Exception {
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
            new DecodedStringatIndex();
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
