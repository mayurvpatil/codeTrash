import static java.lang.System.exit;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 03 | [ Sunday ]
 * Time: 08 : 29 : 58 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */
 class maxProfit {

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

    public static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
          @Override              
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        }); 
    } 

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        sortbyColumn(boxTypes, 1);

        int cs = 0 ;
        int u = 0;

        for(int i = boxTypes.length-1 ; i >=0 ; i-- )  {

            // key = type keep size track 
            // value = unit

            if(cs == truckSize) break;

            int remaining = (truckSize - cs);

            if(remaining > boxTypes[i][0]) {
                cs +=  boxTypes[i][0];
                u += ( boxTypes[i][1] *  boxTypes[i][0]);
            } else {
                cs += remaining;
                u += remaining *  boxTypes[i][1];
            }
        }

        return u;
        
        
    }

    public void solve() throws Exception {

        
        int a[][]  = new int[][]{{2,1},{4,4},{3,1},{4,1},{2,4},{3,4},{1,3},{4,3},{5,3},{5,3}};


        System.out.println(maximumUnits(a, 13));
       
    } // End

    public maxProfit() throws Exception {
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
            new maxProfit();
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
