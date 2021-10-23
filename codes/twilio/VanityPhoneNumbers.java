import java.util.*;

public class VanityPhoneNumbers {

  private static final Map<Character, Character> map;

  static {
    map = new HashMap<>();
    map.put('A', '2');
    map.put('B', '2');
    map.put('C', '2');
    map.put('D', '3');
    map.put('E', '3');
    map.put('F', '3');
    map.put('G', '4');
    map.put('H', '4');
    map.put('I', '4');
    map.put('J', '5');
    map.put('K', '5');
    map.put('L', '5');
    map.put('M', '6');
    map.put('N', '6');
    map.put('O', '6');
    map.put('P', '7');
    map.put('Q', '7');
    map.put('R', '7');
    map.put('S', '7');
    map.put('T', '8');
    map.put('U', '8');
    map.put('V', '8');
    map.put('W', '9');
    map.put('X', '9');
    map.put('Y', '9');
    map.put('Z', '9');
  }

  public static boolean kmpSearch(String pat, String txt) {
    int M = pat.length();
    int N = txt.length();

    int lps[] = new int[M];
    int j = 0; // index for pat[]

    computeLPSArray(pat, M, lps);

    int i = 0; // index for txt[]
    while (i < N) {
      if (pat.charAt(j) == txt.charAt(i)) {
        j++;
        i++;
      }
      if (j == M) {
        return true;
        //   System.out.println("Found pattern " + "at index " + (i - j));
        //   j = lps[j - 1];
      } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
        if (j != 0) j = lps[j - 1]; else i = i + 1;
      }
    }

    return false;
  }

  static void computeLPSArray(String pat, int M, int lps[]) {
    int len = 0;
    int i = 1;
    lps[0] = 0;

    while (i < M) {
      if (pat.charAt(i) == pat.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = len;
          i++;
        }
      }
    }
  }

  public static List<String> vanity(List<String> codes, List<String> numbers) {
    // steps
    // use a suffix to store numbers
    // traverse the tree find match

    // TWLO

    List<String> numCodes = getNumCodes(codes);

    Set<String> set = new HashSet<>();

    for (String num : numbers) {
      for (String numCode : numCodes) {
        if (!set.contains(num)) {
          if (kmpSearch(numCode, num)) {
            set.add(num);
          }
        }
      }
    }

    List<String> result = new ArrayList<>(set);

    Collections.sort(result);

    return result;
  }

  private static List<String> getNumCodes(List<String> codes) {
    List<String> numCodes = new ArrayList<>();

    for (String code : codes) {
      StringBuilder numCode = new StringBuilder();
      for (char c : code.toCharArray()) {
        numCode.append(map.get(c));
      }
      numCodes.add(numCode.toString());
    }

    return numCodes;
  }

  public static void main(String[] args) {
    List<String> codes = Arrays.asList("TWLO", "CODE", "HTCH");
    List<String> numbers = Arrays.asList(
      "+14157088956",
      "+1747481231242342342342380"
    );
    System.out.println(vanity(codes, numbers));
  }
}
