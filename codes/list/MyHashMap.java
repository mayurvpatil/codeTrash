import java.util.*;

class MyHashMap {

  public class Bucket {

    int key;
    int value;

    public Bucket(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  ArrayList<Bucket>[] table = null;
  int hashValue = 2000;

  public MyHashMap() {
    table = new ArrayList[hashValue];

    for (int i = 0; i < hashValue; ++i) {
      table[i] = new ArrayList<Bucket>();
    }
  }

  public int getHashValues(int key) {
    return key % hashValue;
  }

  public void put(int key, int value) {
    List<Bucket> list = table[getHashValues(key)];

    for (Iterator<Bucket> iterator = list.iterator(); iterator.hasNext();) {
      Bucket bucket = iterator.next();

      if (bucket.key == key) {
        iterator.remove();
      }
    }

    list.add(new Bucket(key, value));
  }

  public int get(int key) {
    for (Bucket bucket : table[getHashValues(key)]) {
      if (bucket.key == key) {
        return bucket.value;
      }
    }
    return -1;
  }

  public void remove(int key) {
    List<Bucket> list = table[getHashValues(key)];

    for (Iterator<Bucket> iterator = list.iterator(); iterator.hasNext();) {
      Bucket bucket = iterator.next();
      if (bucket.key == key) {
        iterator.remove();
      }
    }
  }
}
