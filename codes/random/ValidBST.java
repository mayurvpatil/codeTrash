import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 16 | [ Wednesday ]
 * Time: 23 : 12 : 24 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class ValidBST {


    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x ) { val = x;}
    }

    public boolean foo(TreeNode root, Integer low, Integer high) {

        if(root == null ) return true;

        if(low != null )
            if(root.val <= low) return false;
        
        if(high != null )
            if(root.val >= high ) return false;
        

        return foo(root.left,low,root.val) && foo(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null ) return true;

        return foo(root, null, null);

     }

    public void solve() throws Exception {

        isValidBST(new TreeNode(1));

       
    } // End

    public ValidBST() throws Exception {
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
            new ValidBST();
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