import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 04 | [ Monday ]
 * Time: 04 : 29 : 25 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class Encoded_String {

    public String encodeChar(String input) {

        int start = 0 ;
        int end = 15;
        boolean inFirstHalf = true;

        int mid = 0 ; 

        for(int i = 0 ; i < 4 ; i++) {
            mid = (start + end ) /2 ;
            if(input.charAt(i) == '0') {
                end = mid;
                inFirstHalf = true;
            } else {
                start = mid + 1;
                inFirstHalf = false;
            }
        }

        if(inFirstHalf)
            return Character.toString( (char) ( (char)'a' + (char) start));
        else 
            return Character.toString( (char) ((char)'a' + (char) end));
    }

    public void solve() throws Exception {

        in.getInt();
        String operations = in.getLine();
        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < operations.length(); i = i + 4 ) {
            result.append(encodeChar(operations.substring(i, i + 4)));
        }

        out.println(result);



    } // End

    public Encoded_String() throws Exception {
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
            new Encoded_String();
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
