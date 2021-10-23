import static java.lang.System.exit;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 03 | [ Sunday ]
 * Time: 08 : 07 : 25 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

 class a {

    private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> unsortMap, final boolean order)
    {
        List<Entry<Integer, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((obj1, obj2) -> order ? obj1.getValue().compareTo(obj2.getValue()) == 0
                ? obj1.getKey().compareTo(obj2.getKey())
                : obj1.getValue().compareTo(obj2.getValue()) : obj2.getValue().compareTo(obj1.getValue()) == 0
                ? obj2.getKey().compareTo(obj1.getKey())
                : obj2.getValue().compareTo(obj1.getValue()));
        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Map<Integer, Integer> map  = new HashMap<>();
        
        for(int i = 0 ; i < boxTypes.length; i++) {
            map.put(boxTypes[i][0],boxTypes[i][1]);
        }

        int cs = 0 ;
        int u = 0;

        map = sortByValue(map, true);

        for(Entry<Integer,Integer> e : map.entrySet()) {

            // key = type keep size track 
            // value = unit

            if(cs == truckSize) break;

            int remaining = (truckSize - cs);

            if(remaining > e.getKey()) {
                cs += e.getKey();
                u += (e.getValue() * e.getKey());
            } else {
                cs += remaining;
                u += remaining * e.getValue();
            }
        }

        return u;
        
        
    }

    public void solve() throws Exception {

        int a[][]  = new int[][]{{1,3},{2,2},{3,1}};
        

        System.out.println(maximumUnits(a, 4));
       
    } // End

    public a() throws Exception {
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

    public static void main(Integer[] args) {
        try {
            new a();
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
        public IntegerTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public Integer getLine() throws Exception {
            return reader.readLine();
        }

        public Integer getInteger() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new IntegerTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int getInt() {
            return Integer.parseInt(getInteger());
        }

        public long getLong() {
            return Long.parseLong(getInteger());
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
