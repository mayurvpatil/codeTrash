import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Sample {

  /*
    Character repeating(String input) {

     
//acacvbgg

        if(input.length() == 0) {
           return null;
        }

        Map<Character, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < input.length(); i++ ) {
            Character ch = Character.valueOf(input.charAt(i));
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // {a=3, b =1, c = 1,d = 1 }
        // {a= 2, b= 2}

        for(Character ch : map.keySet()) {

            if(map.get(ch) == 1) {
                return ch;
            }

        }

        return null;
    }
    */

  /*
        super computer 
        M and B cores 

        3 apis 

        gate keeper - external cores from sc

        api - get core 
            - no core - -1 or null 

        api - release core 
            - release core 

        api - isCoreavailable - true / false

        
        array 
        Map 

        10core

        boolean 0 -- 9 

        false intial;

        int usedCore ( isCoreAvailable )
            getcore decrement 
            release increment 

    */

  // "divide array until we left we single leaf"
  // "leaf single we left until array devide"

  // naive approach

  // "abc xyz"
  // "zyx cba"
  // "xyz abc"

  private char[] reverse(char[] input) {
    if (input.length == 0 || input.length == 1) return input;

    // step 1
    int start = 0;
    int end = input.length - 1;

    while (start < end) {
      char temp = input[start];
      input[start] = input[end];
      input[end] = temp;
      start++;
      end--;
    }

    // step 2
    int i = 0;
    while (i < input.length) {
      int j = i;
      while (j < input.length && input[j] != ' ') {
        j++;
      }
      start = i;

      end = j;
      while (start < end) {
        char temp = input[start];
        input[start] = input[end];
        input[end] = temp;
        start++;
        end--;
      }

      i = j + 1;
    }
  }

  // randome

  // uniques data

  // 100 highest numberes

  /*

        1. divide file in to chunk 
        2. Max Heap 

    */

  // merge(int[] f, int[] s) return int[]

  // O(logn)

  // 2,1,6,3
  // 2,1   6,2
  // 2  1  6  2
  // 1 2   2  6
  //           j, i
  // 0 1 0

  // 2,3, 4    5,6,7
  //       i    j

  /*


    private void merge(int[] input, int start, int end, int mid ) {

        int i = start;
        int j = mid+1;

        while( i <= mid && j < end && i <= j) {

            if(input[i] > input[j]) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
            } else {
                i++;
            }
        }

    }


    private void divide(int[] input, int start, int end) {

        // exit case 
        if(start < end ) return;


        int mid = (start + end ) / 2;
        
        divide(input, start, mid);
        divide(input, mid+1, end);


        // merge(input, start)



    }
 
    */

  int coreCount = 10;
  int usedCore = 0;
  boolean[] cores = null;

  // list freeCores =

  public Sample() {
    cores = new boolean[coreCount];
  }

  public synchronized int getCore() {
    if (usedCore > coreCount) {
      return -1;
    }

    for (int i = 0; i < cores.length; i++) {
      if (!cores[i]) {
        usedCore++;
        cores[i] = true;
        return i;
      }
    }

    return -1;
  }

  public boolean releaseCore(int coreId) {
    if (!cores[coreId]) return true;

    usedCore--;
    cores[coreId] = false;

    return true;
  }

  public boolean isCoreAvailable() {
    if (usedCore < coreCount) return true;
    return false;
  }
}
/* function 
string input 
first non reapeating charater 
No repeating - no reapeating char

"a"
""
"aabcad"


char - 'a';



*/
