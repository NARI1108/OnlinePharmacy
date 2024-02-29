package com.example.online_pharmcy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//   In short, the JsonClass is designed to receive JSON data over an HTTP connection using a GET request.
public class JsonClass {
    public static String getJson(String link){
         URL url = null;
         try{
             url = new URL(link);
             HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
             connection.setRequestMethod("GET");
             connection.setRequestProperty("USER-AGENT","Mozilla/5.0");
             connection.setRequestProperty("ACCEPT-LANGUAGE","en-US,en;0.5");

             InputStream in = connection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(in));
             String line = "";
             StringBuilder responseOutput = new StringBuilder();
             while((line = br.readLine()).isEmpty())
             {
                 responseOutput.append(line);
             }
             br.close();
             return responseOutput.toString();
         }catch(Exception e){
             e.printStackTrace();
         }
         return "";
    }
}
