package org.aeo_day_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URI;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AocRequest {

    public List<String> fetch() throws IOException {
        List<String> numbers = new ArrayList<>();
        URI uri = URI.create(Constants.apiUrl);
        URL urlObject = uri.toURL();

        HttpsURLConnection connection = (HttpsURLConnection) urlObject.openConnection();
        connection.setRequestProperty("Cookie", Constants.cookies);
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            StringBuilder sb = new StringBuilder();
            Scanner sc = new Scanner(connection.getInputStream());
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            sc.close();
            String input = sb.toString().replaceAll("\\s+", "");
            int numberLength = 5;
            numbers = new ArrayList<>();

            for (int i = 0; i < input.length(); i += numberLength) {
                int end = Math.min(i + numberLength, input.length());
                numbers.add(input.substring(i, end));
            }
            System.out.println("SUCCSESS!");

        } else {
            System.out.println("ERROR");
        }
        return numbers;
    }

}
