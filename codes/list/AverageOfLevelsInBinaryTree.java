import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: 2020 December 27 | [ Sunday ]
 * Time: 20 : 04 : 53 
 */

/**
 * Public      - CodeForces
 * No modifier - CodeChef
 */

public class AverageOfLevelsInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode lastNode = root;
        TreeNode lastUpdated = root;

        List<Double> result = new ArrayList<>();

        if(root == null ) return result;

        queue.add(root) ;

        double sum = 0;
        double count = 0;

        while(!queue.isEmpty()) {

            TreeNode temp = queue.peek();
            queue.remove();

            sum += temp.val;
            count++;

            if(temp.left != null ) {
                queue.add(temp.left);
                lastUpdated = temp.left;
            }

            if(temp.right != null ) {
                queue.add(temp.right);
                lastUpdated = temp.right;
            }

            if(temp == lastNode) {
                lastNode = lastUpdated;
                result.add(sum/count);
                sum = 0 ;
                count = 0;
            }

        }
        return result;
    }



    public void solve() throws Exception {
       
    } // End

    public AverageOfLevelsInBinaryTree() throws Exception {
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
            new AverageOfLevelsInBinaryTree();
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
