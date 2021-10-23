import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2021 January 10 | [ Sunday ]
 * Time: 17 : 51 : 50 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class SubsetsII {


    int[] n = null;
    List<List<Integer>> result = new ArrayList<>();
    
    public boolean iscontain(List<Integer> current ) {
        
        Map<Integer, Integer> cmap = new HashMap<>();
        for(Integer a : current) {
            cmap.put(a, cmap.getOrDefault(a, 0) + 1);
        }
        
        for(List<Integer> a : result) {
            if(a.size() == current.size()) {
                
                Map<Integer, Integer> amap = new HashMap<>();
                for(Integer aa : a) {
                    amap.put(aa, amap.getOrDefault(aa, 0) + 1);
                }

                if(cmap.equals(amap)) return true;
            }
        }
        return false;
    }
    
    public void updateList(List<Integer> current, int i) {
       
        if(i == n.length) {
            
            if(!iscontain(current)) {
                result.add(current);            
            }
            return;
        }
        
        updateList(new ArrayList<>(current), i + 1);
        
        List<Integer> cpy = new ArrayList<>(current);
        
        cpy.add(n[i]);
        updateList(cpy, i+1);
        
    }
    
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        n = nums;
        updateList(new ArrayList<>(), 0);
        return result;
        
    }

    public void solve() throws Exception {

        int[] a = new int[] { 1,2,2};
        
        List<List<Integer>> ss = subsetsWithDup(a);

        System.out.println("Output : ");

        for(List<Integer> ww : ss) {
            for(Integer aa : ww) {
                System.out.print(aa + " ");
            }
            System.out.println("");
        }


    } // End

    public SubsetsII() throws Exception {
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
            new SubsetsII();
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
