package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CovidApi {
    public static void getData(){

        try{

            System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
            URL url = new URL("https://api.apify.com/v2/key-value-stores/tVaYRsPHLjNdNBu7S/records/LATEST?disableRedirect=true");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            InputStreamReader inputStreamReader = new InputStreamReader(con.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String output;
            while ((output = bufferedReader.readLine()) != null) {
                System.out.println(output);
            }
            con.disconnect();

        }
        catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }

    }
}
