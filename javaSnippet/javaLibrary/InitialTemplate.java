package references;
import static java.lang.System.exit;
import java.io.*;
import java.util.*;

/**
 * @author mayurvpatil
 *
 * Date: ${CURRENT_YEAR} ${CURRENT_MONTH_NAME} ${CURRENT_DATE} | [ ${CURRENT_DAY_NAME} ]
 * Time: ${CURRENT_HOUR} : ${CURRENT_MINUTE} : ${CURRENT_SECOND} 
 */

public class InitialTemplate {

	public void solve() {

	} // End

	public InitialTemplate() throws Exception {
		boolean isMultipleTestCases = true;
		in = new InputReader(System.in);
		out = new PrintWriter(System.out);

		if (isMultipleTestCases) {
			int t = in.getInt();
			for (int i = 1; i <= t; ++i) {
				out.print("Case #" + i + ": ");
				solve();
			}
		} else {
			solve();
		}
		out.close();
	}

	public static void main(String[] args) {
		try {
			new InitialTemplate();
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

		public String getLine() {
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
			return Integer.parseInt(getLine());
		}

		public long getLong() {
			return Long.parseLong(getLine());
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
