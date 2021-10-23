import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 04 | [ Monday ]
 * Time: 10 : 36 : 23 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

  class Fair_Elections {

    public void solve() throws Exception {

        Integer john = in.getInt();
        Integer jack = in.getInt();

        Long johnsum = 0l, jacksum = 0l;

        Long[] pjohn = new Long[john];
        Long[] pjack = new Long[jack];
        
        for( int i = 0 ; i < john; i++ ) {
            Long val = in.getLong();
            pjohn[i] = val;
            johnsum += val; 
        }

        for(int i = 0 ; i < jack ; i++ ) {
            Long val = in.getLong();
            pjack[i] = val;
            jacksum += val;
        }

        if(johnsum > jacksum ) {
            out.println("0");
            return;
        }
        
        if(johnsum == jacksum ) {
            out.println("1");
            return;
        }

        Arrays.sort(pjohn);
        Arrays.sort(pjack, Collections.reverseOrder());

        int iterator = 0;
        while(jacksum > johnsum) {

            if(iterator >= jack && iterator >= john && pjack[iterator] < pjohn[iterator]) {
                out.println("-1");
                return;
            }

            johnsum = (johnsum - pjohn[iterator]) + pjack[iterator];
            jacksum = (jacksum - pjack[iterator]) + pjohn[iterator];

            iterator++;
        }        

        out.println(iterator);
        return;
    } // End

    public Fair_Elections() throws Exception {
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
            new Fair_Elections();
            exit(0);
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

        public Integer[] getIntArray(int n) {
            Integer[] temp = new Integer[n];
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
