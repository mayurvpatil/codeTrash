import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.net.*;
import com.google.gson.*;


class Result {


    public static int getTotalDraw(String req) throws Exception {


        URL url = new URL(req);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();


        InputStream in  = (status < 200 || status > 299) ?connection.getErrorStream() : connection.getInputStream();

        BufferedReader br = new  BufferedReader(new InputStreamReader(in));

        String responseLine;
        StringBuffer content = new StringBuffer(); 

        while((responseLine = br.readLine()) != null) {
            content.append(responseLine);
        }

        br.close();
        connection.disconnect();

        JsonObject convertedObject = new Gson().fromJson(content.toString(), JsonObject.class);

        int drawCount = 0;
        JsonArray data = convertedObject.getAsJsonArray("data");
        if(data != null) drawCount = data.size();
        else return 0;
        return drawCount;
    }

  /* public static int getDrawCount(int year, int score) throws Exception {

            System.out.println(score);
            BufferedReader in = null;
        
            
            URL obj = new URL(String.format(endPoint + "?year=%d&team1goals=%d&team2goals=%d", year, score, score));

            System.out.println(obj.toString());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String response;
            StringBuffer content = new StringBuffer();
            int drawCount = 0;

            while ((response = in.readLine()) != null) {
                content.append(response);
            }

            in.close();
            con.disconnect();

            JsonObject convertedObject = new Gson().fromJson(content.toString(), JsonObject.class);

            JsonArray data = convertedObject.getAsJsonArray("data");
            if(data != null) drawCount = data.size();
            else return 0;
            return drawCount;
        
    }

    */

    public static int getNumDraws(int year) {
        
        String endPoint = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year;
        final int maxScore = 10;

        int drawCount = 0;
     //   int maxScore = 10;

        try {
            for(int i = 1; i <= 10; i++ ) {
                drawCount += getTotalDraw( String.format(endPoint + "&team1goals=%d&team2goals=%d", i , i));
            }

            return drawCount;
        } catch(Exception e) {
            e.printStackTrace();
            return -1;
        }
        
    }

    }

public class Solution {
    public static void main(String[] args) throws IOException {
        

        int result = Result.getNumDraws(2011);

        System.out.println(result);

     
    }
}
