import java.util.*;

public class ProductSort {

  public ProductSort() {
    int[] input = new int[] { 2, 3, 2, 2, 4, 5, 3, 1, 4, 5, 7 };

    int[] res = new int[input.length];

    Map<Integer, Integer> map = new HashMap<>();

    List<Integer> nums = new ArrayList<>();

    for (int num : input) {
      nums.add(num);
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    nums.sort(
      new Comparator<Integer>() {
        @Override
        public int compare(Integer n1, Integer n2) {
          if (map.get(n1) > map.get(n2)) {
            return 1;
          } else if (map.get(n1) < map.get(n2)) {
            return -1;
          }
          return n1 - n2;
        }
      }
    );
    int idx = 0;
    for (int item : nums) {
      res[idx++] = item;
    }

    for (int a : res) System.out.print(a + " ");
  }

  public static void main(String[] args) {
    new ProductSort();
  }
}
