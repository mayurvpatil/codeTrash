import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class wc {

  public int solution(String s) {
    char[] c = s.toCharArray();

    Map<Character, Integer> map = new HashMap<>();

    for (char ch : c) {
      map.put(Character.valueOf(ch), map.getOrDefault(ch, 0) + 1);
    }

    Map<Character, Integer> sortedMap = new HashMap<>();

    map
      .entrySet()
      .stream()
      .sorted(Map.Entry.comparingByValue())
      .forEach(x -> sortedMap.put(x.getKey(), x.getValue()));

    int result = 0;
    boolean[] uniqueCount = new boolean[c.length + 1];
    for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
      if (uniqueCount[entry.getValue()]) { // true
        for (int i = entry.getValue(); i > 0; i--) {
          if (uniqueCount[i]) {
            result++;
          } else {
            uniqueCount[i] = true;
          }
        }
      } else { // false
        uniqueCount[entry.getValue()] = true;
      }
    }

    return result;
  }

  public wc() {
    System.out.println(solution("example"));
    /* try {
      String[] fileNames = new String[] { "sample.txt", "sample2.txt" };

      File file = null;
      Map<String, Integer> map = new HashMap<>();
      for (String f : fileNames) {
        file = new File(f);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        while ((st = br.readLine()) != null) {
          String[] tok = st.split(" ");

          for (String s : tok) {
            if (!s.isEmpty()) map.put(s, map.getOrDefault(s, 0) + 1);
          }
        }
        br.close();
      }

      for (Map.Entry<String, Integer> a : map.entrySet()) {
        System.out.println(a.getKey() + " ," + a.getValue());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } */
  }

  public static void main(String[] args) {
    new wc();
  }
}
