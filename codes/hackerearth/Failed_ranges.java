import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 02 | [ Saturday ]
 * Time: 10 : 13 : 37 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

class Failed_ranges {

    public void solve() throws Exception {

        int n = in.getInt();
        int m = in.getInt();

        int[] na = in.getIntArray(n);
        int[] ma = in.getIntArray(m);

        int x = in.getInt();
        int y = in.getInt();

        Map<Integer, List<String>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++ ) {
            for(int j = 0; j < m; j++ ) {

                int sum = na[i] + ma[j];

                List<String> pp = map.getOrDefault(sum, new ArrayList<String>());
                pp.add(i +":" + j);

                map.put(sum, pp);
                list.add(sum);
            }
        }

        Collections.sort(list);

        Set<String> result = new HashSet<>();

        for(int i = x; i< y-1; i++ ) {
            int sum = list.get(i);
            result.addAll( map.get(sum));
        }


        out.println(result.size());

        List<String> sorted = new ArrayList<>();
        sorted.addAll(result);


        Collections.sort(sorted);
        
        for(String cc : sorted) {
            
            String[] ttt = cc.split(":");

            out.print("(" + (Integer.parseInt(ttt[0]) + 1)  +"," + (Integer.parseInt(ttt[1]) + 1) + ") ");
        }
       
    } // End

    public Failed_ranges() throws Exception {
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
            new Failed_ranges();
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
