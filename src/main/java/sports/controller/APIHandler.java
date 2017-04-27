package sports.controller;


import org.apache.tomcat.util.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Eddie on 4/27/17.
 */
public class APIHandler {
    private static StringBuilder json;

    private static void HTTPAuth(String pullURL) {
        try {
            URL url = new URL (pullURL);

            // Generate the authentication for requesting
            String name = "Eddie";
            String password = "cit591";
            String authString = name + ":" + password;
            byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
            String encoding = new String(authEncBytes);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   =
                    new BufferedReader (new InputStreamReader(content));
            String line;
            json = new StringBuilder();
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                json.append(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJSONResponse(String pullURL) {
        APIHandler.HTTPAuth(pullURL);
        return APIHandler.json.toString();
    }

}
