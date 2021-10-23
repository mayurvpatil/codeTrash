import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Main {
 
  
  private static void parse(Double a, Double b) {
    
    Double rem = b - a;
    StringBuilder result = new StringBuilder();
    
    while(rem != 0) {
      
      boolean changed = false;
      
      if(rem >= 100.00) {
        
        // count all hundresds
        result.append("ONE HUNDRED,");
        rem -= 100.00;
        changed = true;
        
      } else if(rem >= 50.00) {
         result.append("FIFTY,");
         rem -= 50.00;
         changed = true;
      } else if(rem >= 20.00) {
        result.append("TWENTY,");
        rem -= 20.00;
         changed = true;
      } else if(rem >= 10.00) {
        result.append("TEN,");
        rem -= 10.00;
         changed = true;
      } else if(rem >= 5.00) {
        result.append("FIVE,");
        rem -= 5.00;
         changed = true;
      } else if(rem >= 2.00) {
        result.append("TWO,");
        rem -= 2.00;
         changed = true;
      } else if(rem >= 1.00) {
        result.append("ONE,");
        rem -= 1.00;
         changed = true;
      } else if(rem >= 0.50) {
        result.append("HALF DOLLAR,");
        rem -= 0.50;
         changed = true;
      } else if(rem >= 0.25) {
        result.append("QUARTER,");
        rem -= 0.25;
         changed = true;
      } else if(rem >= 0.10) {
        result.append("DIME,");
        rem -= 0.10;
         changed = true;
      } else if(rem >= 0.05) {
        result.append("NICKEL,");
        rem -= 0.05;
         changed = true;
      } else if(rem >= 0.01) {
        result.append("PENNY,");
        rem -= 0.01;
         changed = true;
      }
      
      if(!changed) {
        break;
      }
      
      
    } // end while
    
    result.deleteCharAt(result.length() -1 );
    
    System.out.println(result.toString());
    
  }
  
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line = "35;35";
      
      String[] token = line.split(";");
      
      Double a = Double.parseDouble(token[0]);
      Double b = Double.parseDouble(token[1]);
      
      if(a > b) {
        System.out.println("ERROR");
      } 
      
      if(a.equals(b) ) {
        System.out.println("ZERO");
      }
      
      Main.parse(a, b);
      
      
  }
}