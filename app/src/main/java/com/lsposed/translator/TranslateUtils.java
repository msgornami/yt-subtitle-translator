package com.lsposed.translator;

import java.net.*;
import java.io.*;

public class TranslateUtils {
    public static String translate(String text) {
        try {
            String urlStr = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=fa&dt=t&q=" + URLEncoder.encode(text, "UTF-8");
            HttpURLConnection connection = (HttpURLConnection) new URL(urlStr).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = reader.readLine();
            reader.close();
            return response.split(""")[1];
        } catch (Exception e) {
            return "(ترجمه نشد)";
        }
    }
}