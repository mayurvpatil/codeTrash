import static java.lang.System.exit;
import java.io.*;
import java.util.*;


/**
 * @author mayurvpatil
 *
 * Date: 2020 December 24 | [ Thursday ]
 * Time: 10 : 15 : 37 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] l, char t) {

        Set<Character> set = new LinkedHashSet<>();

        for(int i = 0 ; i < l.length; i++ ) set.add(Character.valueOf(l[i]));

        int n = set.size(); 
        Character arr[] = new Character[n]; 
  
        System.arraycopy(set.toArray(), 0, arr, 0, n); 

        Character target = Character.valueOf(t);
        

        int start = 0;
        int end = arr.length;

        while(start < end ) {

            int mid = (start + end ) >>> 1;
            
            if(arr[mid] == target ) {
                if(mid+1 == arr.length) {
                    return arr[0];
                } else {

                    if(mid == mid-1) {
                        return arr[mid];
                    }
                    return arr[mid+1];
                }
            }

            if(arr[mid] < target) {
                start = mid +1;
            } else {
                end = mid;
            }
        }

        if(end == arr.length) {
            return arr[0];
        } else {
            return arr[end];
        }
        
    }

    public void solve() throws Exception {
        
        char[] c = new char[]{'e','e','e','e','e','e','n','n','n','n'};

        System.out.println(nextGreatestLetter1(c, 'n'));


    } // End

    public char nextGreatestLetter1(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    }

    public FindSmallestLetterGreaterThanTarget() throws Exception {
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
            new FindSmallestLetterGreaterThanTarget();
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
